package com.example.demo.DAO;

import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Model.Tool;

import java.util.ArrayList;

public class DAODrill {
    private ArrayList<Tool> Drills = new ArrayList<Tool>();

    public void insert(Tool tool){
        Drills.add(tool);
    }

    public ArrayList<Tool> getDataBase() {
        return Drills;
    }

    public Tool getDrillById(int id){
        for (int i = 0; i < this.Drills.size(); i ++){
            if(this.Drills.get(i).getId() == id){
                return this.Drills.get(i);
            }
        }

        return null;
    }

    public void cleanData(){
       this.Drills.clear();
    }

    public Tool update(Tool tool, Enum<MaterialsToCover> materialsToCoverEnum, String color, String text){
        tool.setMaterialThatCoversIt(materialsToCoverEnum);
        tool.setColor(color);
        tool.setText(text);
        return tool;
    }
}
