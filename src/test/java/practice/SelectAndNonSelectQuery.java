package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class SelectAndNonSelectQuery {

	public static void main(String[] args) throws SQLException {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
	Statement stat = conn.createStatement(); 
	/*Scanner sc=new Scanner(System.in);
	System.out.println("give a query you want to execute :");
	String s=sc.nextLine();
	boolean b = stat.execute(s);
	if(b==true)
	{
		ResultSet set = stat.getResultSet();
		while(set.next())
		{
			System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
		}
	}
	else
	{
		int i = stat.getUpdateCount();
		System.out.println("no of row affacted is:"+i);
	}*/
	//int rs=stat.executeUpdate("select * from student");
	//System.out.println(rs);
	//int rs1=stat.executeUpdate("create table emp(id int(10) not null,ename varchar(20))");
	//while(true)
	//{
	int rs1=stat.executeUpdate("insert into emp values(3,'ram')");
	//}
//int rs1=stat.executeUpdate("delete from student where id=4");
	//int rs1=stat.executeUpdate("insert into student values(8,'krishna','singh','usa')");
	ResultSet rs = stat.executeQuery("select * from emp");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
	}
	}

}
