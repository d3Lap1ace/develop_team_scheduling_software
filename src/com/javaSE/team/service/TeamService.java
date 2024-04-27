package com.javaSE.team.service;

import com.javaSE.team.domain.Architect;
import com.javaSE.team.domain.Designer;
import com.javaSE.team.domain.Employee;
import com.javaSE.team.domain.Programmer;

import static com.javaSE.team.service.Status.BUSY;

/**
*    @classname TeamService
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/21  00:上午12:35
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class TeamService {
    static int count = 1;  //用来为开发团队新增成员自动生成团队中的唯一ID
    final int MAX_MEMBER = 5;  //表示开发团队最大成员数

    Programmer[] team = new Programmer[MAX_MEMBER];  //用来保存当前团队中的各成员对象
    int total = 0; //记录团队成员的实际人数


    //方法：返回当前团队的所有对象  返回：包含所有成员对象的数组，数组大小与成员人数一致
    public Programmer[] getTeam(){
        return team;
    }

    /**addMember(e: Employee)方法：向团队中添加成员
        参数：待添加成员的对象
        异常：添加失败， TeamException中包含了失败原因
     */

    public void addMember(Employee e) throws TeamException{
        if(total == MAX_MEMBER){
            throw new TeamException("成员已满");
        }

        if(!(e instanceof Programmer)){
            throw new TeamException("该员工不是开发人员");
        }else {
            for (int i = 0; i < team.length; i++) {
                if(e.getId() == team[i].getId()){
                    throw new TeamException("该员工已在开发团队中");
                }
            }
        }

        Programmer p = (Programmer)e;

        if(p.getStatus().equals(BUSY)){
            throw new TeamException("该员工已是某团队成员");
        }
        if(p.getStatus().equals(Status.VOCATION)){
            throw new TeamException("该员工正在休假,无法添加");
        }

        int countPro = 0;
        int countArch = 0;
        int countDes = 0;

        for (int i = 0; i < team.length; i++) {
            if(team[i] instanceof Programmer) countPro++;
            if(team[i] instanceof Designer) countDes++;
            if(team[i] instanceof Architect) countArch++;
        }
        if (p instanceof Programmer){
            if(countPro >= 3) throw new TeamException("团队中至多有三名程序员");
        }else if(p instanceof Designer){
            if(countDes >= 2) throw new TeamException("团队中至多有二名设计师");
        }else if(p instanceof Architect){
            if(countArch >= 1) throw new TeamException("团队中至多有一名架构师");
        }

        p.setStatus(BUSY);
        p.setMemberld(count++);
        team[total++] = p;


    }

    /** 方法：从团队中删除成员
        参数：待删除成员的memberId
        异常：找不到指定memberId的员工，删除失败
    */
    public void removeMember(int memberId) throws TeamException {

        for (int i = 0; i < total; i++) {
            if (team[i].getMemberld() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
            if (i == total)
                throw new TeamException("找不到该成员，无法删除");
            for (int k = i + 1; k < total; k++) {
                team[k - 1] = team[k];
            }
            team[--total] = null;
        }

    }



}
