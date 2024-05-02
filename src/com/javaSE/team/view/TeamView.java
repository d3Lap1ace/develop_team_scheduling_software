package com.javaSE.team.view;

import com.javaSE.team.domain.Employee;
import com.javaSE.team.domain.Programmer;
import com.javaSE.team.service.NameListService;
import com.javaSE.team.service.TeamException;
import com.javaSE.team.service.TeamService;

/**
*    @classname Main
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/20  23:下午11:27
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class TeamView {

    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //主页面显示及控制方法
    public void enterMainMenu() throws Exception {
        boolean flag = true;
        char c = 0;

        do {
            if(c != '1'){
                listAllEmployee();
            }
            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            c = TSUtility.readMenuSelection();
            System.out.println();
            switch (c){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否要退出?(Y/N)");
                    char q = TSUtility.readConfirmSelection();
                    if(q == 'Y')
                        flag = false;
                    break;
            }
        } while (flag);
    }
    //以表格的形式列出公司所有成员
    private void listAllEmployee(){
        System.out.println("\n------------------开发团队调度软件---------------------");
        Employee[] emp = listSvc.getEmployees();
        if(emp.length == 0){
            System.out.println("没有人!");
        }else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        }
        for (Employee employee : emp) {
            System.out.println(" "+employee);
        }
        System.out.println("----------------------------------------------------------");
    }

    //显示团队成员列表操作
    private void getTeam(){
        System.out.println("\n--------------团队成员列表---------------");
        Programmer[] team = teamSvc.getTeam();
        if(team.length == 0){
            System.out.println("开发团队目前没有成员!");
            return;
        }else {
            System.out.println("TID/ID\\t姓名\\t年龄\\t工资\\t职位\\t奖金\\t股票\"");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam()+" ");
            }
        }
        System.out.println("--------------------------------------------------------");
    }

    //实现添加成员操作
    private void addMember() throws Exception {
        System.out.println("----------添加成员------------");
        System.out.print("请输入要添加的员工ID:");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功!");
        } catch (TeamException employee) {
            System.out.println("添加失败的原因是:"+ employee.getMessage());
        }
        TSUtility.readReturn();
    }

    //实现删除成员操作
    public void deleteMember(){
        System.out.println("--------------删除成员-----------------");
        System.out.print("请输入要删除员工的Tid:");
        int tid = TSUtility.readInt();
        System.out.print("确定是否删除(Y/N):");
        char c = TSUtility.readConfirmSelection();
        if(c == 'N')
            return;
        try {
            teamSvc.removeMember(tid);
        } catch (TeamException e) {
            System.out.println("删除失败的原因是:"+e.getMessage());
        }
        System.out.println("删除成功!");
        TSUtility.readReturn();

    }

    public static void main(String[] args) throws Exception {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
