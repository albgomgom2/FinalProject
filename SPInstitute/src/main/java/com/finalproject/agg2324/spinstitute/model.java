package com.finalproject.agg2324.spinstitute;

import com.finalproject.agg2324.spinstitute.pojos.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class model {
    /*SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

    String user = "Testing";
    String password = "Testing";*/

    /*public boolean checkUserAndPassword(String user, String password){
      try(Session session = sessionfactory.openSession()){
          Query<AlunmosEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AlunmosEntity a join fetch a.usuarios u where u.usuarios like '"+user+"' and u.contraseña like '"+password+"'");
          List<AlunmosEntity> alumnos = alumnosQuery.list();
          return !alumnos.isEmpty();
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return false;
    }*/

    /*public List<String> dataStudents(String user, String password, String nombre){
        try(Session session = sessionfactory.openSession()){
            Query<AlunmosEntity> alumnosQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.AlunmosEntity a join fetch a.usuarios u where u.usuario like '"+user+"' and u.contraseña like '"+password+"'");
            List<AlunmosEntity> alunmos = alumnosQuery.list();
            List<String> listalumnos = new ArrayList<>();
            for(AlunmosEntity entity : alunmos){
                listalumnos.add(entity.getDni() + "  " + entity.getNombre() + "  " + entity.getApellidos() + "  " + entity.getEdad() + "  " + entity.getTelefono() + "  " + entity.getDireccion() + "  " + entity.getPais() + "  " + entity.getLocalidad() + "  " + entity.getCiudad() + "  " + entity.getFoto() + "  " + entity.getIdCurso() + "  " + entity.getUsuario() + "  " + entity.getContraseña());
            }
            return listalumnos;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }*/

   /* public void cmbListCursos(List<String> cursos){
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
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.agg2324.finalproject.model.pojos.MatriculaEntity dni = '"+dni+"' and tipo = 'Aprobado' and idCurso = '"+idCurso(nombre)+"'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean ckeckMatriculasCursadas(String Dni){
        try(Session session = sessionfactory.openSession()){
            Query<MatriculaEntity> matriculaQuery = session.createQuery("from com.finalproject.agg2324.spinstitute.pojos.MatriculaEntity dni = '"+Dni+"' and tipo = 'Cursando'");
            List<MatriculaEntity> matricula = matriculaQuery.list();
            return matricula.isEmpty();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }*/

    /*public static List<String> selectAsignaturas(String dni){
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
    }*/

    /*public static List<String> selectAsignaturasFiltradasPorEstado(String dni){
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
    }*/
}
