package layered;

import java.sql.*;
public class Services {
	
		Services(){
			
		}
		Services(Connection con, Statement st){
			try{st.executeUpdate("update employee set salary=salary+(salary/10)");
		}catch(Exception e) {}
	  }
		public void display(Connection con, Statement st) {
			try {
				ResultSet rs=st.executeQuery("Select * from employee;");
				while(rs.next()) {
					 System.out.println("-----------------------------------------------------------------------------------------");
	           	  System.out.println("    EmpId : "+rs.getInt(1)+" | Name : "+rs.getString(2)+" | Age : "+rs.getInt("age")+" | Designation : "+rs.getString("designation")+" | Salary :"+rs.getInt("salary"));
	           	  System.out.println("-----------------------------------------------------------------------------------------");
				}
			}catch(Exception e) {}
		}
		public void displayByDesignation(Connection con, Statement st, int desig) {
			String job=null;
		        if(desig==1) job="Manager";
		        if(desig==2) job="Programmer";
		        if(desig==3) job="Clerk";
		       try { ResultSet rs=st.executeQuery("select * from employee where designation = '"+job+"'");
		       while(rs.next()) {
					 System.out.println("-----------------------------------------------------------------------------------------");
	         	  System.out.println("    EmpId : "+rs.getInt(1)+" | Name : "+rs.getString(2)+" | Age : "+rs.getInt("age")+" | Designation : "+rs.getString("designation")+" | Salary :"+rs.getInt("salary"));
	         	  System.out.println("-----------------------------------------------------------------------------------------");
				}
		}catch(Exception e ) {}
		}
		public void raiseByID(int id, Statement st, Connection con) {
			    try {
			    	st.executeUpdate("update employee set salary=salary+(salary/10) where id="+id);
			    }catch(Exception e) {}
			
		}
		public void deleteById(Statement st, Connection con, int id) {
		       try {
		    	   st.executeUpdate("delete from employee where id="+id);
		       }catch(Exception e) {}
			
		}
		
	}


