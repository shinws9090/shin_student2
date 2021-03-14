package shin_student2.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
	
	public static Connection getConnection() {
		String res = "db.properties";
		Connection con = null;
		try(InputStream in = ClassLoader.getSystemResourceAsStream(res)){
			
			Properties prop = new Properties();
			
			prop.load(in);
			
			con = DriverManager.getConnection(prop.getProperty("url"), prop);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
