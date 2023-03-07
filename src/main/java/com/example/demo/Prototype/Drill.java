package com.example.demo.Prototype;

import com.example.demo.Enum.Tools;
import com.example.demo.Model.Tool;
import static com.example.demo.Enum.Materials.Steel;
import static com.example.demo.Enum.MaterialsToCover.Plastic;


public class Drill extends Tool {

    public Drill(int id) {
        super();
        this.setMaterial(Steel);
        this.setId(id);
        this.setColor("Silver");
        this.setTool(Tools.Drill);
        this.setText("");
    }

    @Override
    public Tool clone() {
        return new Drill(this.getId());
    }
}
