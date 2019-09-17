package spring.boot.com.util.weixinDocument;

/**
 * @author:
 * @date: 2019/4/12
 * @description: 微信里的"文档"
 */
public class WeiDocument {
    /**
     1. CGLIB动态代理：
         1.指明一系列的接口来创建一个代理对象
         2.创建一个类实现MethodInterceptor，重写intercept方法，MethodProxy.invokeSuper(obj, params)
         3.给目标对象创建一个代理对象：利用Enhancer设置它的属性setSuperclass(代理对象)和setCallback(实现类)
         4.利用Enhancer创建对象
         5.调用对象的方法
     2. 创建动态代理对象的步骤：
         1. 指明一系列的接口来创建一个代理对象
         2. 创建一个调用处理器（InvocationHandler）对象。重写invoke方法，method.invoke(srcObject,args)。
         3. 将这个代理指定为某个其他对象的代理对象
         4. 在调用处理器的invoke（）方法中采取代理，一方面将调用传递给真实对象，另一方面执行各种需要的操作
         5.Class<? extends IService> clazz = Object.getClass();
         Object proxyService = (Object) Proxy.newProxyInstance(clazz.getClassLoader(),
         clazz.getInterfaces(), new ServiceInvocationHandler(service));
     3.mybatis动态update
         <update id="updateByPrimaryKeySelective" parameterType="me.gacl.domain.User" >
         update t_user
         <set >
         <if test="userName != null" >
         user_name = #{userName,jdbcType=VARCHAR},
         </if>
         </set>
         where user_id = #{userId,jdbcType=CHAR}
         </update>
     4.mybatis动态insert
         <insert id="insertSelective" parameterType="me.gacl.domain.User" >
         insert into t_user
         <trim prefix="(" suffix=")" suffixOverrides="," >
         <if test="userId != null" >
         user_id,
         </if>
         </trim>
         <trim prefix="values (" suffix=")" suffixOverrides="," >
         <if test="userId != null" >
         #{userId,jdbcType=CHAR},
         </if>
         </trim>
         </insert>
     5.mybatis循环
         <foreach collection="list" index="index" item="item" open="(" separator="," close=")">
         #{item}
         </foreach>
     6.hashMap的数组长度一定保持2的次幂：
        1.扩容后保证得到的新的数组索引和老数组索引一致(大大减少了之前已经散列良好的老数组的数据位置重新调换)
        2.数组长度保持2的次幂，length-1的低位都为1，会使得获得的数组索引index更加均匀
     7.数据库三范式
         第一范式（1NF）：字段具有原子性,不可再分。所有关系型数据库系统都满足第一范式）。
         数据库表中的字段都是单一属性的，不可再分。例如，姓名字段，其中的姓和名必须作为一个整体，无法区分哪部分是姓，哪部分是名，如果要区分出姓和名，必须设计成两个独立的字段。
         第二范式（2NF）是在第一范式（1NF）的基础上建立起来的，即满足第二范式（2NF）必须先满足第一范式（1NF）。
         要求数据库表中的每个实例或行必须可以被惟一地区分。通常需要为表加上一个列，以存储各个实例的惟一标识。这个惟一属性列被称为主关键字或主键。
         满足第三范式（3NF）必须先满足第二范式（2NF）。简而言之，第三范式（3NF）要求一个数据库表中不包含已在其它表中已包含的非主关键字信息。
         所以第三范式具有如下特征：
         1，每一列只有一个值
         2，每一行都能区分。
         3，每一个表都不包含其他表已经包含的非主关键字信息。
     8.synchronized：生括来此得
     9.spring 原理
         mybatis原理
         java框架基础原理
         spring boot
         dubbo
         mysql
         linux
     10.高并发下缓存处理
         1.缓存穿透
         概念
         访问一个不存在的key，缓存不起作用，请求会穿透到DB，流量大时DB会挂掉。
         解决方案
         采用布隆过滤器，使用一个足够大的bitmap，用于存储可能访问的key，不存在的key直接被过滤；
         访问key未在DB查询到值，也将空值写进缓存，但可以设置较短过期时间。
         2.缓存雪崩
         概念
         大量的key设置了相同的过期时间，导致在缓存在同一时刻全部失效，造成瞬时DB请求量大、压力骤增，引起雪崩。
         解决方案
         可以给缓存设置过期时间时加上一个随机值时间，使得每个key的过期时间分布开来，不会集中在同一时刻失效。
         3.缓存击穿
         概念
         一个存在的key，在缓存过期的一刻，同时有大量的请求，这些请求都会击穿到DB，造成瞬时DB请求量大、压力骤增。
         解决方案
         在访问key之前，采用SETNX（set if not exists）来设置另一个短期key来锁住当前key的访问，访问结束再删除该短期key。
     11.map常量
         public final static Map map = new HashMap() {{
         put("key1", "value1");
         put("key2", "value2");
         }};
         相当于重载HashMap的一个匿名实现。向原有的HashMap中添加了一个匿名构造方法。
     12.mybatis插入insert返回主键
         <insert id="insertJDImg" parameterType="cn.service.model.VOPImgParaModel">
         <selectKey resultType="java.lang.Integer" order="AFTER" keyProperty="id">
         SELECT LAST_INSERT_ID()
         </selectKey>
         </insert>
     13.反向代理的优势，如下：
         1.隐藏真实后端服务
         2.负载均衡集群
         3.高可用集群
         4.缓存静态内容实现动静分离
         5.安全限流
         6.静态文件压缩
         7.解决多个服务跨域问题
         8.合并静态请求(HTTP/2.0后已经被弱化)
         9.防火墙
         10.SSL以及http2
     14.SpringMVC的流程？
         答：1.用户发送请求至前端控制器DispatcherServlet
         2.DispatcherServlet收到请求调用HandlerMapping处理器映射器。
         3.处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
         4.DispatcherServlet通过HandlerAdapter处理器适配器调用处理器
         5.执行处理器(Controller，也叫后端控制器)。
         6.Controller执行完成返回ModelAndView
         7.HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet
         8.DispatcherServlet将ModelAndView传给ViewReslover视图解析器
         9.ViewReslover解析后返回具体View
         10.DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）。
         11.DispatcherServlet响应用户
     */
}
