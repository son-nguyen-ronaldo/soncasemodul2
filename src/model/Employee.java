//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String address;
    private int phone;
    private String status;
    private String useName;
    private int password;

    public Employee() {
    }

    public Employee(String id, String name, int age, String address, int phone, String useName, int password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.useName = useName;
        this.password = password;
    }

    public Employee(String id, String name, int age, String address, int phone, String status, String useName, int password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.useName = useName;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUseName() {
        return this.useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public int getPassword() {
        return this.password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String toString() {
        return "Employee{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", age=" + this.age + ", address='" + this.address + '\'' + ", phone=" + this.phone + ", status='" + this.status + '\'' + ", useName='" + this.useName + '\'' + ", password=" + this.password + '}';
    }

    public int calculationSalary() {
        return 0;
    }
}
