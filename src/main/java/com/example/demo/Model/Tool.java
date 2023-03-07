package com.example.demo.Model;

import com.example.demo.Enum.Materials;
import com.example.demo.Enum.MaterialsToCover;
import com.example.demo.Enum.Tools;


public abstract class Tool {
    private Enum<Materials> material;
    private String color;
    private String text;
    private Enum<MaterialsToCover> materialThatCoversIt;
    private int id;

    private Enum<Tools> tool;




    public Tool(){

    }

    public Enum<Materials> getMaterial() {
        return material;
    }

    public void setMaterial(Enum<Materials> material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Enum<MaterialsToCover> getMaterialThatCoversIt() {
        return materialThatCoversIt ;
    }

    public void setMaterialThatCoversIt(Enum<MaterialsToCover> materialThatCoversIt) {
        this.materialThatCoversIt = materialThatCoversIt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Enum<Tools> getTool() {
        return tool;
    }

    public void setTool(Enum<Tools> tool) {
        this.tool = tool;
    }

    @Override
    public String toString() {
        String materialCover;

        if(this.materialThatCoversIt == null){
            materialCover = "";
        }else{
            materialCover =  this.materialThatCoversIt.toString();
        }

        return "Tool{" +
                "material=" + material +
                ", color='" + color + '\'' +
                ", text='" + text + '\'' +
                ", materialThatCoversIt=" + materialCover +
                ", id=" + id +
                ", tool=" + tool +
                '}';
    }

    public abstract Tool clone();


}
