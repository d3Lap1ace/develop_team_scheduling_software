package com.javaSE.team.domain;

/**
*    @classname Pc
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:46
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Pc implements Equipment{
    private String model;
    private String display;

    public Pc() {
        super();
    }

    public Pc(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
