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
    private Label lblcontra;
    @FXML
    private Label lblnombreCurso;
    @FXML
    private Label lblidAsignatura;
    @FXML
    private Label lblnombrefichero;
    @FXML
    private Label lblemail;
    @FXML
    private Label lblusuario;
    @FXML
    private ComboBox<String> cmbturno;
    @FXML
    private ComboBox<String> cmbnivel;
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
    @FXML
    private ComboBox<String> cmbRequisitos;
    @FXML
    private ComboBox<String> cmbDocumentacion;
    @FXML
    private ComboBox<String> cmbMotivos;
    @FXML
    private TextField txtOtra;

    private List<String> cmbList;


    model newmodel = new model();

    //funcion para salir de la aplicacionn
    @FXML
    private void Salir(){
        alertA.setTitle("Attention");
        alertA.setHeaderText("Confirmation: ");
        alertA.setContentText("Deseas Salir de la Aplicacion ?");
        alertA.showAndWait();
        if(alertA.getResult().equals(ButtonType.OK)){
            System.exit(0);
        }
    }

    private void limpiarCamposMatricula(){
        cmbCursos.setValue(null);
        cmbturno.setValue(null);
        cmbnivel.setValue(null);
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

    //funcion que recoge los rellena los labels con los datos actualizados
    @FXML
    private void iniciarSesion(){
        if(!newmodel.checkUserAndPassword(txtUser.getText(), txtpassword.getText())){
            mostrarPantallaPrincipal();
            String[] withoutSpace = newmodel.dataStudents(txtUser.getText(), txtpassword.getText()).split("  ");
            lblDni.setText(withoutSpace[0]);
            lblNombre.setText(withoutSpace[1]);
            lblApellidos.setText(withoutSpace[2]);
            lblEdad.setText(withoutSpace[3]);
            lblDireccion.setText(withoutSpace[4]);
            lblemail.setText(withoutSpace[9]);
            lblusuario.setText(withoutSpace[11]);
            lblcontra.setText(withoutSpace[12]);
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }

    //Parte Ventana Matricula-------------------------------------------------------------------------------------------------------------------------------------
    //funcion para rellenar un combobox de cursos
    private void refillCursos(){
        cmbList = new ArrayList<>();
        newmodel.cmbListCursos(cmbList);
        for(String str : cmbList){
            cmbCursos.getItems().add(str);
        }
    }

    //funcion para rellenar los combobox que no requieren de base de datos
    private void refillCombosMatriculas(){
        cmbturno.getItems().add("Mañana");
        cmbturno.getItems().add("Tarde");
        cmbnivel.getItems().add("Primero");
        cmbnivel.getItems().add("Segundo");
    }

    //funcion para mostrar la ventana de matricula
    @FXML
    private void ventanaMatricula(){
        mostrarVentanaMatricula();
        refillCursos();
        refillCombosMatriculas();
    }

    //funcion que depende de los que hayamos hecho con la matrícula, mostramos un mensaje u otro
    @FXML
    private void insertarMatricula(){
        lblnombreCurso.setText(cmbCursos.getValue());
        String resultado = "";
        if(cmbturno.getValue() != null){
            if(cmbnivel.getValue() != null){
                if(Objects.equals(cmbnivel.getValue(), "Primero")){
                    resultado = newmodel.checkMatriculaCurso(lblDni.getText(), lblnombreCurso.getText(), cmbturno.getValue(), 1);
                }else{
                    resultado = newmodel.checkMatriculaCurso(lblDni.getText(), lblnombreCurso.getText(), cmbturno.getValue(), 2);
                }
            }else{
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Debes selecionar un nivel");
                alert.showAndWait();
            }
        } else{
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
            abrirventanaPagosMatricula();
        }else if(Objects.equals(resultado, "Cursando")){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ya estas en este curso");
            alert.showAndWait();
        }else if(Objects.equals(resultado, "Otra Matricula")){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Ya estas cursando otro Curso");
            alert.showAndWait();
        }
        limpiarCamposMatricula();
    }

    //funcion abre la ventana de pagos, que depende de que ventana estaba abierta previamente envia unos datos u otros
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
    private void abrirVentanaConvalidacion(){
        if(newmodel.checkMatriculasCursadas(lblDni.getText())){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No estas matriculado en ningun curso actualmente");
            alert.showAndWait();
        }else{
            mostrarVentanaConvalidar();
            refillCombosConvalidar();
        }
    }

    //funcion que rellena los combox de la ventana de convalidacion
    private void refillCombosConvalidar(){
        cmbDocumentacion.getItems().clear();
        cmbDocumentacion.getItems().add("Documento de identificacion (nacional o extranjero).");
        cmbDocumentacion.getItems().add("Certificacion academica oficial en la que consten lso modulos profesionales cursados, la convocatoria en la que han sido superados y la clasificacion obtenida.");
        cmbDocumentacion.getItems().add("Fotocopia compulsada del titulo.");
        cmbDocumentacion.getItems().add("Certificacion oficila de la administracion competente segun el R.D.1224/2009 o certificado de profesionalidad establecido a partir de R.D. 34/2008.");

        cmbRequisitos.getItems().clear();
        cmbRequisitos.getItems().add("Tener superados modulos profesionales de titulos de formacion profesional del catalogo de la LOGSE o bien estar en posesion de un titulo LOGSE, cuya convalidacion esta definida en las normas que regulan los titulos de formacion profesional del catalogo de la LOE.");
        cmbRequisitos.getItems().add("Tener superados modulos profesionales de titulos de formacion profesional del catalogo de la LOE con diferentes codigos o bien estar en posesion de un titulo LOE, tanto de grado medio como de grado superior.");
        cmbRequisitos.getItems().add("Tener superados modulos profesionales de diversos titulos formacion profesional basica");
        cmbRequisitos.getItems().add("Tener acreditadas unidades de competencia que forman parte del catalogo nacional de calificacion profesionales.");
        cmbRequisitos.getItems().add("Tener superados otros estudios reglados");
    }

    //funcion para abrir la ventana de eleccion de asignaturas dependiendo de si estás en convalidar o renuncia
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
            newmodel.updateNotasConvalidacion(lblDni.getText(), Asignaturas);
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("La asignatura " + lblidAsignatura.getText() + " no se puede convalidar, no cumples los requisitos");
            alert.showAndWait();
        }
    }

    //funcion que realiza la actualizacion de las notas(convalidacion) y abre la ventana de descargas
    @FXML
    private void realizarConvalidacion(){
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Se han convalidado las asignaturas.");
        alert.showAndWait();
        openSceneDescargasConvalidar();
    }

    //funcion que abre la ventana de actualizacion Convalidacion
    private void openSceneDescargasConvalidar(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/DescargarDocumento.fxml"));
            Parent root = fxmlLoader.load();
            DescargarController controller = fxmlLoader.getController();
            lblnombreCurso.setText(newmodel.nombreCursomatricula(lblDni.getText()));
            controller.recogerDatos(lblDni.getText() + "  " + lblNombre.getText() + "  " + lblApellidos.getText() + "  " + lblnombreCurso.getText(), lvasignaturas.getItems());
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
            String[] withoutSpace = newmodel.dataStudents(txtUser.getText(), lblcontra.getText()).split("  ");
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
        lblDireccion.setText(withoutSpace[0]);
        lblemail.setText(withoutSpace[4]);
        lblcontra.setText(withoutSpace[5]);
    }

    //funcion que comprueba para poder abrir la ventana de baja
    @FXML
    private void abrirVentanaBaja(){
        if(newmodel.checkMatriculasCursadas(lblDni.getText())){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No estas matriculado en ningun curso actualmente");
            alert.showAndWait();
        }else{
            mostrarVentanaBaja();
        }
    }

    //funcion que comprueba para poder abrir la ventana de renuncia
    @FXML
    private void abrirVentanaRenuncia(){
        if(newmodel.checkMatriculasCursadas(lblDni.getText())){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No estas matriculado en ningun curso actualmente");
            alert.showAndWait();
        }else{
            mostrarVentanaRenuncia();
            refillComboRenuncia();
        }
    }

    //funcion que rellena el combobox de renuncia
    private void refillComboRenuncia(){
        cmbMotivos.getItems().clear();
        cmbMotivos.getItems().add("Enfermedad Prolongada o accidente.");
        cmbMotivos.getItems().add("Obligaciones de tipo personal o familiar.");
        cmbMotivos.getItems().add("Desempeño de un puesto de trabajo.");
        cmbMotivos.getItems().add("Maternidad, paternidad, adopcion o acogimiento.");
        cmbMotivos.getItems().add("Otras Circustancias (especificar):");
    }

    //funcion que si eliges cierta opcion del combo de motivos se hace visible un textfield
    @FXML
    private void mostrarTxtMotivos(){
        if(Objects.equals(cmbMotivos.getSelectionModel().getSelectedItem(), "Otras Circustancias (especificar):")){
            txtOtra.setVisible(true);
        }else{
            txtOtra.setVisible(false);
        }
    }

    //funcion que comprueba para poder abrir la ventana de título
    @FXML
    private void abrirVentanaTitulo(){
        if(newmodel.checkCursosAprobados(lblDni.getText())){
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("No tienes ningun cursos de segundo nivel Aprobado");
            alert.showAndWait();
        }else{
            mostrarVentanaTitulo();
        }
    }
}