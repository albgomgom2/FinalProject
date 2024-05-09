package com.finalproject.agg2324.spinstitute;

import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    Documentos doc = new Documentos();

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
    //funcion para cargar el texto del titulo
    public void cargarTextoTitulo(){
        txtadoc.setText(doc.documentoTitulo());
    }
    //funcion para cargar el texto de la renuncia
    public void cargarTextoRenuncia(){
        txtadoc.setText(doc.documentoRenuncia());
    }

    //funcion para cargar el texto de la convalidacion
    public void cargarTextoConvalidar(){
        txtadoc.setText(doc.documentoConvalidar());
    }

    //funcion para cargar el texto de la baja
    public void cargarTextoBaja(){
        txtadoc.setText(doc.documentoBaja());
    }

    //funcion para cargar el texto de la matricula
    public void cargarTextoMatricula(){
        txtadoc.setText(doc.documentoMatricula());
    }
}
