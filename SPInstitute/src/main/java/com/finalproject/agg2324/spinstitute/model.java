package com.finalproject.agg2324.spinstitute;

import com.finalproject.agg2324.spinstitute.pojos.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class model {
    SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

    //Parte Ventana Inicio de sesion------------------------------------------------------------------------------------------------------------------------------
    // funcion que comprueba si existe el usuario y la contraseña
    public boolean checkUserAndPassword(String user, String password){
      try(Session session = sessionfactory.openSession()){
          Query<StudentsEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.StudentsEntity where usuario = '"+user+"' and contrasenya = '"+password+"'");
          List<StudentsEntity> alumnos = alumnosQuery.list();
          return alumnos.isEmpty();
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return false;
    }

    //funcion que recoge los datos del usuario y los devuelve a la pantalla principal
    public String dataStudents(String user, String password){
        try(Session session = sessionfactory.openSession()){
            Query<StudentsEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.StudentsEntity where usuario like '"+user+"' and contrasenya like '"+password+"'");
            List<StudentsEntity> alunmos = alumnosQuery.list();
            String alumnos = "";
            for(StudentsEntity entity : alunmos){
                alumnos = entity.getDni() + "  " + entity.getNombre() + "  " + entity.getApellidos() + "  " + entity.getEdad() + "  " + entity.getDireccion() + "  " + entity.getLocalidad() + "  " + entity.getCiudad() + "  " + entity.getPais() + "  " + entity.getTelefono() + "  " + entity.getEmail() + "  " + entity.getDate() + "  " + entity.getUsuario() + "  " + entity.getContrasenya();
            }
            return alumnos;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //funcion que comprueba si tenemos algun curso de nivel 2 aprobado
    public boolean checkCursosAprobados(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where idalumno = "+obtenerIdAlumno(dni)+" and estado = 'Aprobado' and nivel = " + 2);
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //Parte de Ventana Matricula----------------------------------------------------------------------------------------------------------------------------------
    // funcion que rellena una lista para posteriormente rellenar un combobox
    public void cmbListCursos(List<String> cursos){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> cursosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity");
            List<CursosEntity> cursoEntity = cursosQuery.list();
            for(CursosEntity curso : cursoEntity){
                cursos.add(curso.getNombre());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que comprueba si el usuairo esta cursando algun curso
    public boolean checkMatriculasCursadas(String Dni){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where idalumno = "+obtenerIdAlumno(Dni)+" and estado = 'Cursando'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //funcion que depende del estado de una matrícula me hace diferentes operaciones.
    public String checkMatriculaCurso(String dni, String nombre, String turno, int nivel){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where idalumno = "+obtenerIdAlumno(dni)+" and idcurso = "+idCurso(nombre)+" and nivel = " + nivel);
            List<MatriculaEntity> matriculaEntity = matriculaQuery.list();
            if(matriculaEntity.isEmpty()){
                if(checkMatriculasCursadas(dni)){
                    insertMatricula(dni, nombre, turno, nivel);
                    insertarNotasAsignatura(dni, nombre);
                    return "Insertado";
                }else{
                    return "Otra Matricula";
                }
            }else{
                MatriculaEntity matricula = matriculaEntity.get(0);
                if(Objects.equals(matricula.getEstado(), "Aprobado")){
                    return "Aprobado";
                }else if(Objects.equals(matricula.getEstado(), "Renunciado") || Objects.equals(matricula.getEstado(), "Suspendido")){
                    modificarMatricula(dni, nombre, turno);
                    modificarNotasRepetidor(dni);
                    return "Actualizado";
                }else{
                    return "Cursando";
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //funcion que dado un dni te devuelve el id de ese alumno
    public Integer obtenerIdAlumno(String dni){
        try(Session session = sessionfactory.openSession()){
            Integer result = 0;
            Query<StudentsEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.StudentsEntity where dni = '"+dni+"'");
            List<StudentsEntity> students = myQuery.list();
            for(StudentsEntity student : students){
                result = student.getIdalumno();
            }
            return result;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    //funcion que dado un nombre del curso, me saca su id
    public int idCurso(String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> cursoQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity where nombre like '"+nombre+"'");
            List<CursosEntity> curso = cursoQuery.list();
            for(CursosEntity cursos:curso){
                return cursos.getIdCurso();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    //funcion que modifica una matricula
    public void modificarMatricula(String dni, String nombre, String turno){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where idalumno = " + obtenerIdAlumno(dni) + " and idcurso = " + idCurso(nombre) + " and estado = 'Suspendido' or estado = 'Renunciado'");
            List<MatriculaEntity> matriculaEntities = myQuery.list();
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = matriculaEntities.get(0);
            matricula.setFechamatricula(Date.valueOf(LocalDate.now()));
            matricula.setEstado("Cursando");
            matricula.setRepetidor(true);
            matricula.setTurno(turno);
            session.update(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que inserta una matricula
    public void insertMatricula(String dni, String nombre, String turno, int nivel){
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = new MatriculaEntity();
            matricula.setIdalumno(obtenerIdAlumno(dni));
            matricula.setIdcurso(idCurso(nombre));
            matricula.setFechamatricula(Date.valueOf(LocalDate.now()));
            matricula.setRepetidor(false);
            matricula.setEstado("Cursando");
            matricula.setNivel(nivel);
            matricula.setTurno(turno);
            session.save(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion para insertar las notas del alumno de un curso
    private void insertarNotasAsignatura(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.cursos c where c.idCurso = " + idCurso(nombre));
            List<AsignaturasEntity> asignaturasEntities = myQuery.list();
            for(AsignaturasEntity asignaturas : asignaturasEntities){
                Transaction transaction = session.beginTransaction();
                NotasEntity notas = new NotasEntity();
                notas.setIdalumno(obtenerIdAlumno(dni));
                notas.setActivo(true);
                notas.setEstado("Cursando");
                notas.setAsignatura(asignaturas.getIdAsignaturas());
                session.save(notas);
                transaction.commit();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que modifica el estado de las notas de un alumno repetidor
    private void modificarNotasRepetidor(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where idalumno = "+obtenerIdAlumno(dni)+" and estado = 'Cursando'");
            MatriculaEntity matriculaEntity = matQuery.uniqueResult();
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.cursos c where c.idCurso = " + matriculaEntity.getIdcurso());
            List<AsignaturasEntity> asignaturasEntities = asigQuery.list();
            for(AsignaturasEntity asignaturas : asignaturasEntities){
                Query<NotasEntity> notasQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where asignatura = " + asignaturas.getIdAsignaturas() + " and idalumno = " + obtenerIdAlumno(dni) + " and estado = 'Suspendido' or estado = 'Renunciado'");
                List<NotasEntity> notasEntities = notasQuery.list();
                Transaction transaction = session.beginTransaction();
                NotasEntity notas = notasEntities.get(0);
                notas.setEstado("Cursando");
                session.update(notas);
                transaction.commit();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Parte Ventana Modificar Usuario-----------------------------------------------------------------------------------------------------------------------------
    //funcion que actualiza solo algunos de los datos del usuario
    public void actualizarUsuario(String user, String direccion, String localidad, String ciudad, String telefono, String email, String contraseña){
        try(Session session = sessionfactory.openSession()){
            Query<StudentsEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.StudentsEntity where usuario = '"+user+"'");
            List<StudentsEntity> alumnosEntities = myQuery.list();
            Transaction transaction = session.beginTransaction();
            StudentsEntity alumnos = alumnosEntities.get(0);
            alumnos.setDireccion(direccion);
            alumnos.setCiudad(ciudad);
            alumnos.setLocalidad(localidad);
            alumnos.setTelefono(telefono);
            alumnos.setEmail(email);
            alumnos.setContrasenya(contraseña);
            session.update(alumnos);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



    //Parte Ventana Convalidacion---------------------------------------------------------------------------------------------------------------------------------
    //funcion que busca las asignaturas de un curso
    public List<String> selectAsignaturas(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.idalumno = "+obtenerIdAlumno(dni)+" and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            CursosEntity curso = cursosEntities.get(0);
            List<String> listasig = new ArrayList<>();
            for(AsignaturasEntity asignaturas : curso.getAsignaturas()){
                listasig.add(asignaturas.getNombre());
            }
            return listasig;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //funcion que devuelve el nombre del curso en el que esta cursado
    public String nombreCursomatricula(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.idalumno = " + obtenerIdAlumno(dni) + " and m.estado = 'Cursando'");
            CursosEntity curso = myQuery.uniqueResult();
            return curso.getNombre();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    //funcion que devuelve si se puede convalidar una asignatura
    public boolean convalidarAsignatura(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where nombre = '"+nombre+"'");
            List<AsignaturasEntity> asignaturasEntities = asigQuery.list();
            if(asignaturasEntities.size() == 1){
                for(AsignaturasEntity entity : asignaturasEntities){
                    Query<NotasEntity> notasQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where idalumno = "+obtenerIdAlumno(dni)+" and asignatura = " + entity.getIdAsignaturas() +" and estado != 'Aprobado'");
                    List<NotasEntity> notasEntities = notasQuery.list();
                    if(!notasEntities.isEmpty()){
                        Query<NotasEntity> notasEntityQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where idalumno = "+obtenerIdAlumno(dni)+" and asignatura = " + entity.getIdAsignaturas() +" and estado = 'Aprobado'");
                        List<NotasEntity> notasEntities2 = notasEntityQuery.list();
                        for(NotasEntity notas:notasEntities2){
                            if(Objects.equals(notas.getEstado(), "Aprobado")){
                                return true;
                            }
                        }
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //funcion que devuelve el id de la asignatura de una lista de nombre de asignaturas
    private Integer idAsignatura(String nombre){
        try(Session session = sessionfactory.openSession()){
                Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where nombre = '"+nombre+"'");
                AsignaturasEntity asignaturasEntity = asigQuery.uniqueResult();
                return asignaturasEntity.getIdAsignaturas();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }

    //funcion que relaiza las convalidaciones
    public void updateNotasConvalidacion(String dni, String nombres){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where idAsignaturas = " + idAsignatura(nombres));
            AsignaturasEntity asignaturasEntity = asigQuery.uniqueResult();
            Query<NotasEntity> notasQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where asignatura = " + asignaturasEntity.getIdAsignaturas() + " and estado = 'Cursando'");
            List<NotasEntity> notasEntities = notasQuery.list();
            Transaction transaction = session.beginTransaction();
            NotasEntity notas = notasEntities.get(0);
            notas.setEstado("Convalidado");
            session.update(notas);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Parte Ventana Renuncia--------------------------------------------------------------------------------------------------------------------------------------
    //funcion que busca asignaturas filtradas por estados que no sean convalidados o aprobados
    public List<String> selectAsignaturasFiltradasPorEstado(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.idalumno = "+obtenerIdAlumno(dni)+" and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            List<String> listasig = new ArrayList<>();
            for(CursosEntity cursos : cursosEntities){
                Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.idalumno = "+obtenerIdAlumno(dni)+" and a.cursos = "+cursos.getIdCurso()+" and n.estado != 'Convalidado' and n.estado != 'Aprobado'");
                List<AsignaturasEntity> notas = myQuery.list();
                for(AsignaturasEntity asignaturas : notas){
                    listasig.add(asignaturas.getNombre());
                }
            }
            return listasig;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Parte Ventana Pagos-----------------------------------------------------------------------------------------------------------------------------------------
    //funcion que realiza la insercion en la tabla de pagos
    public void insertarPago(String dni, String operacion, String cuenta, BigInteger cantidad){
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            PagosEntity pagosEntity = new PagosEntity();
            pagosEntity.setIdalumno(obtenerIdAlumno(dni));
            pagosEntity.setOperacion(operacion);
            pagosEntity.setCuenta(cuenta);
            pagosEntity.setCantidad(cantidad);
            session.save(pagosEntity);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
