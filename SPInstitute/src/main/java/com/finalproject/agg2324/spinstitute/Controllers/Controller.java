package com.finalproject.agg2324.spinstitute.Controllers;

import com.finalproject.agg2324.spinstitute.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Controller {
    Alert alertA = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
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
    private Label lblnombreCurso;
    @FXML
    private Label lblidAsignatura;
    @FXML
    private Label lblnombrefichero;
    @FXML
    private RadioButton rbtnMañana;
    @FXML
    private RadioButton rbtnTarde;
    @FXML
    private RadioButton rbtnPrimero;
    @FXML
    private RadioButton rbtnSegundo;
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
    @FXML
    private ComboBox<String> cmbAsignaturas;
    @FXML
    private ComboBox<String> cmbAsig2;
    @FXML
    private ComboBox<String> cmbCursos;

    private List<String> cmbList;


    model newmodel = new model();
    //funcion para salir de la aplicacionn
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

    //Parte de Abrir Ventanas-------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private void mostrarPantallaPrincipal(){
        grpaccess.setVisible(false);
        grpMenu.setVisible(true);
        grpVentanaBienvenida.setVisible(true);
        grpDatosUsuario.setVisible(true);
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

    //Parte de TooltipsImagenes-----------------------------------------------------------------------------------------------------------------------------------
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

    //------------------------------------------------------------------------------------------------------------------------------------------------------------
    //funcion que recoge los datos del usuario
    private String dataStudents(){
        return newmodel.dataStudents(txtUser.getText(), txtpassword.getText());
    }

    //funcion que recoge los rellena los labels con los datos actualizados
    @FXML
    private void iniciarSesion(){
        if(newmodel.checkUserAndPassword(txtUser.getText(), txtpassword.getText())){
            mostrarPantallaPrincipal();
            String[] withoutSpace = dataStudents().split("  ");
            lblDni.setText(withoutSpace[0]);
            lblNombre.setText(withoutSpace[1]);
            lblApellidos.setText(withoutSpace[2]);
            lblEdad.setText(withoutSpace[3]);
            lblDireccion.setText(withoutSpace[4]);
            lbltelefono.setText(withoutSpace[8]);
            habilitarCampos();
        }
    }

    //Parte Ventana Matricula-------------------------------------------------------------------------------------------------------------------------------------
    //funcion para habilitar campos
    public void habilitarCampos(){
        if(newmodel.checkMatriculasCursadas(lblDni.getText())){
            imgBaja.setDisable(false);
            imgconvalidar.setDisable(false);
            imgrenuncia.setDisable(false);
        }
        if(newmodel.checkCursosAprobados(lblDni.getText())){
            imgtitulo.setDisable(false);
        }
    }

    //funcion para rellenar un combobox de cursos
    private void refillCursos(){
        cmbList = new ArrayList<>();
        newmodel.cmbListCursos(cmbList);
        for(String str : cmbList){
            cmbCursos.getItems().add(str);
        }
    }

    //funcion que depende de los que hayamos hecho con la matricula, mostrmaos un mensaje u otro
    @FXML
    private void insertarMatricula(){
        lblnombreCurso.setText(cmbCursos.getValue());
        String resultado = "";
        if(rbtnMañana.isSelected()){
            resultado = getNivel(resultado, rbtnMañana);
        } else if (rbtnTarde.isSelected()) {
            resultado = getNivel(resultado, rbtnTarde);
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Debes selecionar un turno");
            alert.showAndWait();
        }

        if(Objects.equals(resultado, "Aprobado")){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Este curso ya lo tienes aprobado");
            alert.showAndWait();
        }else if(Objects.equals(resultado, "Actualizado") || Objects.equals(resultado, "Insertado")){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("La matricula se ha realizado correctamente");
            alert.showAndWait();
        }else if(Objects.equals(resultado, "Cursando")){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ya estas en este curso");
            alert.showAndWait();
        }
    }
    //funcion que depende de que nivel se haya seleccionado realizamos la matricula con unos datos
    private String getNivel(String resultado, RadioButton rbtnturno) {
        if(rbtnPrimero.isSelected()){
            resultado = newmodel.checkMatriculaCurso(lblDni.getText(), lblnombreCurso.getText(), rbtnturno.getText(), 1);
        }else if (rbtnSegundo.isSelected()){
            resultado = newmodel.checkMatriculaCurso(lblDni.getText(), lblnombreCurso.getText(), rbtnturno.getText(), 2);
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Debes selecionar un nivel");
            alert.showAndWait();
        }
        return resultado;
    }

    //funcion abre la ventana de pagos, que depende de que ventana estaba abierta previamente envia unos datos u otros
    @FXML
    private void abrirventanaPagosMatricula(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/VentanaPagos.fxml"));
            Parent root = fxmlLoader.load();
            PagosController controller = fxmlLoader.getController();
            if(grpVentanaMatricula.isVisible()){
                controller.refillCampos(lblDni.getText(), "Matricula");
            }else{
                controller.refillCampos(lblDni.getText(), "Titulo");
            }
            controller.refillcantidadpago();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Parte Ventana Convalidacion---------------------------------------------------------------------------------------------------------------------------------
    //funcion que abre una ventana con los datos buscados
    @FXML
    private void openSceneList(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ElegirAsignaturas.fxml"));
            Parent root = fxmlLoader.load();
            ElegirController elegir = fxmlLoader.getController();
            if(grpVentanaConvalidar.isVisible()){
                elegir.refillList(newmodel.selectAsignaturas(lblDni.getText()));
                elegir.setParentController(this);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }else if(grpVentanaRenuncia.isVisible()){
                elegir.refillList(newmodel.selectAsignaturasFiltradasPorEstado(lblDni.getText()));
                elegir.setParentController(this);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que recoge los datos de la ventana de busqueda
    public void selectLine(String Asignaturas){
        lblidAsignatura.setText(Asignaturas);
        if(newmodel.convalidarAsignatura(lblDni.getText(),Asignaturas)){
            lvasignaturas.getItems().add(Asignaturas);
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("La asignatura " + lblidAsignatura.getText() + " no se puede convalidar, no cumples los requisitos");
            alert.showAndWait();
        }
    }

    //funcion que rellena los combobox de las asignaturas
    private void refillAsignaturas(){
        cmbList = new ArrayList<>();
        newmodel.cmbListAsignaturasC(cmbList, lblnombreCurso.getText());
        for(String str : cmbList){
            cmbAsignaturas.getItems().add(str);
        }
        cmbList = new ArrayList<>();
        newmodel.cmbListAsignaturasR(cmbList, lblnombreCurso.getText(), lblDni.getText());
        for (String str : cmbList){
            cmbAsig2.getItems().add(str);
        }
    }

    //funcion que realiza la actualizacion de las notas(convalidacion) y abre la ventana de descargas
    @FXML
    private void realizarConvalidacion(){
        newmodel.updateNotasConvalidacion(lblDni.getText(), lvasignaturas.getItems());
        openSceneDescargasConvalidar();
    }

    //funcion que abre la ventana de actualizacion Convalidacion
    private void openSceneDescargasConvalidar(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/DescargarDocumento.fxml"));
            Parent root = fxmlLoader.load();
            DescargarController controller = fxmlLoader.getController();
            controller.cargarTextoConvalidar();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que abre un explorador de archivos y guarda el nombre del archivo selecciona en un label
    @FXML
    private void subirFicheros(){
        JFileChooser j = new JFileChooser();
        j.showSaveDialog(null);
        lblnombrefichero.setText(j.getSelectedFile().getName());
    }

    //Parte de Ventana Modificar usuarios-------------------------------------------------------------------------------------------------------------------------
    //funcion que nos abre la ventana de modificar usuario
    @FXML
    private void VentanaModificarUsuario(){
        try{
            String[] withoutSpace = dataStudents().split("  ");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ModificarDatosUsuario.fxml"));
            Parent root = fxmlLoader.load();
            ModificarController controller = fxmlLoader.getController();
            controller.rellenarCampos(withoutSpace[0],withoutSpace[1],withoutSpace[2],withoutSpace[3],withoutSpace[4],withoutSpace[5],withoutSpace[6],withoutSpace[7],withoutSpace[8],withoutSpace[9],withoutSpace[10],withoutSpace[11],withoutSpace[12]);
            controller.setParentController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //funcion que nos recoge los datos obtenidos de la ventana de modificacion
    public void ObtenerDatosAModificar(String datos){
        String[] withoutSpace = datos.split("  ");
        newmodel.actualizarUsuario(txtUser.getText(), withoutSpace[0], withoutSpace[1], withoutSpace[2], withoutSpace[3], withoutSpace[4], withoutSpace[5]);
    }







}