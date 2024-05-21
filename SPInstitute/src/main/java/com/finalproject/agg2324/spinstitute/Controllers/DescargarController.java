package com.finalproject.agg2324.spinstitute.Controllers;

import com.finalproject.agg2324.spinstitute.Documentos;
import javafx.fxml.FXML;

import javax.swing.*;
import java.io.*;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class DescargarController {

    @FXML
    public TextArea txttemporal;
    @FXML
    private TextArea txtadoc;
    @FXML
    private ImageView btnguardar;

    Documentos docs = new Documentos();

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

    //funcion que recoge los datos de la pantalla principal
    public void recogerDatos(String datos, List<String> asig){
        String[] withoutspace = datos.split("  ");
        txtadoc.setText(docs.docConvalidacion(withoutspace[0], withoutspace[1], withoutspace[2], asig, withoutspace[3]));
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

    }

    //funcion para cargar el texto de la renuncia
    public void cargarTextoRenuncia(){

    }

    //funcion para cargar el texto de la convalidación
    public void cargarTextoConvalidar(){

    }

    //funcion para cargar el texto de la baja
    public void cargarTextoBaja(){

    }




}
