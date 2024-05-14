package com.finalproject.agg2324.spinstitute.Controllers;

import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;

import javafx.scene.image.ImageView;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DescargarController {

    @FXML
    private TextArea txtadoc;
    @FXML
    private ImageView btnguardar;

    private Controller controller;

    //funcion que escribe los datos en un documento
    public void guardarDocumento(String cadena, File archivo){
        FileWriter escribir;
        try{
            escribir = new FileWriter(archivo, true);
            escribir.write(cadena);
            escribir.close();
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar, escribe un nombre para el archivo");
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }

    //funcion que guarda el documento en una ruta elegida
    @FXML
    private void guardarComo(){
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = guardar.getSelectedFile();
        guardarDocumento(txtadoc.getText(), archivo);

        Node n = btnguardar.getScene().getRoot();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

    //funcion para cargar el texto del título
    public void cargarTextoTitulo(){
        txtadoc.setText(leerArchivo("d:\\agomis\\Desktop\\Nueva carpeta\\FinalProject\\FinalProject\\SPInstitute\\src\\main\\resources\\Documentos\\DocumentoConvalidar.txt"));
    }

    //funcion para cargar el texto de la renuncia
    public void cargarTextoRenuncia(){
        txtadoc.setText(leerArchivo("d:\\agomis\\Desktop\\Nueva carpeta\\FinalProject\\FinalProject\\SPInstitute\\src\\main\\resources\\Documentos\\DocumentoConvalidar.txt"));
    }

    //funcion para cargar el texto de la convalidación
    public void cargarTextoConvalidar(){
        txtadoc.setText(leerArchivo("d:\\agomis\\Desktop\\Nueva carpeta\\FinalProject\\FinalProject\\SPInstitute\\src\\main\\resources\\Documentos\\DocumentoConvalidar.txt"));
    }

    //funcion para cargar el texto de la baja
    public void cargarTextoBaja(){
        txtadoc.setText(leerArchivo("d:\\agomis\\Desktop\\Nueva carpeta\\FinalProject\\FinalProject\\SPInstitute\\src\\main\\resources\\Documentos\\DocumentoConvalidar.txt"));
    }


    public String leerArchivo(String url){
        try{
            File leer = new File(url);
            int tamanyo = (int)leer.length();
            int caracteres = 0;
            FileReader in = new FileReader(leer);
            char[] data = new char[tamanyo];
            while(in.ready()){
                caracteres += in.read(data, caracteres, tamanyo - caracteres);
            }
            in.close();
            return new String(data, 0, caracteres);
        }catch(Exception e){
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
            return e.toString();
        }
    }


}
