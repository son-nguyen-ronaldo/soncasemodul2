//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class EmployeeFullTime extends Employee {
    private int salary;
    private int bonus;
    private int fine;

    public EmployeeFullTime() {
    }

    public EmployeeFullTime(int salary, int bonus, int fine) {
        this.salary = salary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public EmployeeFullTime(String id, String name, int age, String address, int phone, String status, String useName, int passwork, int salary, int bonus, int fine) {
        super(id, name, age, address, phone, status, useName, passwork);
        this.salary = salary;
        this.bonus = bonus;
        this.fine = fine;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return this.fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String toString() {
        return "EmployeeFulltime{salary=" + this.salary + ", bonus=" + this.bonus + ", fine=" + this.fine + '}';
    }

    public int calculationSalary() {
        return this.salary + this.bonus - this.fine;
    }
}

