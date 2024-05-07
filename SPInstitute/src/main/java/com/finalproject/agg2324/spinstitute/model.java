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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void actualizarUsuario(String user, String direccion, String ciudad, String localidad, String telefono, String email, String contraseña, byte[] foto){
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

    public String idCurso(String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> cursoQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity Nombre like '"+nombre+"'");
            List<CursosEntity> curso = cursoQuery.list();
            for(CursosEntity cursos:curso){
                return cursos.getIdCurso();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean ckeckMatricula(String dni, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.agg2324.finalproject.model.pojos.MatriculaEntity dni = '"+dni+"' and estado = 'Aprobado' and idCurso = '"+idCurso(nombre)+"'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
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
            List<String> listasig = new ArrayList<>();
            for(CursosEntity cursos : cursosEntities){
                Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and n.asignatura = '"+cursos.getIdasignaturas()+"'");
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

    public List<String> selectAsignaturasFiltradasPorEstado(String dni){
        try(Session session = sessionfactory.openSession()){
            Query<CursosEntity> mycurso = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.CursosEntity c join fetch c.matriculas m where m.dni = '"+dni+"' and m.estado = 'Cursando'");
            List<CursosEntity> cursosEntities = mycurso.list();
            List<String> listasig = new ArrayList<>();
            for(CursosEntity cursos : cursosEntities){
                Query<AsignaturasEntity> myQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AsignaturasEntity a join fetch a.notas n where n.dni = '"+dni+"' and n.asignatura = '"+cursos.getIdasignaturas()+"' and n.estado != 'Convalidado' and n.estado != 'Aprobado'");
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
}
