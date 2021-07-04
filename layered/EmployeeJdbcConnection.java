package layered;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;


public class EmployeeJdbcConnection {

		static Scanner scan=new Scanner(System.in);
		Connection con;
		Statement st;
	   EmployeeJdbcConnection(){
		try{ 
		Class.forName("com.mysql.jdbc.Driver"); 
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","system");
	     st=con.createStatement();
		   
	}catch(Exception e) {e.printStackTrace();}
	   }
	   EmployeeJdbcConnection(String n,int a,String job, int sal){
		   this();
		   try{st.executeUpdate("insert into employee(name, age, designation, salary) values('"+n+"',"+a+",'"+job+"',"+sal+");");
	   }catch(Exception e) {e.printStackTrace();}
	}
	   EmployeeJdbcConnection(int sal){
		   this();
		   new Services(con,st);
	   }
	   public void display() {
		   new EmployeeJdbcConnection();
		   new Services().display(con,st);
	   }
	   public void displayByDesignation() {
		  new EmployeeJdbcConnection();
		  System.out.println("Select the Designation \n1.Manager \n2.Programmer \n3.Clerk");
		  int desig=scan.nextInt();
		  new Services().displayByDesignation(con,st,desig);
		  
	   }
	public void raiseById() {
	       new EmployeeJdbcConnection();
	       System.out.println("Enter the ID to raise salary");
	       int id=scan.nextInt();
	       new Services().raiseByID(id,st,con);
		
	}
	public void deleteEmployee() {
		    new EmployeeJdbcConnection();
		    System.out.println("Enter the ID to delete record of Employee");
		    int id= scan.nextInt();
		    new Services().deleteById(st,con,id);
		
	}
	}


