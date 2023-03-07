package com.example.demo.DAO;

import com.example.demo.Enum.Materials;
import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Model.Tool;

import java.util.ArrayList;

public class DAODoublePressurePliers {
    private ArrayList<Tool> DoublePressurePliers = new ArrayList<Tool>();

    public void insert(Tool tool){
        DoublePressurePliers.add(tool);
    }

    public ArrayList<Tool> getDataBase() {
        return DoublePressurePliers;
    }

    public Tool getDoublePressurePliers(int id){
        for (int i = 0; i < this.DoublePressurePliers.size(); i ++){
            if(this.DoublePressurePliers.get(i).getId() == id){
                return this.DoublePressurePliers.get(i);
            }
        }

        return null;
    }

    public Tool update(Tool tool, Enum<MaterialsToCover> materialsToCoverEnum, String color, String text){
        tool.setMaterialThatCoversIt(materialsToCoverEnum);
        tool.setColor(color);
        tool.setText(text);
        return tool;
    }

    public void cleanData(){
        this.DoublePressurePliers.clear();
    }
}
