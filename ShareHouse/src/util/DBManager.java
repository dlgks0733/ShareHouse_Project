package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private static DBManager instance;
	
	public static DBManager getInstance() {
		if(instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	public DBManager() {
		init();
	}
	
	private Connection conn = null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "SHAREHOUSE";
	String pass = "1234";
	
	private void init() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "SHAREHOUSE";
		pass = "1234";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}	catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			init();
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("접속성공");
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void dbClose() {
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
