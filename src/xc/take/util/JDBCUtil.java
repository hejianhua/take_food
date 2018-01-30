package xc.take.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	//要链接的url
	private static String url="jdbc:mysql://localhost:3306/take_food";
	//用户
	private static String username="root";
	
	private static String password="root";
	
	//加载驱动
	public  static Connection getConnection(){
		
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			return connection;	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
			
	}
	
	
	public  static void closeConnection(Connection con ,Statement sta, ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(sta!=null){
				sta.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
