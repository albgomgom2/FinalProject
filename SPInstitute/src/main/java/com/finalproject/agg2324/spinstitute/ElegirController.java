package com.finalproject.agg2324.spinstitute;

import javafx.fxml.FXML;

import javafx.scene.control.ListView;

import java.awt.event.ActionEvent;
import java.util.List;
import javafx.scene.Node;
import javafx.stage.Stage;

public class ElegirController {
    @FXML
    ListView<String> lvlists;

    private Controller controller;
    //funcion que rellena una listview con los datos obtenidos de una select de asignaturas
    public void refillList(List<String> lists){
        for(String str : lists){
            lvlists.getItems().add(str);
        }
    }

    public void setParentController(Controller controller){
        this.controller = controller;
    }
    //funcion que devuelve el item selecciona a la ventana principal
    public void getOptionSelected(ActionEvent actionEvent){
        if(!lvlists.getItems().isEmpty()){
            String list = lvlists.getSelectionModel().getSelectedItem();
            String[] withoutSpace = list.split("  ");
            controller.selectLine(withoutSpace);
        }
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }
}
