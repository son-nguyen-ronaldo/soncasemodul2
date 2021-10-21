//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import java.util.ArrayList;
import java.util.List;
import model.Employee;
import writeFile.FileEmployee;

public class ManagerAccountController {
    List<Employee> managerAccountList = new ArrayList();

    public ManagerAccountController(List<Employee> managerAccountList) {
        this.managerAccountList = managerAccountList;
    }

    public void add(Employee employee) {
        this.managerAccountList.add(employee);
        FileEmployee.writeFile(this.managerAccountList, "account.txt");
    }

    public void delete(String useName) {
        this.managerAccountList.remove(this.getIndexOfUseName(useName));
        FileEmployee.writeFile(this.managerAccountList, "account.txt");
    }

    public int getIndexOfUseName(String useName) {
        int index = -1;

        for(int i = 0; i < this.managerAccountList.size(); ++i) {
            if (((Employee)this.managerAccountList.get(i)).getUseName().equals(useName)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public List<Employee> getManagerAccountList() {
        return this.managerAccountList;
    }

    public void setManagerAccountList(List<Employee> managerAccountList) {
        this.managerAccountList = managerAccountList;
    }
}
