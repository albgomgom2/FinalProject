package com.finalproject.agg2324.spinstitute;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Controller {
    Alert alertA = new Alert(Alert.AlertType.CONFIRMATION);
    @FXML
    private GridPane grpDatosUsuario;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblApellidos;
    @FXML
    private Label lblDni;
    @FXML
    private Label lblEdad;
    @FXML
    private Label lblDireccion;
    @FXML
    private Label lbltelefono;
    @FXML
    private ImageView imgUser;
    @FXML
    private GridPane grpMenu;
    @FXML
    private GridPane grpVentanaBienvenida;
    @FXML
    private GridPane grpaccess;
    @FXML
    private GridPane grpVentanaMatricula;
    @FXML
    private GridPane grpVentanaBaja;
    @FXML
    private GridPane grpVentanaConvalidar;
    @FXML
    private GridPane grpVentanaRenuncia;
    @FXML
    private GridPane grpVentanaTitulo;
    @FXML
    private ImageView imgmatricula;
    @FXML
    private ImageView imgeditar;
    @FXML
    private ImageView imgcerrarsesion;
    @FXML
    private ImageView imgBaja;
    @FXML
    private ImageView imgconvalidar;
    @FXML
    private ImageView imgrenuncia;
    @FXML
    private ImageView imgtitulo;
    @FXML
    private ImageView imgsalir;
    @FXML
    private ImageView imgbuscar;
    @FXML
    private ListView<String> lvasignaturas;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtpassword;

    model newmodel = new model();


    @FXML
    private void mostrarPantallaPrincipal(){
        grpaccess.setVisible(false);
        grpMenu.setVisible(true);
        grpVentanaBienvenida.setVisible(true);
        grpDatosUsuario.setVisible(true);
    }

    @FXML
    private void Salir(){
        alertA.setTitle("Attention");
        alertA.setHeaderText("Confirmation: ");
        alertA.setContentText("do you want to exit the application ?");

        alertA.showAndWait();
        if(alertA.getResult().equals(ButtonType.OK)){
            System.exit(0);
        }
    }

    @FXML
    private void mostrarVentanaMatricula(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        }else if(grpVentanaBaja.isVisible()){
            grpVentanaBaja.setVisible(false);
        } else if (grpVentanaConvalidar.isVisible()) {
            grpVentanaConvalidar.setVisible(false);
        }else if(grpVentanaRenuncia.isVisible()){
            grpVentanaRenuncia.setVisible(false);
        } else if (grpVentanaTitulo.isVisible()) {
            grpVentanaTitulo.setVisible(false);
        }
        grpVentanaMatricula.setVisible(true);
    }

    @FXML
    private void mostrarVentanaBaja(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        }else if(grpVentanaMatricula.isVisible()){
            grpVentanaMatricula.setVisible(false);
        } else if (grpVentanaConvalidar.isVisible()) {
            grpVentanaConvalidar.setVisible(false);
        }else if(grpVentanaRenuncia.isVisible()){
            grpVentanaRenuncia.setVisible(false);
        } else if (grpVentanaTitulo.isVisible()) {
            grpVentanaTitulo.setVisible(false);
        }
        grpVentanaBaja.setVisible(true);
    }

    @FXML
    private void mostrarVentanaConvalidar(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        }else if(grpVentanaBaja.isVisible()){
            grpVentanaBaja.setVisible(false);
        } else if (grpVentanaMatricula.isVisible()) {
            grpVentanaMatricula.setVisible(false);
        }else if(grpVentanaRenuncia.isVisible()){
            grpVentanaRenuncia.setVisible(false);
        } else if (grpVentanaTitulo.isVisible()) {
            grpVentanaTitulo.setVisible(false);
        }
        grpVentanaConvalidar.setVisible(true);
    }

    @FXML
    private void mostrarVentanaRenuncia(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        }else if(grpVentanaBaja.isVisible()){
            grpVentanaBaja.setVisible(false);
        } else if (grpVentanaConvalidar.isVisible()) {
            grpVentanaConvalidar.setVisible(false);
        }else if(grpVentanaMatricula.isVisible()){
            grpVentanaMatricula.setVisible(false);
        } else if (grpVentanaTitulo.isVisible()) {
            grpVentanaTitulo.setVisible(false);
        }
        grpVentanaRenuncia.setVisible(true);
    }

    @FXML
    private void mostrarVentanaTitulo(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        }else if(grpVentanaBaja.isVisible()){
            grpVentanaBaja.setVisible(false);
        } else if (grpVentanaConvalidar.isVisible()) {
            grpVentanaConvalidar.setVisible(false);
        }else if(grpVentanaRenuncia.isVisible()){
            grpVentanaRenuncia.setVisible(false);
        } else if (grpVentanaMatricula.isVisible()) {
            grpVentanaMatricula.setVisible(false);
        }
        grpVentanaTitulo.setVisible(true);
    }

    @FXML
    private void mostrarVentanaIniciarSesion(){
        if(grpVentanaBienvenida.isVisible()){
            grpVentanaBienvenida.setVisible(false);
        } else if (grpVentanaBaja.isVisible()) {
            grpVentanaBaja.setVisible(false);
        } else if (grpVentanaMatricula.isVisible()) {
            grpVentanaMatricula.setVisible(false);
        } else if (grpVentanaConvalidar.isVisible()) {
            grpVentanaConvalidar.setVisible(false);
        }else if(grpVentanaRenuncia.isVisible()){
            grpVentanaRenuncia.setVisible(false);
        } else if (grpVentanaTitulo.isVisible()) {
            grpVentanaTitulo.setVisible(false);
        }
        grpMenu.setVisible(false);
        grpDatosUsuario.setVisible(false);
        grpaccess.setVisible(true);
    }

    @FXML
    private void mostrartooltipMatricula(){
        Tooltip.install(imgmatricula, new Tooltip("Realizar Proceso de Matriculacion"));
    }

    @FXML
    private void mostrartooltipBaja(){
        Tooltip.install(imgBaja, new Tooltip("Realizar Proceso de Baja de Curso"));
    }

    @FXML
    private void mostrartooltipConvalidar(){
        Tooltip.install(imgconvalidar, new Tooltip("Realizar Proceso de Convalidacion"));
    }

    @FXML
    private void mostrartooltipRenuncia(){
        Tooltip.install(imgrenuncia, new Tooltip("Realizar Proceso de Renuncia de Asignaturas"));
    }

    @FXML
    private void mostrartooltipTitulo(){
        Tooltip.install(imgtitulo, new Tooltip("Realizar Proceso de Pedida de Titulo"));
    }

    @FXML
    private void mostrartooltipEditar(){
        Tooltip.install(imgeditar, new Tooltip("Modificar datos del Usuario"));
    }

    @FXML
    private void mostrartooltipSalir(){
        Tooltip.install(imgsalir, new Tooltip("Salir de la Aplicacion"));
    }

    @FXML
    private void mostrartooltipCerrarSesion(){
        Tooltip.install(imgcerrarsesion, new Tooltip("Cerrar Sesion"));
    }

    @FXML
    private void mostrartooltipBuscar(){
        Tooltip.install(imgbuscar, new Tooltip("Buscar Asignaturas"));
    }

    /*@FXML
    private void openSceneList(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ElegirAsignaturas.fxml"));
            Parent root = fxmlLoader.load();
            ElegirController elegir = fxmlLoader.getController();
            if(grpVentanaConvalidar.isVisible()){
                elegir.refillList(model.selectAsignaturas(lblDni.getText()));
                elegir.setParentController(this);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }else if(grpVentanaRenuncia.isVisible()){
                elegir.refillList(model.selectAsignaturasFiltradasPorEstado(lblDni.getText()));
                elegir.setParentController(this);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    public void selectLine(String[] Asignaturas){
        lvasignaturas.getItems().add(Asignaturas[1]);
    }

    @FXML
    private void iniciarSesion(){
        if(newmodel.checkUserAndPassword(txtUser.getText(), txtpassword.getText())){
            mostrarPantallaPrincipal();
            String[] withoutSpace = newmodel.dataStudents(txtUser.getText(), txtpassword.getText()).split("  ");
            lblDni.setText(withoutSpace[0]);
            lblNombre.setText(withoutSpace[1]);
            lblApellidos.setText(withoutSpace[2]);
            lblEdad.setText(withoutSpace[3]);
            lblDireccion.setText(withoutSpace[4]);
            lbltelefono.setText(withoutSpace[8]);
        }
    }
}