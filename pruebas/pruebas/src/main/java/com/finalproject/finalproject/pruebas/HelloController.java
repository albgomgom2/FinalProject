package com.finalproject.finalproject.pruebas;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;

import static jdk.javadoc.internal.doclets.toolkit.util.DocPath.parent;


public class HelloController {
    @FXML
    private Label lbllabel;

    @FXML
    private void cargarimagen(){
        JFileChooser d = new JFileChooser();
        d.showOpenDialog(null);

        lbllabel.setText(d.getSelectedFile().getName());
    }
}