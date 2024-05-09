package com.finalproject.agg2324.spinstitute;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PagosController {
    @FXML
    private ComboBox<String> cmbcantidadpago;
    @FXML
    private TextField txtcuenta;
    @FXML
    private TextField txtoperacion;
    @FXML
    private TextField txtdni;

    //funcion que rellena un combobox con los precios de matricula o titulo

    public void refillcantidadpago() {
        if(txtoperacion.getText().equals("Matricula")){
            cmbcantidadpago.getItems().clear();

            cmbcantidadpago.getItems().add("");
            cmbcantidadpago.getItems().add("");
        }else{
            cmbcantidadpago.getItems().clear();
            cmbcantidadpago.getItems().add("");
        }
    }

    public void refillCampos(String dni, String operacion){
        txtdni.setText(dni);
        txtoperacion.setText(operacion);
    }
}
