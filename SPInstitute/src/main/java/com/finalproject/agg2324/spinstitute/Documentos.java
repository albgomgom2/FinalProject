package com.finalproject.agg2324.spinstitute;

import java.util.List;

public class Documentos {
    //funciones que devuelven la estructura que tendran los diferentes ficheros
    public String docConvalidacion(String dni, String nombre, String apellido, List<String> asignaturas){
        String texto1 = "El alumno " + nombre + " " + apellido + " con dni " + dni + "\nha sido convalidado de las asignaturas ";
        for(String asignatura : asignaturas){
            texto1 = texto1 + asignatura + ", ";
        }
        texto1 = texto1 + "\nprueba final";
        return texto1;
    }

    public String docRenuncia(String dni, String nombre, String apellido, List<String> asignaturas){
        String texto1 = "El alumno " + nombre + " " + apellido + " con dni " + dni + "\nha sido convalidado de las asignaturas ";
        for(String asignatura : asignaturas){
            texto1 = texto1 + asignatura + ", ";
        }
        texto1 = texto1 + "\nprueba final";
        return texto1;
    }

    public String docTitulo(String dni, String nombre, String apellido, String curso){
        String texto1 = "El alumno " + nombre + " " + apellido + " con dni " + dni + "\nha sido convalidado de las asignaturas " + curso;
        return texto1;
    }

    public String docBaja(String dni, String nombre, String apellido, String curso){
        String texto1 = "El alumno " + nombre + " " + apellido + " con dni " + dni + "\nha sido convalidado de las asignaturas " + curso;
        return texto1;
    }
}
