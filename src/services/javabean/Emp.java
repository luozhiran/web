package services.javabean;

import java.util.Date;

public class Emp {
    private int empno;//定义雇员编号，与emp表中的empno类型对应
    private String ename;//定义雇员名称
    private String job;//定义雇佣职位
    private Date hiredate;//定义雇佣日期
    private float sola;//定义基本工资

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public float getSola() {
        return sola;
    }

    public void setSola(float sola) {
        this.sola = sola;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sola=" + sola +
                '}';
    }
}
