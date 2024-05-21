package com.finalproject.agg2324.spinstitute;

import java.util.List;

public class Documentos {
    private String instituto = "IES MARE NOSTRUM";
    private String grado = "GRADO SUPERIOR";

    private String director = "Persona1";

    //funciones que devuelven la estructura que tendran los diferentes ficheros
    public String docConvalidacion(String dni, String nombre, String apellido, List<String> asignaturas, String curso){

        StringBuilder texto1 = new StringBuilder("D/Dª " + director + ", Director del centro públic " + instituto + ", una vez\nexaminada la documentación presentada por D. " + nombre + " " + apellido + " Documento Nacional de\n"
                + "Identidad Nº 0" + dni + " solicitando la convalidacion de estudios de Formación Profesional\ncorrespondientes al ciclo formativo (1) " + curso + "\nde (2) " + grado + " cuyo currículo está establecido en la Comunidad Valenciana por (3)\n"
                + "ORDE 58/2012 de 5 de setembre DOCV 24/9/12 con sus estudios de: Módulo profesionales CF\nLOE con acreditacion de unidades de competencia del Catálogo Nacional de Cualificaciones\nProfesionales\n\n\n                               Resuelve:\n\nRECONOCERLE la convalidación del siguiente módulo profesional del ciclo formativo\ncorrespondiente:\n");
        for(String asignatura : asignaturas){
            texto1.append(asignatura).append("\n");
        }

        return texto1.toString().toString();
    }


}
