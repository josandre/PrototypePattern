package com.example.demo.Prototype;

import com.example.demo.Enum.Tools;
import com.example.demo.Model.Tool;
import static com.example.demo.Enum.Materials.Steel;


public class Spanner extends Tool {
    public Spanner(int id) {
        super();
        this.setMaterial(Steel);
        this.setId(id);
        this.setColor("Silver");
        this.setTool(Tools.Spanner);
        this.setText("");
    }

    @Override
    public Tool clone() {
        return new Spanner(this.getId());
    }
}
