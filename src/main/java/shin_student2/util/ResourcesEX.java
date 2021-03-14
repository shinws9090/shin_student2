package shin_student2.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ResourcesEX {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("url", "jdbc:mysql://localhost:3306/student2?useSSL=false");
		prop.setProperty("user", "user_student2");
		prop.setProperty("password", "rootroot");
		
		try {
			prop.store(new FileWriter("db.properties"), "자바연결");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
