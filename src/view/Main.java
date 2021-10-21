//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

public class Main {
    static EmployeeView employeeView = new EmployeeView();
    static ManagerAccountView managerAccountView = new ManagerAccountView();
    static Validate validate = new Validate();

    public Main() {
    }

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choice = -1;

        while(choice != 0) {
            System.out.println("\n Nhấn phím 1 để đăng nhập.\n Nhấn phím 2 để đăng ký tài khoản mới.\n Nhấn 0 để thoát");
            choice = validate.inputInterger();
            switch(choice) {
                case 1:
                    login();
                    break;
                case 2:
                    System.out.println("Vui lòng nhập các thông tin sau");
                    employeeView.addNewMember();
                    System.out.println("Đăng ký tài khoản thành công!");
            }
        }

    }

    public static boolean checkLoginAdmin(String username, int password) {
        return username.equals("admin") && password == 123456;
    }

    public static void login() {
        for(int i = 0; i < 3; ++i) {
            System.out.println("Nhập tên đăng nhập: ");
            String username = validate.checkEmpty();
            System.out.println("Nhập mật khẩu: ");
            int password = validate.inputInterger();
            if (checkLoginAdmin(username, password)) {
                int choice = -1;

                while(choice != 0) {
                    System.out.println("\n Nhấn phím 1 để truy cập quản lý nhân viên.\n Nhấn phím 2 để truy cập quản lý tài khoản nhân viên.\n Nhấn 0 để thoát");
                    choice = validate.inputInterger();
                    switch(choice) {
                        case 1:
                            employeeManagerMenu(username, password);
                            break;
                        case 2:
                            managerAccountView.adminMenu();
                    }
                }

                return;
            }

            if (managerAccountView.checkLogin(username, password)) {
                employeeManagerMenu(username, password);
                break;
            }

            if (employeeView.checkLogin(username, password)) {
                employeeView.employeeMenu(username, password);
                break;
            }

            System.out.println("Tên đăng nhập hoặc mật khẩu của bạn không chính xác " + (i + 1));
            if (i == 2) {
                System.out.println("Bạn đã nhập sai hơn 3 lần, quay lại menu ");
            }
        }

    }

    public static void employeeManagerMenu(String username, int password) {
        int choice = -1;

        while(choice != 9) {
            System.out.println("MENU: \n Nhấn phím 1 để thêm nhân viên.\n Nhấn phím 2 để chỉnh sửa thông tin nhân viên.\n Nhấn phím 3 để hiển thị,\n Nhấn phím 4 để tìm kiếm nhân viên.\n Nhấn phím 5 để kiểm tra trạng thái nhân viên.\n Nhấn phím 6 để thay đổi trạng thái nhân viên.\n Nhấn phím 7 để xóa nhân viên.\n Nhấn phím 8 để xem thông tin tài khoản.\n Nhấn phím 9 để đăng xuất.");
            choice = validate.inputInterger();
            switch(choice) {
                case 1:
                    employeeView.addEmployee();
                    break;
                case 2:
                    employeeView.editEmployee();
                    break;
                case 3:
                    employeeView.choiceShow();
                    break;
                case 4:
                    employeeView.findByName();
                    break;
                case 5:
                    employeeView.checkStatus();
                    break;
                case 6:
                    employeeView.updateStatus();
                    break;
                case 7:
                    employeeView.deleteEmployee();
                    break;
                case 8:
                    managerAccountView.showMAnagerAccount(username, password);
            }
        }

    }
}
