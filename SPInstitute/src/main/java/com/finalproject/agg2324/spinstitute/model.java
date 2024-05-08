package com.finalproject.agg2324.spinstitute;

import com.finalproject.agg2324.spinstitute.pojos.AlumnosEntity;
import com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity;
import com.finalproject.agg2324.spinstitute.pojos.CursosEntity;
import com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class model {
    SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

    public boolean checkUserAndPassword(String user, String password){
      try(Session session = sessionfactory.openSession()){
          Query<AlumnosEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AlumnosEntity where usuario like '"+user+"' and contraseña like '"+password+"'");
          List<AlumnosEntity> alumnos = alumnosQuery.list();
          return !alumnos.isEmpty();
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return false;
    }

    public String dataStudents(String user, String password){
        try(Session session = sessionfactory.openSession()){
            Query<AlumnosEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AlumnosEntity where usuario like '"+user+"' and contraseña like '"+password+"'");
            List<AlumnosEntity> alunmos = alumnosQuery.list();
            String alumnos = "";
            for(AlumnosEntity entity : alunmos){
                alumnos = entity.getDni() + "  " + entity.getNombre() + "  " + entity.getApellidos() + "  " + entity.getEdad() + "  " + entity.getDireccion() + "  " + entity.getLocalidad() + "  " + entity.getCiudad() + "  " + entity.getPais() + "  " + entity.getTelefono() + " " + entity.getEmail() + "  " + entity.getFechaNacimiento() + "  " + entity.getUsuario() + "  " + entity.getContraseña();
            }
            return alumnos;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void actualizarUsuario(String user, String direccion, String localidad, String ciudad, String telefono, String email, String contraseña){
        try(Session session = sessionfactory.openSession()){
            Query<AlumnosEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AlumnosEntity where usuario = '"+user+"'");
            List<AlumnosEntity> alumnosEntities = myQuery.list();
            Transaction transaction = session.beginTransaction();
            AlumnosEntity alumnos = alumnosEntities.get(0);
            alumnos.setDireccion(direccion);
            alumnos.setCiudad(ciudad);
            alumnos.setLocalidad(localidad);
            alumnos.setTelefono(telefono);
            alumnos.setEmail(email);
            alumnos.setContraseña(contraseña);
            session.update(alumnos);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

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

    public void cmbListAsignaturasC(List<String> asig, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> asigQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where idcursos = " + idCurso(nombre));
            List<AsignaturasEntity> asignaturasEntity = asigQuery.list();
            for (AsignaturasEntity asignaturas : asignaturasEntity){
                asig.add(asignaturas.getNombre());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void cmbListAsignaturasR(List<String> asig, String nombre, String dni){
        try(Session session = sessionfactory.openSession()){
            Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and n.estado = 'Aprobado' and n.estado = 'Convalidado' and a.idcursos = " + idCurso(nombre));
            List<AsignaturasEntity> notas = myQuery.list();
            for(AsignaturasEntity asignaturas : notas){
                asig.add(asignaturas.getNombre());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

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

    public String ckeckMatriculaCurso(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.agg2324.finalproject.model.pojos.MatriculaEntity dni = '"+dni+"' and idCurso = '"+idCurso(nombre)+"'");
            List<MatriculaEntity> matriculaEntity = matriculaQuery.list();
            MatriculaEntity matricula = matriculaEntity.get(0);
            if(Objects.equals(matricula.getEstado(), "Aprobado")){
                return "Aprobado";
            }else if(Objects.equals(matricula.getEstado(), "Renunciado") || Objects.equals(matricula.getEstado(), "Suspendido")){
                modificarMatricula(dni, nombre);
                return "Actualizado";
            }else if(matriculaEntity.isEmpty()){
                if(ckeckMatriculasCursadas(dni)){
                    insertMatricula(dni, nombre);
                    return "Insertado";
                }else{
                    return "Cursando";
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean ckeckMatriculasCursadas(String Dni){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity dni = '"+Dni+"' and estado = 'Cursando'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<String> selectAsignaturas(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.dni = '"+dni+"' and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            CursosEntity curso = cursosEntities.get(0);
            List<String> listasig = new ArrayList<>();
            Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity where idcursos = " + curso.getIdCurso());
            List<AsignaturasEntity> asig = myQuery.list();
            for(AsignaturasEntity asignaturas : asig){
                listasig.add(asignaturas.getNombre());
            }
            return listasig;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<String> selectAsignaturasFiltradasPorEstado(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.dni = '"+dni+"' and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            List<String> listasig = new ArrayList<>();
            for(CursosEntity cursos : cursosEntities){
                Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and a.idcursos = '"+cursos.getIdCurso()+"' and n.estado != 'Convalidado' and n.estado != 'Aprobado'");
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

    public void insertMatricula(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = new MatriculaEntity();
            matricula.setDni(dni);
            matricula.setIdCurso(idCurso(nombre));
            matricula.setFechaMatricula(Date.valueOf(LocalDate.now()));
            matricula.setRepetidor(false);
            matricula.setEstado("Cursando");
            session.save(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void modificarMatricula(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity where dni = '"+dni+"' and idCurso = " + idCurso(nombre));
            List<MatriculaEntity> matriculaEntities = myQuery.list();
            Transaction transaction = session.beginTransaction();
            MatriculaEntity matricula = matriculaEntities.get(0);
            matricula.setFechaMatricula(Date.valueOf(LocalDate.now()));
            matricula.setEstado("Cursando");
            matricula.setRepetidor(true);
            session.save(matricula);
            transaction.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
