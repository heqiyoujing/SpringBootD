package spring.boot.com.comparator;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class SchoolTwo implements Comparable<SchoolTwo>{
    private int code;
    private String sname;
    public SchoolTwo(int code, String sname) {
        this.code = code;
        this.sname = sname;
    }
    public int getCode() {
        return code;
    }
    public String getSname() {
        return sname;
    }
    @Override
    public int compareTo(SchoolTwo s) {
        return s.sname.compareTo(sname);
    }
}
