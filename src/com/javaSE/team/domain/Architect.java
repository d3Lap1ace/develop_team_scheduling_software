package com.javaSE.team.domain;

import com.javaSE.team.service.Status;

/**
*    @classname Architect
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/21  00:上午12:08
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Architect extends Designer{
    private int stock;



    @Override
    public String toString() {
        return "Architect{" +
                "stock=" + stock +
                '}';
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
