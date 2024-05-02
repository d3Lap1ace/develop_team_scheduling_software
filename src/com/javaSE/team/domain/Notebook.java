package com.javaSE.team.domain;

/**
*    @classname Notebook
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:43
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Notebook implements Equipment{
    private String model;
    private double price;


    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public Notebook() {
        super();
    }


    public Notebook(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }


    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
}
