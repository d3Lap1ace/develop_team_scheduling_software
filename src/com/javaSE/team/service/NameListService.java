package com.javaSE.team.service;
import com.javaSE.team.domain.*;

import static com.javaSE.team.service.Data.*;
/**
*    @classname NameListService
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/21  00:上午12:13
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class NameListService {
    private Employee[] employees;
    public NameListService(){
        employees = new Employee[EMPLOYEES.length];


        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipments;
            double bonus;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case DESIGNER:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    equipments = equip(i);
                    employees[i] = new Designer(id,name,age,salary,equipments,bonus);
                    break;
                case ARCHITECT:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    equipments =equip(i);
                    employees[i] = new Architect(id,name,age,salary,equipments,bonus,stock);
            }
        }
    }
    public Equipment equip(int id){
        int type = Integer.parseInt(EMPLOYEES[id][0]);
        String modeltype = EMPLOYEES[id][1];
        String desc = EMPLOYEES[id][2];
        switch (type){
            case PC:
                return new Pc(modeltype,desc);
            case NOTEBOOK:
                double price = Double.parseDouble(desc);
                return new Notebook(modeltype,price);
            case PRINTER:
                return new Printer(modeltype,desc);

        }
        return null;
    }



    public Employee[] getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws Exception {
        for (Employee employee : employees) {
            if(employee.getId() == id)
                return employee;
        }
        throw new Exception("该员工不存在");
    }
}
