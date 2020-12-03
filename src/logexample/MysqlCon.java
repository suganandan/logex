package logexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

class MysqlCon {
	final static Logger logger = Logger.getLogger(MysqlCon.class);
	public static void main(String args[]) {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy");
			//int i=10/0;
			//Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/log", "root", "admin");
			Connection con = DriverManager.getConnection("jdbc:log4jdbc:mysql://localhost:3306/log", "root", "admin");
			String sql="select * from employee  ";
			PreparedStatement stmt = con.prepareStatement(sql);
			//stmt.setString(1, "sugan" );
			ResultSet rs = stmt.executeQuery(); 
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
			con.close();
		} catch (Exception exception) {
			logger.error("Exception "+exception);
		}
	}
}