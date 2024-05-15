package com.finalproject.agg2324.spinstitute.Controllers;

import com.finalproject.agg2324.spinstitute.model;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.math.BigInteger;

public class PagosController {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private ComboBox<String> cmbcantidadpago;
    @FXML
    private TextField txtcuenta;
    @FXML
    private TextField txtoperacion;
    @FXML
    private TextField txtdni;
    @FXML
    private ImageView imgpago;

    model newmodel = new model();

    //funcion que rellena un combobox con los precios de matricula o titulo
    public void refillcantidadpago() {
        if(txtoperacion.getText().equals("Matricula")){
            cmbcantidadpago.getItems().clear();
            cmbcantidadpago.getItems().add("30 € Base");
            cmbcantidadpago.getItems().add("55 € Base + AMPA");
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
            String[] withoutSpace = list.split(" ");
            newmodel.insertarPago(txtdni.getText(), txtoperacion.getText(), txtcuenta.getText(), BigInteger.valueOf(Integer.parseInt(withoutSpace[0])));
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("La matricula se ha realizado correctamente");
            alert.showAndWait();
            imgpago.setDisable(true);
        }
    }

    //funcion que habilita el boton si se ha selecionado alguna opcion en el combobox.
    @FXML
    private void habilitarBoton(){
        if(cmbcantidadpago.getSelectionModel().getSelectedItem() != null){
            imgpago.setDisable(false);
        }
    }
}
