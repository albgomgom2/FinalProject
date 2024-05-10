package com.finalproject.agg2324.spinstitute.Controllers;

import com.finalproject.agg2324.spinstitute.model;
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

    model newmodel = new model();

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

    //funcion que comprueba si has seleccionado algun precio y si es asi realiza la insercion del pago
    @FXML
    private void insertarPago(){
        if(!cmbcantidadpago.getValue().isEmpty()){
            String list = cmbcantidadpago.getSelectionModel().getSelectedItem();
            String[] withoutSpace = list.split("  ");
            newmodel.insertarPago(txtdni.getText(), txtoperacion.getText(), txtcuenta.getText(), Double.parseDouble(withoutSpace[0]));
        }

    }
}
