package practice;

//import org.gjt.mm.mysql.Driver;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataFromMySql {

	public static void main(String[] args) throws SQLException {
Driver driver=new Driver();
DriverManager.registerDriver(driver);
Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
Statement stat = conn.createStatement();
String que="SELECT * FROM STUDENT";
ResultSet rs = stat.executeQuery(que);
try
{
while(rs.next())
{
	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
}
}
finally
{
conn.close();
	}
	}
}
