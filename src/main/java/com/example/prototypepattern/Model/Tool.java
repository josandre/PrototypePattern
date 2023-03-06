package com.example.prototypepattern.Model;

import com.example.prototypepattern.Enum.Materials;
import com.example.prototypepattern.Enum.MaterialsToCover;
import com.example.prototypepattern.Enum.Sizes;
import com.example.prototypepattern.Enum.Tools;

import static com.example.prototypepattern.Enum.Materials.Steel;
import static com.example.prototypepattern.Enum.MaterialsToCover.Plastic;

public class Tool  {
    private Enum<Materials> material;
    private String color;
    private String text;
    private Enum<MaterialsToCover> materialThatCoversIt;
    private int id;
    private Enum<Sizes> size;


    private Enum<Tools> tool;

    public Tool(Enum<Materials> material, String color, String text, Enum<MaterialsToCover> materialThatCoversIt, int id, Enum<Sizes> size,  Enum<Tools> tool) {
        this.material = material;
        this.color = color;
        this.text = text;
        this.materialThatCoversIt = materialThatCoversIt;
        this.id = id;
        this.size = size;
        this.tool = tool;
    }


    public Tool(int id, Enum<Tools> tool, Enum<Sizes> size){
        this.material = Steel;
        this.id = id;
        this.tool = tool;
        this.color = "Silver";
        this.materialThatCoversIt = Plastic;
        this.size = size;
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
        return materialThatCoversIt;
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

    public Enum<Sizes> getSize() {
        return size;
    }

    public void setSize(Enum<Sizes> size) {
        this.size = size;
    }

    public Enum<Tools> getTool() {
        return tool;
    }

    public void setTool(Enum<Tools> tool) {
        this.tool = tool;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "material=" + material +
                ", color='" + color + '\'' +
                ", text='" + text + '\'' +
                ", materialThatCoversIt=" + materialThatCoversIt +
                ", id=" + id +
                ", size=" + size +
                ", tool=" + tool +
                '}';
    }
}
