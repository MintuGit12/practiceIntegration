package practice;


import java.util.Date;

public class DateClass {

	public static void main(String[] args) {
    Date d=new Date();
System.out.println(d);
d.toString().replace(" ",",").replace(":", "-");

	}

}
