package spring.boot.com.stringAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: yiqq
 * @date: 2019/4/30
 * @description: 几道字符串相关的算法题
 * https://mp.weixin.qq.com/s?__biz=MzU0OTk3ODQ3Ng==&mid=2247484941&idx=1&sn=c007bfd89b04c3f88d11d54a5568924a&chksm=fba6ee0eccd167181092237a18b9cfd52ec21f073d30dd58e467a5454cdac613ff967ae12e3e&scene=0&xtrack=1#rd
 */
public class HuiWenChuan {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("判断回文串----->>>>>" + isPalindrome(str));
        List<List<String>> lists = partition("aab");
        System.out.println("分割回文串：" + lists);
        int a = StrToInt("-1112");
        System.out.println("把字符串转换成整数----->>>>>" + a);
        boolean flag = wordBreak("leetcode", Arrays.asList("leet","code"));
        System.out.println("单词拆分----->>>>>leetcode返回：" + flag);
        boolean flag1 = wordBreak("applepenapple", Arrays.asList("apple","pen"));
        System.out.println("单词拆分----->>>>>applepenapple返回：" + flag1);
        boolean flag2 = wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println("单词拆分----->>>>>catsandog返回：" + flag2);
    }

    /**
     *  1.验证回文串
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    //回文串,只包含字符串
    public static boolean isPalindroom(String s,int left,int right){
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return left>=right;
    }

    /**
     * 2.分割回文串
     * https://blog.csdn.net/sunday0904/article/details/70153510
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if(s == null){
            return result;
        }
        List<String> temp = new ArrayList<String>();
        if(s.length() == 0){
            result.add(temp);
            return result;
        }
        search(s , result , temp ,0);
        return result;

    }
    private static void search(String s , List<List<String>> result , List<String> temp , int start){
        if(start == s.length()){
            List<String> p = new ArrayList<String>(temp);
            result.add(p);
            return;
        }
        for(int i = start;i<s.length();i++){
            if(isPartition(s.substring(start , i+1))){
                temp.add(s.substring(start , i+1));
                search(s , result , temp , i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    //回文串
    private static boolean isPartition(String temp){
        int i = 0;
        int j = temp.length() - 1;
        while(i<j){
            if(temp.charAt(i) != temp.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 3.把字符串转换成整数
     * @param str
     * @return
     */
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }

    /**
     * 4.单词拆分
     * @param s 非空字符串 s
     * @param wordDict  一个包含非空单词列表的字典 wordDict
     * @return s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * https://blog.csdn.net/microopithecus/article/details/88291095
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i=1;i<=n;i++){
            for (int j = 0; j <i ; j++) {
                if (dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];

    }

}
