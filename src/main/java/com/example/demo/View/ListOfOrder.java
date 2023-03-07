package com.example.demo.View;

import com.example.demo.Controller.PrototypeBL;
import com.example.demo.Enum.Materials;
import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Enum.Tools;
import com.example.demo.Main;
import com.example.demo.Model.Tool;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class ListOfOrder {

    ObservableList<Tool> toolsLIst = FXCollections.observableArrayList();
    @FXML
    public TableView<Tool> tblOrder;

    @FXML
    public TableColumn<Tool, String> colTool;

    @FXML
    public TableColumn<Tool, String> colMaterial;


    @FXML
    public TableColumn<Tool, String> colColor;
    
    @FXML
    public Button idBtnFinishOrder;

    @FXML
    public TableColumn<Tool, String> colText;

    @FXML
    public TableColumn<Tool, String> colMaterialThatCoversIt;

    @FXML
    public TableColumn<Tool, String> colCode;

    private PrototypeBL bl = PrototypeBL.getBl();

    private Tool selectedTool;


    public void initialize(){

        tblOrder.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        colTool.setCellValueFactory(tool -> new SimpleStringProperty(tool.getValue().getTool().toString()));
        colMaterial.setCellValueFactory(tool -> new SimpleStringProperty(tool.getValue().getMaterial().toString()));
        colColor.setCellValueFactory(tool -> new SimpleStringProperty(tool.getValue().getColor()));
        colText.setCellValueFactory(tool -> new SimpleStringProperty(tool.getValue().getText()));

        colMaterialThatCoversIt.setCellValueFactory(tool -> new SimpleStringProperty(tool.getValue().getMaterialThatCoversIt() != null ? tool.getValue().getMaterialThatCoversIt().toString() : ""));
        colCode.setCellValueFactory(tool -> new SimpleStringProperty(String.valueOf(tool.getValue().getId())));
        System.out.println("initializing");

        tblOrder.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, tool) -> {
                    try {
                        getToolData(tool);
                    } catch (IOException e) {
                        throw new RuntimeException(e);

                    }
                });

        loadData();
    }

    public void loadData(){
        toolsLIst.removeAll();
        toolsLIst.addAll(bl.getDrills());
        toolsLIst.addAll(bl.getSpanners());
        toolsLIst.addAll(bl.getDoublePressurePliers());
        tblOrder.setItems(toolsLIst);
    }

    private void getToolData(Tool tool) throws IOException {
        System.out.println(tool.toString());
        Tool toolFound;
        if(tool.getTool() == Tools.Drill){
            toolFound = bl.getDrillById(tool.getId());
        }else if(tool.getTool() == Tools.Spanner){
            toolFound =  bl.getSpannerById(tool.getId());
        }else{
            toolFound = bl.getDoublePliersById(tool.getId());
        }
        this.selectedTool = toolFound;
        Main.changeScene("PersonalizeTool");
    }

    public Tool getSelectedTool(){
        return this.selectedTool;
    }


    public void handleFinishOrder() throws IOException {
       bl.cleanSpanners();
       bl.cleanDrills();
       bl.cleanPriers();
       Main.showAlertChangeScene("Finish Order", "You already finish. Thanks for buying tools with us", "OK", "main", Alert.AlertType.CONFIRMATION);
    }
}
