package spring.boot.com.comparator;

/**
 * @author: yiqq
 * @date: 2019/4/29
 * @description:
 */
public class SchoolThree implements Comparable<SchoolThree>{
    private String sname;
    private String city;
    public SchoolThree(String sname, String city) {
        this.sname = sname;
        this.city = city;
    }
    public String getSname() {
        return sname;
    }
    public String getCity() {
        return city;
    }
    @Override
    public int compareTo(SchoolThree s) {
        return s.getCity().compareTo(city);
    }

}
