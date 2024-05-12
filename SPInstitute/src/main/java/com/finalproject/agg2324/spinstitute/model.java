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
                alumnos = entity.getDni() + "  " + entity.getNombre() + "  " + entity.getApellidos() + "  " + entity.getEdad() + "  " + entity.getDireccion() + "  " + entity.getLocalidad() + "  " + entity.getCiudad() + "  " + entity.getPais() + "  " + entity.getTelefono() + " " + entity.getEmail() + "  " + entity.getDate() + "  " + entity.getUsuario() + "  " + entity.getContrasenya();
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
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity dni = '"+dni+"' and estado = 'Aprobado' and nivel = " + 2);
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
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity dni = '"+Dni+"' and estado = 'Cursando'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    //funcion que depende del estado de una matricula me hace diferentes operaciones.
    /*public String checkMatriculaCurso(String dni, String nombre, String turno, int nivel){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.agg2324.finalproject.model.pojos.MatriculaEntity dni = '"+dni+"' and idCurso = '"+idCurso(nombre)+"' and nivel = " + nivel);
            List<MatriculaEntity> matriculaEntity = matriculaQuery.list();
            MatriculaEntity matricula = matriculaEntity.get(0);
            if(Objects.equals(matricula.getEstado(), "Aprobado")){
                return "Aprobado";
            }else if(Objects.equals(matricula.getEstado(), "Renunciado") || Objects.equals(matricula.getEstado(), "Suspendido")){
                modificarMatricula(dni, nombre, turno, nivel);
                return "Actualizado";
            }else if(matriculaEntity.isEmpty()){
                if(checkMatriculasCursadas(dni)){
                    insertMatricula(dni, nombre, turno, nivel);
                    return "Insertado";
                }else{
                    return "Cursando";
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }*/

    //funcion que dado un nombre del curso, me saca su id
    public int idCurso(String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> cursoQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity Nombre like '"+nombre+"'");
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
    //ARREGLAR CODIGO
    /*public void modificarMatricula(String dni, String nombre, String turno, int nivel){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where dni = '"+dni+"' and idcurso = " + idCurso(nombre));
            List<MatriculaEntity> matriculaEntities = myQuery.list();
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = matriculaEntities.get(0);
            matricula.setFechamatricula(Date.valueOf(LocalDate.now()));
            matricula.setEstado("Cursando");
            matricula.setRepetidor(true);
            matricula.setTurno(turno);
            matricula.setNivel(nivel);
            session.update(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    //funcion que inserta una matricula
    //ARREGLAR CODIGO
    /*public void insertMatricula(String dni, String nombre, String turno, int nivel){
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = new MatriculaEntity();
            matricula.setDni(dni);
            matricula.setIdcurso(idCurso(nombre));
            matricula.setFechamatricula(Date.valueOf(LocalDate.now()));
            matricula.setRepetidor(false);
            matricula.setEstado("Cursando");
            matricula.setTurno(turno);
            session.save(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

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
    //funcion que rellena una lista para posteriormente rellenar un combobox
    public void cmbListAsignaturasC(List<String> asig, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where cursos = " + idCurso(nombre));
            List<AsignaturasEntity> asignaturasEntity = asigQuery.list();
            for (AsignaturasEntity asignaturas : asignaturasEntity){
                asig.add(asignaturas.getNombre());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que busca las asignaturas de un curso
    //ARREGLAR CODIGO
    /*public List<String> selectAsignaturas(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.dni = '"+dni+"' and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            CursosEntity curso = cursosEntities.get(0);
            List<String> listasig = new ArrayList<>();
            Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where cursos = " + curso.getIdCurso());
            List<AsignaturasEntity> asig = myQuery.list();
            for(AsignaturasEntity asignaturas : asig){
                listasig.add(asignaturas.getNombre());
            }
            return listasig;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }*/

    //funcion que devuelve si se puede convalidar una asignatura
    //ARREGLAR CODIGO
    /*public boolean convalidarAsignatura(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            //Buscar esa asignatura en otros cursos
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where nombre = '"+nombre+"'");
            List<AsignaturasEntity> asignaturasEntities = asigQuery.list();
            if(asignaturasEntities.size() > 1){
                for(AsignaturasEntity entity : asignaturasEntities){
                    Query<NotasEntity> notasQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where dni = '"+dni+"' and asignatura = " + entity.getIdAsignaturas());
                    List<NotasEntity> notasEntities = notasQuery.list();
                    if(!notasEntities.isEmpty()){
                        for(NotasEntity notasEntity:notasEntities){
                            if(notasEntity.getEstado() == "Aprobado"){
                                return true;
                            }
                        }
                    }
                }

            }else{
                return false;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }*/

    //funcion que devuelve el id de la asignatura de una lista de nombre de asignaturas
    private List<Integer> idAsignatura(List<String> nombre){
        try(Session session = sessionfactory.openSession()){
            List<Integer> ids = new ArrayList<>();
            for(String asignaturas : nombre){
                Query<AsignaturasEntity> asigquery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity nombre like '"+asignaturas+"'");
                List<AsignaturasEntity> asignatura = asigquery.list();
                for(AsignaturasEntity asig:asignatura){
                    ids.add(asig.getIdAsignaturas());
                }
            }
            return ids;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    //funcion que relaiza las convalidaciones
    //ARREGLAR CODIGO
    /*public void updateNotasConvalidacion(String dni, List<String> nombres){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where dni = '"+dni+"' and estado = 'Cursando'");
            MatriculaEntity matriculaEntity = matQuery.uniqueResult();
            for(int i : Objects.requireNonNull(idAsignatura(nombres))){
                Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where cursos = " + matriculaEntity.getIdcurso() +" and idAsignaturas = " + i);
                AsignaturasEntity asignaturasEntity = asigQuery.uniqueResult();
                Query<NotasEntity> notasQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.NotasEntity where asignatura = " + asignaturasEntity.getIdAsignaturas());
                List<NotasEntity> notasEntities = notasQuery.list();
                Transaction transaction = session.beginTransaction();
                NotasEntity notas = notasEntities.get(0);
                notas.setEstado("Convalidado");
                session.update(notas);
                transaction.commit();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    //Parte Ventana Renuncia--------------------------------------------------------------------------------------------------------------------------------------
    //ARREGLAR CODIGO
    //funcion que rellena una lista para posteriormente rellenar un combobox
   /*public void cmbListAsignaturasR(List<String> asig, String nombre, String dni){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and n.estado = 'Aprobado' and n.estado = 'Convalidado' and a.cursos = " + idCurso(nombre));
            List<AsignaturasEntity> notas = myQuery.list();
            for(AsignaturasEntity asignaturas : notas){
                asig.add(asignaturas.getNombre());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    //funcion que busca asignaturas filtradas por estados que no sean convalidados o aprobados
    //ARREGLAR CODIGO
    /*public List<String> selectAsignaturasFiltradasPorEstado(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.dni = '"+dni+"' and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            List<String> listasig = new ArrayList<>();
            for(CursosEntity cursos : cursosEntities){
                Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and a.cursos = '"+cursos.getIdCurso()+"' and n.estado != 'Convalidado' and n.estado != 'Aprobado'");
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
    }*/

    //Parte Ventana Pagos-----------------------------------------------------------------------------------------------------------------------------------------
    //funcion que realiza la insercion en la tabla de pagos
    /*public void insertarPago(String dni, String operacion, String cuenta, BigInteger cantidad){
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            PagosEntity pagosEntity = new PagosEntity();
            pagosEntity.set(dni);
            pagosEntity.setOperacion(operacion);
            pagosEntity.setCuenta(cuenta);
            pagosEntity.setCantidad(cantidad);
            session.save(pagosEntity);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/
}
