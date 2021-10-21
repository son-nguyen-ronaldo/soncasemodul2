//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import controller.EmployeeController;
import java.util.Iterator;
import java.util.List;
import model.Employee;
import model.EmployeeFullTime;
import model.EmployeePartTime;
import writeFile.FileEmployee;

public class EmployeeView {
    private List<Employee> employeeList = FileEmployee.readFile("employee.txt");
    private EmployeeController manager;
    private Validate validate;

    public EmployeeView() {
        this.manager = new EmployeeController("Manager", this.employeeList);
        this.validate = new Validate();
    }

    public Employee newEmployeeFullTime() {
        System.out.println("Nhập tên: ");
        String name = this.validate.checkEmpty();
        String id = this.checkInputId();
        System.out.println("Nhập tuổi: ");
        int age = this.validate.inputInterger();
        System.out.println("Nhập quê quán: ");
        String address = this.validate.checkEmpty();
        System.out.println("Nhập số điện thoại: ");
        int phoneNumber = this.validate.inputInterger();
        System.out.println("Nhập trạng thái: ");
        String status = this.validate.checkEmpty();
        String useName = this.checkInputUseName();
        System.out.println("nhập mật khẩu: ");
        int password = this.validate.inputInterger();
        System.out.println("Nhập tiền lương : ");
        int salary = this.validate.inputInterger();
        System.out.println("Nhập tiền thưởng: ");
        int bonus = this.validate.inputInterger();
        System.out.println("Nhập tiền phạt: ");
        int fine = this.validate.inputInterger();
        Employee employeeFullTime = new EmployeeFullTime(name, id, age, address, phoneNumber, status, useName, password, salary, bonus, fine);
        return employeeFullTime;
    }

    public Employee newEmployeePartTime() {
        System.out.println("Nhập tên: ");
        String name = this.validate.checkEmpty();
        String id = this.checkInputId();
        System.out.println("Nhập tuổi: ");
        int age = this.validate.inputInterger();
        System.out.println("Nhập quê quán: ");
        String address = this.validate.checkEmpty();
        System.out.println("nhập số điện thoại: ");
        int phoneNumber = this.validate.inputInterger();
        System.out.println("Nhập trạng thái: ");
        String status = this.validate.checkEmpty();
        String useName = this.checkInputUseName();
        System.out.println("Nhập mật khẩu: ");
        int password = this.validate.inputInterger();
        System.out.println("Nhập lương tính theo thời gian: ");
        int salaryTime = this.validate.inputInterger();
        System.out.println("Nhập thòi gian làm: ");
        int wordTime = this.validate.inputInterger();
        Employee employeePartTime = new EmployeePartTime(name, id, age, address, phoneNumber, status, useName, password, salaryTime, wordTime);
        return employeePartTime;
    }

    public void addEmployee() {
        System.out.println("Nhập số lượng nhân viên bạn muốn thêm: ");
        int number = this.validate.inputInterger();

        for(int i = 0; i < number; ++i) {
            System.out.println("Ấn 1 để thêm nhân viên Full-Time");
            System.out.println("Ấn 2 để thêm nhân viên Part-TIme");
            int choice = this.validate.inputInterger();
            switch(choice) {
                case 1:
                    System.out.println("Nhập thông tin nhân viên : " + (i + 1));
                    this.manager.addEmployee(this.newEmployeeFullTime());
                    break;
                case 2:
                    System.out.println("Nhập thông tin nhân viên: " + (i + 1));
                    this.manager.addEmployee(this.newEmployeePartTime());
            }
        }

    }

    public void editEmployee() {
        List<Employee> employeeList = this.manager.getEmployeeList();
        System.out.println("Nhập id của nhân viên cần chỉnh sửa: ");
        String id = this.checkId();
        int index = this.manager.getIndexOfId(id);
        if (((Employee)employeeList.get(index)).getStatus() == null) {
            System.out.println("Nhấn phím 1 để chỉnh nhân viên Full-Time:");
            System.out.println("Nhấn phím 2 để chỉnh nhân viên Part-Time:");
            int choice = this.validate.inputInterger();
            switch(choice) {
                case 1:
                    System.out.println("Nhập thông tin: ");
                    this.manager.edit(id, this.newEmployeeFullTime());
                    break;
                case 2:
                    System.out.println("Nhập thông tin:");
                    this.manager.edit(id, this.newEmployeePartTime());
            }
        } else if (employeeList.get(index) instanceof EmployeeFullTime) {
            this.manager.edit(id, this.newEmployeeFullTime());
        } else {
            this.manager.edit(id, this.newEmployeePartTime());
        }

    }

    public void deleteEmployee() {
        System.out.println("Nhập id nhân viên bạn muốn xóa: ");
        String id = this.checkId();
        this.manager.delete(id);
    }

    public void showEmployee() {
        Iterator var1 = this.manager.getEmployeeList().iterator();

        while(var1.hasNext()) {
            Employee employee = (Employee)var1.next();
            System.out.println(employee);
        }

    }

    public void findByName() {
        System.out.println(" Nhập tên để tìm kiếm:");
        String name = this.checkName();
        Iterator var2 = this.manager.findByName(name).iterator();

        while(var2.hasNext()) {
            Employee employee = (Employee)var2.next();
            System.out.println(employee);
        }

    }

    public void calculationSalaryEmployee() {
        System.out.println("Nhập id nhân viên bạn muốn tính lương:");
        String id = this.checkId();
        int salary = this.manager.calculationSalary(id);
        System.out.println("Mức lương của nhân viên có id " + id + " là " + salary);
    }

    public void showEmployeeStatus(String status) {
        Iterator var2 = this.manager.getEmployeeStatus(status).iterator();

        while(var2.hasNext()) {
            Employee employee = (Employee)var2.next();
            System.out.println(employee);
        }

    }

