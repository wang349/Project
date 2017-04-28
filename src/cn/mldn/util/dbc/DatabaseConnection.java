package cn.mldn.util.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String DBURL="jdbc:oracle:thin:@localhost:1521:mldn";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
	private static ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
	public static Connection getConnection(){
		 Connection conn=threadLocal.get();
		
		if(conn==null){
			conn=rebuildConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	private  static Connection rebuildConnection(){
		try{
			Class.forName(DBDRIVER);
			return DriverManager.getConnection(DBURL,USER,PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	public static void close(){
		Connection conn=threadLocal.get();
		if(conn!=null){
			try{
				conn.close();
				threadLocal.remove();
			}catch (Exception e) {
				e.printStackTrace();
			}
		
				// TODO: handle exception
			}
		}
		

}
