package com.javaSE.team.domain;

/**
*    @classname Printer
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:45
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Printer implements Equipment{
    private String name;
    private String type;

    public Printer() {
        super();
    }

    public Printer(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
