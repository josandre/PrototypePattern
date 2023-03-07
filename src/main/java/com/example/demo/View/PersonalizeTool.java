package com.example.demo.View;

import com.example.demo.Controller.PrototypeBL;
import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Enum.Tools;
import com.example.demo.Main;
import com.example.demo.Model.Tool;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PersonalizeTool {

    @FXML
    public ComboBox<String> idMaterial;

    @FXML
    public TextField idColor;

    @FXML
    public TextField idText;

    private PrototypeBL bl = PrototypeBL.getBl();

    private Tool currentTool = bl.getCurrentTool();



    public void initialize(){
        idColor.setText(currentTool.getColor());
        idText.setText(currentTool.getText());
    }


    public void handleSave() throws IOException {
        String color = idColor.getText();
        String text = idText.getText();

        if(this.currentTool.getTool() == Tools.Spanner){
            bl.updateSpanner(this.currentTool, gettingMaterialEnum(), color, text);
        } else if (this.currentTool.getTool() == Tools.Drill) {
            bl.updateDrill(this.currentTool, gettingMaterialEnum(), color, text);
        }

        bl.updateDoublePliers(this.currentTool, gettingMaterialEnum(), color, text);
        Main.changeScene("ListOfOrder");
    }

    private Enum<MaterialsToCover> gettingMaterialEnum(){
        String value = idMaterial.getValue();

        if(MaterialsToCover.Wood.toString().equals(value)){
            return MaterialsToCover.Wood;
        }else{
            return MaterialsToCover.Plastic;
        }
    }


    public void handleBack() throws IOException {
        Main.changeScene("ListOfOrder");
    }
}
