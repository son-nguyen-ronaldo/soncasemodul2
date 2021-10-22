//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package writeFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Employee;

public class FileEmployee {
    public FileEmployee() {
    }

    public static void writeFile(List<Employee> employeeList, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(employeeList);
            objectOut.close();
            fileOut.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public static List<Employee> readFile(String fileName) {
        List<Employee> employees = new ArrayList();
        File file = new File(fileName);
        if (file.length() > 0L) {
            try {
                FileInputStream fileInput = new FileInputStream(file);
                ObjectInputStream  objectInput = new ObjectInputStream(fileInput);
                employees = (List)objectInput.readObject();
            } catch (ClassNotFoundException | IOException var5) {
                var5.printStackTrace();
            }
        }

        return (List)employees;
    }
}

