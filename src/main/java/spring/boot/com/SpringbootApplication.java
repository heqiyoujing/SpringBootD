package spring.boot.com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import spring.boot.com.util.configure.MybatisMysql;
import spring.boot.com.util.configure.RedisConnPool;
import spring.boot.com.util.configure.RedisConnPoolConfig;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@SpringBootApplication
public class SpringbootApplication {
	public static MybatisMysql mybatisMysqlPool;
	private static String env = "local";
	public static SqlSessionFactory sqlSessionFactory;
	public static RedisConnPoolConfig redisConfig;

	private static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class.getName());

	public static void main(String[] args) {
//		new  SpringbootApplication().init();
		SpringApplication.run(SpringbootApplication.class, args);
	}

	public void init (){
		//初始化数据库-主从数据库
		initMysql();
		//初始化数据库-单个数据库
		initMySql();
		//初始化redis
		loadRedisConfig();
		RedisConnPool.getInstance().init(redisConfig);
	}

	/**
	 * 主从数据库
	 */
	private void initMysql() {
		MybatisMysql mysqlPool = MybatisMysql.getInstance();
		String resource = String.format("mybatis-config-%s.xml", SpringbootApplication.env);
		Reader masterReader = null;
		Reader slaveReader = null;
		try {
			masterReader = Resources.getResourceAsReader(resource);
			slaveReader = Resources.getResourceAsReader(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//设置主库连接池
			mysqlPool.setMasterPool(builder.build(masterReader, "master"));
			List<SqlSessionFactory> slavePoolList = new ArrayList<SqlSessionFactory>();
			slavePoolList.add(builder.build(slaveReader, "slave"));
			//从库连接池
			mysqlPool.setSlavePool(slavePoolList);
			SpringbootApplication.mybatisMysqlPool = mysqlPool;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 单个数据库
	 */
	private void initMySql(){
		try{
			String resource = String.format("mybatis-config-%s.xml", SpringbootApplication.env);
			Reader reader = Resources.getResourceAsReader(resource);
			SpringbootApplication.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//加载redis配置
	private void loadRedisConfig(){
		redisConfig = RedisConnPoolConfig.getInstance();
		redisConfig.setHost("192.168.18.23");
		redisConfig.setPort(6379);
		redisConfig.setPassword("123456");
		redisConfig.setMaxTotal(8);
		redisConfig.setMaxIdle(8);
		redisConfig.setMinIdle(0);
		redisConfig.setMaxWaitMillis(-1);
		redisConfig.setTimeBetweenEvictionRunsMillis(1800000);
		redisConfig.setTimeout(300);
	}


}
