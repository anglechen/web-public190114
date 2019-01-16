package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc操作mysql数据库的工具类
 * @author Administrator
 *
 */
public class JdbcUtil {
	
	private final static String url = "jdbc:mysql://localhost:3306/java-web"
			+ "?useUnicode=true&characterEncoding=UTF-8";
	private final static String userName = "root";
	private final static String password = "123456";
	
	//静态块，类加载的时候执行一次
	static {
//		2.加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取jdbc数据库连接
	 * @return
	 */
	private static Connection  getConnection() {
//		3.根据驱动管理器创建数据库连接
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已经获取到连接：" + conn);
		return conn;
	}
	
	/**
	 * 获取回话信息
	 * @return
	 */
	private static Statement getStatement(Connection conn) {
		Statement statement = null;
		//	4.获取回话信息
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("已经获取回话：" + statement);
		return statement;
	}
	/**
	 * 释放资源
	 * @param statement
	 * @param conn
	 */
	private static void release(Statement statement ,Connection conn) {
		try {
//			7.关闭回话对象
			if(statement !=null) {
				statement.close();
			}
//			8.关闭连接
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("jdbc资源释放成功");
	}
	
	/**
	 * 执行 新增，修改，删除类sql预计
	 * @param sql
	 */
	public static void execute(String sql) {
		Connection conn = getConnection();
		Statement statement = getStatement(conn);
		if(conn ==null || statement ==null) {
			System.out.println("获取连接或者回话信息异常");
			release(statement, conn);
			return;
		}
		try {
//			5.执行sql语句
			statement.execute(sql);
			System.out.println("已经执行完毕sql语句：" + sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(statement, conn);
		}

	}
	
	
	public static void executeQuery(String sql) {
		
	}
}
