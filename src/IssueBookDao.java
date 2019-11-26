import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class IssueBookDao {
	
public static boolean checkBook(String bookcallno){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from books where callno=?");
		ps.setString(1,bookcallno);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int save(String bookcallno, int studentid){
	int status=0;
	long studentcontact=0; 
	String studentname=null;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(bookcallno);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ns=con.prepareStatement("select studentname,studentcontact from student where studentid=?");
		ns.setInt(1, studentid);
		ResultSet rs=ns.executeQuery();
		if(rs.next()){
			studentname=rs.getString("studentname");
			studentcontact=rs.getLong("studentcontact");
		}
		PreparedStatement ps=con.prepareStatement("insert into issuebooks(bookcallno,studentid,studentname,studentcontact) values(?,?,?,?)");
		ps.setString(1,bookcallno);
		ps.setInt(2, studentid);
		ps.setString(3, studentname);
		ps.setLong(4, studentcontact);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int updatebook(String bookcallno){
	int status=0;
	int quantity=0,issued=0;
	try{
		Connection con=DB.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
		ps.setString(1,bookcallno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,bookcallno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}