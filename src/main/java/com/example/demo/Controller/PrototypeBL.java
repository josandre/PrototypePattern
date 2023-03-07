package com.example.demo.Controller;

import com.example.demo.DAO.DAODoublePressurePliers;
import com.example.demo.DAO.DAODrill;
import com.example.demo.DAO.DAOSpanner;
import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Enum.Tools;
import com.example.demo.Model.Tool;
import com.example.demo.Prototype.DoublePressurePliers;
import com.example.demo.Prototype.Drill;
import com.example.demo.Prototype.Spanner;


import java.util.ArrayList;

public class PrototypeBL {
    private int idDrill;
    private int idSpanner;
    private int idDoublePressurePliers;
    private DAOSpanner daoSpanner = new DAOSpanner();

    private DAODrill daoDrill = new DAODrill();

    private static PrototypeBL bl;

    private Tool currentTool;

    private DAODoublePressurePliers daoDoublePressurePliers = new  DAODoublePressurePliers();
    private Tool drill;
    private Tool spanner;
    private Tool doublePressurePliers;

    public static PrototypeBL getBl(){
        if(bl == null){
            bl = new PrototypeBL(1,1,1);
        }
        return bl;
    }

    private PrototypeBL(int idDrill, int idSpanner, int idDoublePressurePliers){
        this.idDrill = idDrill;
        this.idSpanner = idSpanner;
        this.idDoublePressurePliers = idDoublePressurePliers;
        this.drill = new Drill(this.idDrill);
        this.spanner = new Spanner(this.idSpanner);
        this.doublePressurePliers = new DoublePressurePliers(this.idDoublePressurePliers);
    }

    public Tool newTool(Enum<Tools> tool){
        Tool tool1 = null;
        if (Tools.Drill.equals(tool)) {
            tool1 = this.drill.clone();
            tool1.setId(this.idDrill ++);
            daoDrill.insert(tool1);
        } else if (Tools.Spanner.equals(tool)) {
            tool1 = this.spanner.clone();
            tool1.setId(this.idSpanner ++);
            daoSpanner.insert(tool1);
        } else if (Tools.DoublePressurePliers.equals(tool)) {
            tool1 = this.doublePressurePliers.clone();
            tool1.setId(this.idDoublePressurePliers ++);
            daoDoublePressurePliers.insert(tool1);
        }

        return tool1;
    }

    public ArrayList<Tool> getDrills(){
        return daoDrill.getDataBase();
    }

    public ArrayList<Tool> getSpanners(){
        return daoSpanner.getDataBase();
    }

    public ArrayList<Tool> getDoublePressurePliers(){
        return daoDoublePressurePliers.getDataBase();
    }

    public Tool getDrillById(int id){
        this.currentTool = daoDrill.getDrillById(id);
        return this.currentTool;
    }

    public Tool getSpannerById(int id){
        this.currentTool = daoSpanner.getSpannerById(id);
        return this.currentTool;
    }

    public Tool getCurrentTool(){
        return this.currentTool;
    }

    public void setCurrentTool(Tool tool){
        this.currentTool = tool;
    }

    public Tool getDoublePliersById(int id){
        this.currentTool = daoDoublePressurePliers.getDoublePressurePliers(id);
        return this.currentTool;
    }

    public Tool updateDoublePliers(Tool tool, Enum<MaterialsToCover> material, String color, String text){
        return daoDoublePressurePliers.update(tool, material, color, text);
    }

    public Tool updateDrill(Tool tool, Enum<MaterialsToCover> material, String color, String text){
        return daoDrill.update(tool, material, color, text);
    }

    public Tool updateSpanner(Tool tool, Enum<MaterialsToCover> material, String color, String text){
        return daoSpanner.update(tool, material, color, text);
    }

    public void cleanSpanners(){
        daoSpanner.cleanData();
    }

    public void cleanDrills(){
        daoDrill.cleanData();
    }

    public void cleanPriers(){
        daoDoublePressurePliers.cleanData();
    }



}
