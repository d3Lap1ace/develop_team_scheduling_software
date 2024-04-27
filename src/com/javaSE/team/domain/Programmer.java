package com.javaSE.team.domain;

import com.javaSE.team.service.Status;

/**
*    @classname Programmer
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:50
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Programmer extends Employee implements Equipment{
    private int memberld;
    private Status status;
    private Equipment equipment;

    @Override
    public String getDescription() {
        return "Programmer{" +
                "memberld=" + memberld +
                ", status=" + status +
                ", equipment=" + equipment +
                '}';
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "memberld=" + memberld +
                ", status=" + status +
                ", equipment=" + equipment +
                '}';
    }

    public Programmer(){};
    public Programmer(int memberld, Status status, Equipment equipment) {
        this.memberld = memberld;
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, int memberld, Status status, Equipment equipment) {
        super(id, name, age, salary);
        this.memberld = memberld;
        this.status = status;
        this.equipment = equipment;
    }
    public Programmer(int id, String name, int age, double salary) {
        super(id, name, age, salary);
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberld() {
        return memberld;
    }

    public void setMemberld(int memberld) {
        this.memberld = memberld;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
