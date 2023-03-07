package com.example.demo.View;

import com.example.demo.Controller.PrototypeBL;
import com.example.demo.Enum.Tools;
import com.example.demo.Main;
import com.example.demo.Model.Tool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScene {
    @FXML
    public TextField idSpannerAmount;
    @FXML
    public TextField idPliersAmount;
    @FXML
    public TextField idDrillAmount1;

    private PrototypeBL bl = PrototypeBL.getBl();
    @FXML
    public Button btnCheckOrder;

    @FXML
    public Button btnCenfoTil;

    @FXML
    public Label idLabelCenfoTil;

    Stage stage;

    private boolean esCenfo = false;


    public void initialize() {}

    private void addingDrill(){

        int amountOfDrill = idDrillAmount1.getText().equals("") ? 0 : Integer.parseInt(idDrillAmount1.getText());

        for(int drill = 0; drill < amountOfDrill; drill++){
            addingToCenfoTilValues(bl.newTool(Tools.Drill));
        }
    }

    private void addingPliers(){
        int amountOfPLiers = idPliersAmount.getText().equals("") ? 0 : Integer.parseInt(idPliersAmount.getText());

        for(int pliers = 0; pliers < amountOfPLiers; pliers++){
            addingToCenfoTilValues(bl.newTool(Tools.DoublePressurePliers));

        }
    }

    private void addingSpanners(){
        int amountOfSpanners = idSpannerAmount.getText().equals("") ? 0 : Integer.parseInt(idSpannerAmount.getText());

        for(int spanner = 0; spanner < amountOfSpanners; spanner++){
            addingToCenfoTilValues(bl.newTool(Tools.Spanner));
        }
    }

    public void handleCheckOrder() throws IOException {
        addingDrill();
        addingPliers();
        addingSpanners();
        Main.changeScene("ListOfOrder");
    }


    public void handleCenfoTil() throws IOException {
        esCenfo = true;
        Main.showAlert("Hi cenfo til company", "You can continue wit your order. We already designed you tools base", "OK",  Alert.AlertType.CONFIRMATION);
        btnCenfoTil.setVisible(false);
        idLabelCenfoTil.setText("Welcome Cenfo til.. We are glad to see you again!. You can continue with your order");
    }

    private void addingToCenfoTilValues(Tool tool){
        if(this.esCenfo){
            tool.setColor("Morado");
            tool.setText("Cenfo til corp");
        }
    }
}
