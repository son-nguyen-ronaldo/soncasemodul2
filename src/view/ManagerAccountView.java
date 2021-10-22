//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import controller.ManagerAccountController;
import java.util.Iterator;
import java.util.List;
import model.Employee;
import writeFile.FileEmployee;

public class ManagerAccountView {
    private List<Employee> employeeList = FileEmployee.readFile("employee.txt");
    private List<Employee> managerAccountList = FileEmployee.readFile("account.txt");
    private ManagerAccountController managerAccountController;
    private Validate validate;

    public ManagerAccountView() {
        this.managerAccountController = new ManagerAccountController(this.managerAccountList);
        this.validate = new Validate();
    }

    public int getIndexOfEmployee(String useName, int password) {
        int index = -1;

        for(int i = 0; i < this.employeeList.size(); ++i) {
            Employee employee = (Employee)this.employeeList.get(i);
            if (employee.getUseName().equals(useName) && employee.getPassword() == password) {
                index = i;
                break;
            }
        }

        return index;
    }

    public Employee newManagerAccount() {
        boolean var1 = false;

        while(true) {
            String useName = this.checkInputUseName();
            System.out.println("Nhập mật khẩu: ");
            int password = this.validate.inputInterger();
            int index = this.getIndexOfEmployee(useName, password);
            if (index != -1) {
                return (Employee)this.employeeList.get(index);
            }

            System.out.println("Nhân viên không tồn tại hoặc nhập sai tên người dùng và mật khẩu !!");
        }
    }

    public void addManagerAccount() {
        this.managerAccountController.add(this.newManagerAccount());
    }

    public void deleteManagerAccount() {
        System.out.println("Nhập tên người dùng của tài khoản bạn muốn xóa: ");
        String useName = this.checkUseName();
        this.managerAccountController.delete(useName);
    }

    public String checkInputUseName() {
        while(true) {
            System.out.println("Nhập tên đăng nhập: ");
            String usename = this.validate.checkEmpty();
            if (this.managerAccountController.getIndexOfUseName(usename) == -1) {
                return usename;
            }

            System.out.println("\ntên đăng kí đã được sử dụng!!");
        }
    }

    public String checkUseName() {
        while(true) {
            System.out.println("Nhập tên đăng nhập");
            String username = this.validate.checkEmpty();
            if (this.managerAccountController.getIndexOfUseName(username) == -1) {
                return username;
            }

            System.out.println("\nTên đăng nhập không tồn tại!!");
        }
    }

    public void showMAnagerAccount(String username, int password) {
        List<Employee> managerAccountList = this.managerAccountController.getManagerAccountList();
        Iterator var4 = managerAccountList.iterator();

        while(var4.hasNext()) {
            Employee employee = (Employee)var4.next();
            if (employee.getUseName().equals(username) && employee.getPassword() == password) {
                System.out.println("thông tin tài khoản\n" + employee + " lương là:" + employee.calculationSalary());
            }
        }

    }

    public void showManagerAccountList() {
        List<Employee> managerAccountList = this.managerAccountController.getManagerAccountList();
        Iterator var2 = managerAccountList.iterator();

        while(var2.hasNext()) {
            Employee employee = (Employee)var2.next();
            System.out.println(employee) ;
        }

    }

    public boolean checkLogin(String userName, int password) {
        List<Employee> managerAccountList =   this.managerAccountController.getManagerAccountList();
        Iterator var4 =  managerAccountList.iterator();

        Employee employee;
        do {
            if (!var4.hasNext()) {
                return false;
            }

            employee  = (Employee)var4.next();
        } while(!employee.getUseName().equals(userName) || employee.getPassword() != password);

        return true;
    }

    public void  adminMenu() {
        int choice = -1;

        while(choice != 0) {
            System.out.println("\n Nhấn phím  1 để thêm tài khoản quản lý nhân viên.\n Nhấn phím 2 để xóa tài khoản quản lý nhân viên.\n Nhấn phím 3 để hiển thị tài khoản đăng nhập quản lý người dùng.\n Nhấn phím 0 để thoát.");
            choice = this.validate.inputInterger();
            switch(choice) {
                case 1:
                    System.out.println("Nhập tên người dùng và mật khẩu của nhân viên bạn muốn thêm vào vị trí quản lý");
                    this.addManagerAccount();
                    System.out.println("Đã thêm tài khoản thành công");
                    break;
                case 2:
                    this.deleteManagerAccount();
                    break;
                case 3:
                    System.out.println("\nhiển thị danh sách thông tin tài khoản đăng nhập quản lý");
                    this.showManagerAccountList();
            }
        }

    }
}
