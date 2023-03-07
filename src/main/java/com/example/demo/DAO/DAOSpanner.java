package com.example.demo.DAO;

import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Model.Tool;

import java.util.ArrayList;

public class DAOSpanner {
    private ArrayList<Tool> Spanners = new ArrayList<Tool>();

    public void insert(Tool tool){
        Spanners.add(tool);
    }

    public ArrayList<Tool> getDataBase() {
        return Spanners;
    }

    public Tool getSpannerById(int id){
        for (int i = 0; i < this.Spanners.size(); i ++){
            if(this.Spanners.get(i).getId() == id){
                return this.Spanners.get(i);
            }
        }

        return null;
    }

    public void cleanData(){
        this.Spanners.clear();

    }

    public Tool update(Tool tool, Enum<MaterialsToCover> materialsToCoverEnum, String color, String text){
        tool.setMaterialThatCoversIt(materialsToCoverEnum);
        tool.setColor(color);
        tool.setText(text);
        return tool;
    }

}
