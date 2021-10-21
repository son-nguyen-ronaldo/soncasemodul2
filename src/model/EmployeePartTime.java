//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class EmployeePartTime extends Employee {
    private int salaryTime;
    private int workTime;

    public EmployeePartTime() {
    }

    public EmployeePartTime(int salaryTime, int workTime) {
        this.salaryTime = salaryTime;
        this.workTime = workTime;
    }

    public EmployeePartTime(String id, String name, int age, String address, int phone, String status, String useName, int passwork, int salaryTime, int workTime) {
        super(id, name, age, address, phone, status, useName, passwork);
        this.salaryTime = salaryTime;
        this.workTime = workTime;
    }

    public int getSalaryTime() {
        return this.salaryTime;
    }

    public void setSalaryTime(int salaryTime) {
        this.salaryTime = salaryTime;
    }

    public int getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String toString() {
        return "EmployeeParttime{salaryTime=" + this.salaryTime + ", workTime=" + this.workTime + '}';
    }

    public int calculationSalary() {
        return this.salaryTime * this.workTime;
    }
}
