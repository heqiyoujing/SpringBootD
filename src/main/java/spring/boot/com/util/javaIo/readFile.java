package spring.boot.com.util.javaIo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2018/12/21
 * @description:
 */
public class readFile {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        getFileInputStream();//FileInputStream
        getFileOutputStream();//FileOutputStream
        getBufferedReaderAndBufferedWriter();//BufferedReader和BufferedWriter
        getInputStreamReader();//InputStreamReader
        getnewBufferedReader();//Path和newBufferedReader
        Convert();//对象转化为json，json转化为map
    }

    /**FileInputStream的用法*/
    public static void getFileInputStream(){
        try {
            String path = "D:/1.txt";
            File file = new File(path);
            //参数是file或者path，都一样，都可以
            FileInputStream fileInputStream = new FileInputStream(path);//文件输入流
            byte[] data = new byte[1024];
            fileInputStream.read(data);
            String str = new String(data, "GBK");
            System.out.println(str);
        } catch (Exception e) {

        }
    }
    /**FileOutputStream的用法*/
    public static void getFileOutputStream(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/02.txt");
            String name = "FileOutputStream类提供了多种文件写入方法，可以单独写一个字节到文" +
                    "件，也可以写一个byte数组到文件，也可以取byte数组的部分数据写入到文件。";
            fileOutputStream.write(name.getBytes("utf-8"));//文件输出流
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**BufferedReader和BufferedWriter的用法*/
    public static void  getBufferedReaderAndBufferedWriter() throws IOException {
        Path path = Paths.get("D:/1.txt");
        if (path.toFile().exists()) {
            long size = path.toFile().length()/(1024*1024);
            System.out.println("文件大小为：" + size + "M");
        }
        //产生乱码
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:/1.txt")));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("D:/03.txt")));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                bfw.write(line);
               bfw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bfw.close();
        }
    }
    /**InputStreamReader的用法*/
    public static void getInputStreamReader() throws IOException {
        Path path = Paths.get("D:/1.txt");
        if (path.toFile().exists()) {
            long size = path.toFile().length()/(1024*1024);
            System.out.println("文件大小为：" + size + "M");
        }
        //不产生乱码
        // 定义一个指向D:/TEXT.TXT 的字节流、字节流转换成InputStreamReader 、InputStreamReader 转换成带缓存的bufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile()),"GBK"));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("D:/04.txt")));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                bfw.write(line);
                bfw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bfw.close();
        }
    }

    /**Path和newBufferedReader的用法*/
    public static void getnewBufferedReader() throws IOException {
        Path path = Paths.get("D:/1.txt");
        if (path.toFile().exists()) {
            System.out.println("文件存在");
        }
        BufferedReader reader = Files.newBufferedReader(path, Charset.forName("GBK"));
        BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("D:/05.txt")));
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                bfw.write(line);
                bfw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            bfw.close();
        }
    }

    /**对象转化为json，json转化为map*/
    public static void Convert() throws IOException {
        User user = new User("yiqq",28);
        System.out.println(user);
        //对象转Json
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        //Json转map
        Map param = objectMapper.readValue(json, Map.class);
        System.out.println(param);
    }
}
