package spring.boot.com.util.CookieAndSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yiqq
 * @date: 2019/3/27
 * @description: Cookie
 *  https://blog.csdn.net/zcl_love_wx/article/details/51992999
 */
public class CookieTool {
    /**
     Cookie类的各方法:
     1.setValue(String newValue):给当前cookie重新赋值
     2.setComment(String purpose):对该cookie进行描述的信息(说明作用)，浏览器显示cookie信息时能看到
     3.setDomain(String pattern):符合该pattern（域名正则）的就可以访问该Cookie的域名。注意第一个字符必须为“.”
     4.setHttpOnly(boolean httpOnly):设为true后，只能通过http访问，javascript无法访问,还可防止xss读取cookie
     5.setMaxAge(int expiry):该Cookie失效时间，单位秒。如果为正数，则该Cookie在expiry秒之后失效。
        如果为负数，该Cookie为临时Cookie，关闭浏览器即失效，浏览器也不会以任何形式保存该Cookie。如果为0，表示删除该Cookie。默认为–1
     6.setPath(String uri)	:设置Cookie的使用路径。后面紧接着详解。如果设置为“/agx/”，则只有uri为“/agx”的程序可以访问该Cookie。
        如果设置为“/”，则本域名下的uri都可以访问该Cookie。注意最后一个字符必须为”/”
     7.setSecure(boolean flag):是否使用安全传输协议。为true时，只有当是https请求连接时cookie才会发送给服务器端,但是服务端还是可以发送给浏览端的。
     */
    public static void main(String[] args) {

    }

    /**
     * 删除cookie
     * @param request http请求
     * @param response http响应
     * @param name cookie名称
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String name){
        Cookie[] cookies = request.getCookies();
        if (null==cookies) {
        } else {
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);// 设置生命周期为0，表示将要删除
                    cookie.setPath("/");
                    System.out.println("被删除的cookie名字为:"+cookie.getName());
                    response.addCookie(cookie); // 执行添加后就从response里覆盖修改了
                    break;
                }
            }
        }
    }

    /**
     *通过name获取cookie
     * @param request http请求
     * @param name cookie名称
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap = ReadCookieMap(request);
        if(cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else{
            return null;
        }
    }
    private static  Map<String,Cookie> ReadCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if(null!=cookies){
            for(Cookie cookie : cookies){
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 添加cookie
     * @param response http响应
     * @param key cookie的key
     * @param value cookie的名称
     */
    public static void addCookie(HttpServletResponse response,String key,String value){
        Cookie cookie = new Cookie(key,value);// 新建一个Cookie对象
        cookie.setMaxAge(-1);// 设置生命周期
        cookie.setPath("/");//设置路径，同一服务器内所有应用都可访问到该Cookie
        response.addCookie(cookie);// // 保存cookie到客户端
    }

}
