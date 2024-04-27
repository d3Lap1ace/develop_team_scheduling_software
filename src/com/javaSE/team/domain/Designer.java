package com.javaSE.team.domain;

import com.javaSE.team.service.Status;

/**
*    @classname Designer
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/21  00:上午12:07
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Designer extends Programmer{
    private double bonus;



    @Override
    public String toString() {
        return "Designer{" +
                "bonus=" + bonus +
                '}';
    }

    public Designer(int id, String name, int age, double salary,  Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
