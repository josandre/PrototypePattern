package com.example.demo.Prototype;

import com.example.demo.Enum.Tools;
import com.example.demo.Model.Tool;
import static com.example.demo.Enum.Materials.Steel;
import static com.example.demo.Enum.MaterialsToCover.Plastic;


public class DoublePressurePliers extends Tool {

    public DoublePressurePliers(int id) {
        super();
        this.setMaterial(Steel);
        this.setId(id);
        this.setColor("Silver");
        this.setTool(Tools.DoublePressurePliers);
        this.setText("");
    }

    @Override
    public Tool clone() {
        return new DoublePressurePliers(this.getId());
    }
}