    public void showClassEmployee(String classEmployee) {
        Iterator var2 = this.manager.getClassEmployee(classEmployee).iterator();

        while(var2.hasNext()) {
            Employee employee = (Employee)var2.next();
            System.out.println(employee);
        }

    }

    public void updateStatus() {
        System.out.println("Nhập id của nhân viên muốn cập nhật trạng thái: ");
        String id = this.checkId();
        this.manager.updateStatus(id);
    }

    public void checkStatus() {
        System.out.println("Nhập tên để kiểm tra trạng thái:");
        String name = this.checkName();
        this.manager.findByName(name);

        for(int i = 0; i < this.employeeList.size(); ++i) {
            System.out.println("Nhân viên " + name + ",  có id là  " + ((Employee)this.employeeList.get(i)).getId() + ", trạng thái hiện tại " + ((Employee)this.employeeList.get(i)).getStatus());
        }

    }

    public String checkId() {
        while(true) {
            System.out.println("Nhập id :");
            String id = this.validate.checkEmpty();
            if (this.manager.getIndexOfId(id) != 1) {
                return id;
            }

            System.out.println("Id đã nhập không có trong danh sách nhân viên");
        }
    }

    public String checkName() {
        label15:
        while(true) {
            System.out.println("Nhập tên: ");
            String name = this.validate.checkEmpty();
            Iterator var2 = this.manager.getEmployeeList().iterator();

            Employee employee;
            do {
                if (!var2.hasNext()) {
                    System.out.println("Tên đã nhập không có trong danh sách.");
                    continue label15;
                }

                employee = (Employee)var2.next();
            } while(!employee.getName().equals(name));

            return name;
        }
    }

    public String checkInputId() {
        while(true) {
            System.out.println("Nhập id ");
            String id = this.validate.checkEmpty();
            if (this.manager.getIndexOfId(id) != 1) {
                return id;
            }

            System.out.println("Id đã có trong danh sách.");
        }
    }

    public String checkInputUseName() {
        while(true) {
            System.out.println("Nhập tên : ");
            String nameUse = this.validate.checkEmpty();
            if (this.manager.getIndexOfUserName(nameUse) == -1) {
                return nameUse;
            }

            System.out.println("Tên đã nhập đã tồn tại.");
        }
    }

    public boolean checkLogin(String useName, int password) {
        return this.manager.getIndexOfUserNamePassword(useName, password) != -1;
    }

    public void choiceShow() {
        int choice = -1;

        while(choice != 0) {
            System.out.println("\n Nhấn phím 1 để xem tất cả nhân viên.\n Nhấn phím 2 để hiển thị lương của nhân viên.\n Nhấn phím 3 để hiển thị nhân viên FullTime.\n Nhấn phím 4 để hiển thị nhân viên PartTime.\n Nhấn phím 5 để hiển thị danh sách nhân viên đang hoạt động.\n nhấn phím 6 để hiển thị nhân viên đang nghỉ việc.\n nhấn 0 để quay lại.");
            choice = this.validate.inputInterger();
            switch(choice) {
                case 1:
                    System.out.println("Danh sách nhân viên");
                    this.showEmployee();
                    break;
                case 2:
                    this.calculationSalaryEmployee();
                    break;
                case 3:
                    System.out.println("Danh sách nhân viên Full-Time ");
                    String classFullTime = "EmployeeFullTime";
                    this.showClassEmployee(classFullTime);
                    break;
                case 4:
                    System.out.println("Danh sách nhân viên Part-Time");
                    String classPartTime = "EmployeePartTime";
                    this.showClassEmployee(classPartTime);
                    break;
                case 5:
                    System.out.println("Danh sách nhân viên đang làm việc: ");
                    String statusDoing = "Đang làm";
                    this.showEmployeeStatus(statusDoing);
                    break;
                case 6:
                    System.out.println("Danh sách nhân viên đã nghỉ việc:");
                    String statusNotDoing = "Đang nghỉ";
                    this.showEmployeeStatus(statusNotDoing);
            }
        }

    }

    public void showEmployee(String useName, int password) {
        int index = this.manager.getIndexOfUserNamePassword(useName, password);
        if (index != 1) {
            Employee employee = (Employee)this.manager.getEmployeeList().get(index);
            System.out.println(employee + "\nSố lương là : " + employee.calculationSalary());
            if (employee.getStatus().equals("Chưa được nhận việc")) {
                System.out.println("Đăng kí làm nhân viên Full-Time\n hoặc đăng kí làm nhân viên PArt-Time");
            }
        }

    }

    public void employeeMenu(String useName, int password) {
        int choice = -1;

        while(choice != 0) {
            System.out.println("\nNhấn phím 1 để xem thông tin của bạn \nNhấn 0 để thoát");
            choice = this.validate.inputInterger();
            if (choice == 1) {
                this.showEmployee(useName, password);
            }
        }

    }

    public Employee newMember() {
        System.out.println("Nhập tên: ");
        String name = this.validate.checkEmpty();
        String id = this.checkId();
        System.out.println("Nhập tuổi: ");
        int age = this.validate.inputInterger();
        System.out.println("Nhập quê quán: ");
        String address = this.validate.checkEmpty();
        System.out.println("Nhập số điện thoại: ");
        int phoneNumber = this.validate.inputInterger();
        String status = "Chưa nhận được việc";
        String useName = this.checkInputUseName();
        System.out.println("Nhập mật khẩu");
        int password = this.validate.inputInterger();
        Employee member = new Employee(name, id, age, address, phoneNumber, status, useName, password);
        return member;
    }

    public void addNewMember() {
        this.manager.addEmployee(this.newMember());
    }
}
