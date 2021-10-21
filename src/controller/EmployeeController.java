//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import java.util.ArrayList;
import java.util.List;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;
import writeFile.FileEmployee;

public class EmployeeController {
    private String name;
    List<Employee> employeeList = new ArrayList();

    public EmployeeController() {
    }

    public EmployeeController(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
        FileEmployee.writeFile(this.employeeList, "employee.txt");
    }

    public void edit(String id, Employee employee) {
        int index = this.getIndexOfId(id);
        this.employeeList.set(index, employee);
        FileEmployee.writeFile(this.employeeList, "employee.txt");
    }

    public void delete(String id) {
        this.getIndexOfId(id);
        this.employeeList.remove(id);
        FileEmployee.writeFile(this.employeeList, "employee.txt");
    }

    public List<Employee> findByName(String name) {
        List<Employee> employees = new ArrayList();

        for(int i = 0; i < this.employeeList.size(); ++i) {
            if (((Employee)this.employeeList.get(i)).getName().equals(name)) {
                employees.add(this.employeeList.get(i));
            }
        }

        return employees;
    }

    public int calculationSalary(String id) {
        int index = this.getIndexOfId(id);
        Employee employee = (Employee)this.employeeList.get(index);
        return employee instanceof EmployeeFullTime ? employee.calculationSalary() : employee.calculationSalary();
    }

    public int getIndexOfUserName(String userName) {
        int index = -1;

        for(int i = 0; i < this.employeeList.size(); ++i) {
            Employee employee = (Employee)this.employeeList.get(i);
            if (employee.getUseName().equals(userName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int getIndexOfUserNamePassword(String name, int password) {
        int index = -1;

        for(int i = 0; i < this.employeeList.size(); ++i) {
            Employee employee = (Employee)this.employeeList.get(i);
            if (employee.getUseName().equals(name) && employee.getPassword() == password) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int getIndexOfId(String id) {
        int index = -1;

        for(int i = 0; i < this.employeeList.size(); ++i) {
            if (((Employee)this.employeeList.get(i)).getId().equals(id)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public List<Employee> getEmployeeStatus(String status) {
        List<Employee> employees = new ArrayList();

        for(int i = 0; i < this.employeeList.size(); ++i) {
            if (((Employee)this.employeeList.get(i)).getStatus().equals(status)) {
                employees.add(this.employeeList.get(i));
            }
        }

        return employees;
    }

    public void updateStatus(String id) {
        int index = this.getIndexOfId(id);
        if (((Employee)this.employeeList.get(index)).getStatus().equals("Đang làm")) {
            ((Employee)this.employeeList.get(index)).setStatus("Đã nghỉ");
        } else {
            ((Employee)this.employeeList.get(index)).setStatus("Đang làm");
        }

        FileEmployee.writeFile(this.employeeList, "employee.txt");
    }

    public List<Employee> getClassEmployee(String classEmployee) {
        List<Employee> classEmployees = new ArrayList();
        int i;
        if (classEmployee.equals("EmployeeFullTime")) {
            for(i = 0; i < this.employeeList.size(); ++i) {
                if (this.employeeList.get(i) instanceof EmployeeFullTime) {
                    classEmployees.add(this.employeeList.get(i));
                }
            }

            return classEmployees;
        } else if (classEmployee.equals("EmployeePartTime")) {
            for(i = 0; i < this.employeeList.size(); ++i) {
                if (this.employeeList.get(i) instanceof EmployeePartTime) {
                    classEmployees.add(this.employeeList.get(i));
                }
            }

            return classEmployees;
        } else {
            return null;
        }
    }
}
