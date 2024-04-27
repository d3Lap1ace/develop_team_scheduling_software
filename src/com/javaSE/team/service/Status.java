package com.javaSE.team.service;

/**
*    @enumName Status
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:57
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class Status {
    ;
    private final String NAME;
    private Status (String name){
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
