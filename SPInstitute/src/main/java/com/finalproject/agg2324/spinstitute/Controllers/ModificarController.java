package com.finalproject.agg2324.spinstitute.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModificarController {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private TextField txtMDni;
    @FXML
    private TextField txtMNombre;
    @FXML
    private TextField txtMApellido;
    @FXML
    private TextField txtMEdad;
    @FXML
    private TextField txtMDireccion;
    @FXML
    private TextField txtMLocalidad;
    @FXML
    private TextField txtMCiudad;
    @FXML
    private TextField txtMPais;
    @FXML
    private TextField txtMTelefono;
    @FXML
    private TextField txtMEmail;
    @FXML
    private TextField txtMUsuario;
    @FXML
    private PasswordField txtMContraseña;
    @FXML
    private TextField txtMFechaNacimiento;

    private Controller controller;

    public void setParentController(Controller controller) {
        this.controller = controller;
    }

    //funcion para rellenar los textfield
    public void rellenarCampos(String dni, String nombre, String apellidos, String edad, String direccion, String localidad, String ciudad, String pais, String telefono, String email, String fecha, String usuario, String contraseña){
        txtMDni.setText(dni);
        txtMNombre.setText(nombre);
        txtMApellido.setText(apellidos);
        txtMEdad.setText(edad);
        txtMDireccion.setText(direccion);
        txtMLocalidad.setText(localidad);
        txtMCiudad.setText(ciudad);
        txtMPais.setText(pais);
        txtMTelefono.setText(telefono);
        txtMEmail.setText(email);
        txtMUsuario.setText(usuario);
        txtMContraseña.setText(contraseña);
        txtMFechaNacimiento.setText(fecha);
    }

    //funcion que valida los campos que luego devolveremos a la pantalla principal
    public void comprobarCampos(javafx.event.ActionEvent actionevent){
        if(validarDireccion()){
            if(validarLocalidad()){
                if(validarCiudad()){
                    if(validarTelefono()){
                        if(validarEmail()){
                            if(validarContraseñaModificar()){
                                controller.ObtenerDatosAModificar(modificarDatosController());
                                Node n = (Node) actionevent.getSource();
                                Stage stage = (Stage) n.getScene().getWindow();
                                stage.close();
                            }else{
                                alert.setTitle("Information Dialog");
                                alert.setHeaderText(null);
                                alert.setContentText("Contraseña no valida, la contraseña debe contener: \n" +
                                        "-Minimo 8 caracteres.\n" +
                                        "-Mínimo 1 mayúscula.\n" +
                                        "-Mínimo 1 numero.\n" +
                                        "-Mínimo 1 simbolo especial: ?!¡@¿.,´)_");
                                alert.showAndWait();
                            }
                        }else{
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Email no válido");
                            alert.showAndWait();
                        }
                    }else{
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Telefono no válido");
                        alert.showAndWait();
                    }
                }else{
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Ciudad no válida");
                    alert.showAndWait();
                }
            }else{
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Localidad no válida");
                alert.showAndWait();
            }
        }else{
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Direccion no válida");
            alert.showAndWait();
        }
    }

    //funcion para validar una direccion
    private boolean validarDireccion(){
        Pattern p = Pattern.compile("^[a-zA-Z0-9 ]{1,200}");
        Matcher m = p.matcher(txtMDireccion.getText());
        return m.matches();
    }

    //funcion para validar una ciudad
    private boolean validarCiudad(){
        Pattern p = Pattern.compile("^[a-zA-Z ]{1,30}");
        Matcher m = p.matcher(txtMCiudad.getText());
        return m.matches();
    }

    //funcion para validar una localidad
    private boolean validarLocalidad(){
        Pattern p = Pattern.compile("^[a-zA-Z ]{1,30}");
        Matcher m = p.matcher(txtMLocalidad.getText());
        return m.matches();
    }

    //funcion para validar un telefono
    private boolean validarTelefono(){
        Pattern p = Pattern.compile("^(\\+34|0034|34)?[6789]\\d{8}$");
        Matcher m = p.matcher(txtMTelefono.getText());
        return m.matches();
    }

    //funcion para validar un email
    private boolean validarEmail(){
        Pattern p = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$");
        Matcher m = p.matcher(txtMEmail.getText());
        return m.matches();
    }

    //funcion para validar una contraseña
    private boolean validarContraseñaModificar(){
        return controller.validarContraseña(txtMContraseña);
    }

    //funcion que me recoge los datos en un string
    private String modificarDatosController(){
        return txtMDireccion.getText() + "  " + txtMLocalidad.getText() + "  " + txtMCiudad.getText() + "  " + txtMTelefono.getText() + "  " + txtMEmail.getText() + "  " + txtMContraseña.getText();
    }

}
