//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.util.Scanner;

public class Validate {
    Scanner scanner;

    public Validate() {
        this.scanner = new Scanner(System.in);
    }

    public int inputInterger() {
        boolean var1 = false;

        while(true) {
            try {
                int number = Integer.parseInt(this.scanner.nextLine());
                return number;
            } catch (Exception var3) {
                System.out.println("Phải là số!!\nNhập lại: ");
            }
        }
    }

    public String checkEmpty() {
        while(true) {
            String s = this.scanner.nextLine();
            if (!s.trim().isEmpty()) {
                return s;
            }

            System.out.println("Dữ liệu trống, vui lòng nhập lại\nNhập lại : ");
        }
    }
}
