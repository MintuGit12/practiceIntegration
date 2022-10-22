package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class EnterDataToMySqlJDBC {
public static void main(String[] args) throws SQLException
{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		Statement stat = conn.createStatement();
		/*String que="insert into student(first_name,last_name,address)values('vinod','kumar','india')";
		String que1="insert into student(first_name,last_name,address)values('kamlesh','kumar','india')";
		int rs = stat.executeUpdate(que);
		int rs1 = stat.executeUpdate(que1);
if(rs==1&&rs1==1)
	System.out.println("inserted");
else
	System.out.println("not inserted");
String del="delete from student where first_name='kamlesh'";
if(stat.executeUpdate(del)==1)
	System.out.println("deleted");
else
	System.out.println("not deleted");
String que3="alter table student add phno INT NOT NULL";
stat.executeUpdate(que3);
String que4="alter table student drop phno INT NOT NULL";*/
//stat.executeUpdate(que4);
//String que5="RENAME student to student1";
//stat.executeUpdate(que5);
}
}
