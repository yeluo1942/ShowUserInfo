package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 封装jdbc操作
 * @author yeluo1942
 *
 */
public class JDBCUtil {
	private static DataSource ds;
	static {
		try {
			//加载配置文件
			Properties pro = new Properties();
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties"));
			//获取druid连接池
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static DataSource getDataSource() {
		return ds;
	}
	
	//关闭并返还连接
	public static void  close(PreparedStatement ps, Connection con) {
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







