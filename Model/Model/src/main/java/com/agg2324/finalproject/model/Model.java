package com.agg2324.finalproject.model;

import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Model {

    SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();

    String user = "Testing";
    String password = "Testing";

    /*public boolean checkUserAndPassword(String user, String password){
      try(Session session = sessionfactory.openSession()){

          Query<AlumnosEntity> alumnosQuery = session.createQuery("from com.agg2324.finalproject.model.pojos.AlumnosEntity where user like '"+user+"' and password like '"+password+"'");
          List<AlumnosEntity> alumnos = alumnosQuery.list();
          return !alumnos.isEmpty();

      }catch(Exception e){
          System.out.println(e.getMessage());
      }
      return false;
    } */

    /*public List<String> dataStudents(){
        try(Session session = sessionfactory.openSession()){
            Query<AlumnosEntity> alumnosQuery = session.creteQuery("from com.agg2324.finalproject.model.pojos.alumnosEntity where user like '"+user+"' and password like '"+password+"'");
            List<AlunmosEntity> alunmos = alumnosQuery.list();
            List<String> listalumnos = new ArrayList<>();
            for(AlumnosEntity entity : alumnos){
                listalumnos.add(entity.getDni() + "  " + entity.getNombre + "  " + entity.getApellidos + "  " + entity.getEdad() + "  " + entity.getDireccion() + "  " + entity.getPais() + "  " + entity.getLocalidad() + "  " + entity.getCiudad() + "  " + entity.getFoto() + "  " + entity.);
            }
            return listalumnos;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


     */

}
