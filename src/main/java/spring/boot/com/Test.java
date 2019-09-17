package spring.boot.com;

import spring.boot.com.entity.Employee;
import sun.awt.geom.AreaOp;

import java.io.*;

/**
 * @author: yiqq
 * @date: 2019/4/25
 * @description: 用流写进一个对象，再读出一个对象
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee emp1 = new Employee();
        emp1.setName("Naresh");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(emp1);
        out.close();
        //Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        Employee emp5 = (Employee) in.readObject();
        in.close();
        emp5.setName("Akash");
        //居然用对象流写入一个对象，再读出一个对象
        System.out.println(emp5 + ", hashcode : " + emp5.hashCode());
        int userId = null instanceof Integer ? null : 0;
        System.out.println(userId);
    }

    public static void testCamelCase() throws IOException {
        try (InputStream inputStream = new FileInputStream("D:/1.txt")) {
            //...
        }
    }
}
