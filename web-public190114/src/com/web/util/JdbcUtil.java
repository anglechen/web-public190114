package com.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.model.User;

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
//			sql:  select * from user where account = ? and name = ?
//			PreparedStatement preStatement = conn.prepareStatement(sql);
//			preStatement.setString(1, "admin");
//			preStatement.setString(2, "test");
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
	 * 用来执行手动事务
	 * 演示手动事务，以及回滚
	 * @param sql
	 */
	public static void executeWorks(String sql){
		Connection conn = getConnection();
		Statement statement = getStatement(conn);
		if(conn ==null || statement ==null) {
			System.out.println("获取连接或者回话信息异常");
			release(statement, conn);
			return;
		}
		System.out.println("要执行的sql为：" + sql);
		try {
			//事务的处理，1，先把连接设置为手动事务
			conn.setAutoCommit(false);
			System.out.println("开始执行事务===========");
//			5.执行sql语句
			statement.execute(sql);
			//模拟一个异常行为
//			int i = 1/0;
			//再次执行sql预计
			statement.execute(sql);
			
			//正常提交
			conn.commit();
			System.out.println("事务已经提交===============");
		} catch (Exception e) {
			e.printStackTrace();
			try {
//				异常回滚
				conn.rollback();
				System.out.println("发生异常，事务已经回滚==========");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			release(statement, conn);
		}

	
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
		System.out.println("要执行的sql为：" + sql);
		try {
//			5.执行sql语句
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(statement, conn);
		}

	}
	
	/**
	 * 把sql查询出来的结果集转换为对应的bean
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public static <T>  List<T>  executeQueryF(String sql,Class<T> clazz) {
		List<Map> lsitMaps = JdbcUtil.executeQuery(sql);
		List<T> results = new ArrayList<>();
		for(Map m : lsitMaps) {
			T tempUser = JSONObject.toJavaObject((JSON)JSON.toJSON(m), clazz);
			results.add(tempUser);
		}
		return results;
	}
	
	/**
	 * 用来执行查询的方法
	 * @param sql
	 */
	public static List<Map> executeQuery(String sql) {
		//用来保存执行sql语句的结果集（多条记录，每条记录就是一个map对象）
		List<Map> results = new ArrayList<>();
		Connection conn = getConnection();
		Statement statement = getStatement(conn);
		if(conn ==null || statement ==null) {
			System.out.println("获取连接或者回话信息异常");
			release(statement, conn);
			return null;
		}
		System.out.println("要执行的sql为：" + sql);
		try {
//			5.执行查询sql语句
			ResultSet resultSet = statement.executeQuery(sql);
			//结果集表的元数据信息
			ResultSetMetaData metaData = resultSet.getMetaData();
			//一行数据一共有多少列（列的总数）
			int count = metaData.getColumnCount();
//			6.处理结果集
			//遍历每一行记录
			while(resultSet.next()) {
//				保存每一条记录的各个字段的内容
				Map<String, Object> lineMap = new HashMap<>();
				//遍历每一列数据，然后把每一列数据添加到lineMap对象
				for(int i = 1; i<= count ; i++) {
					System.out.print(metaData.getColumnLabel(i) +" :" + resultSet.getObject(i) +";");
					lineMap.put(metaData.getColumnLabel(i), resultSet.getObject(i));
				}
				System.out.println();
				//把每一条记录的map对象添加到results结果集中
				results.add(lineMap);
				
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			release(statement, conn);
		}
		return results;
	}
	
	
	public static <T> List<T> executeQuery(String sql,Class<T> clazz) {
		List<Map> results = JdbcUtil.executeQuery(sql);
		List<T> resultsList = new ArrayList<>();
		for(Map m : results) {
			T tempUser = 
					JSONObject.toJavaObject((JSON)JSON.toJSON(m), clazz);
			resultsList.add(tempUser);
		}
		return resultsList;
	}
	
	
	
	
	
	
	
	
	
	
}
