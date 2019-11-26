import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class DB {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new", "root", "toor");
			PreparedStatement ps=con.prepareStatement("select studentname, email, fine from student into outfile 'testing.csv' FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'; ");
			ResultSet rs=ps.executeQuery();
			boolean status = rs.next();
		}catch(Exception e){System.out.println(e);}
		return con;
	
	}

}