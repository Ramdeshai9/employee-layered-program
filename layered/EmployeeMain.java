package layered;
import java.util.*;
public class EmployeeMain {
	
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int choice=0,select=0;
			Scanner scan= new Scanner(System.in);
			
			     do{
			    	 System.out.println("1.Create an Employee \n2.Display all Employees \n3.Display employees by Designation \n4.Raise the salaries of all Employees \n5.Raise salary by ID \n6.Delete employee by ID \n7.Exit \nEnter your choice");
			       choice=scan.nextInt();
			       if(choice==7) break;
			       switch(choice){
			       case 1: do { System.out.println("You would like to create \n1.Manager \n2.Clerk \n3.Programmer \n4.Quit");
			               select=scan.nextInt();
			              if(select==4) break;
			              System.out.println("Enter name");
			              String name=scan.next();
			              System.out.println("Enter age");
			              int age=scan.nextInt();
			              switch(select) {
			              case 1 :   Employee m=new Manager(name,age);
			                         m.create();
			                         break;
			              case 2:    Employee c= new Clerk(name,age);
			                         c.create();
			                         break;
			              case 3 :   Employee p= new Programmer(name,age);
			                         p.create();
			                         break;
			              default:   System.out.println("Invalid selection!");
			              }
			            }while(select!=4);
			             break;
			     case 2:     new EmployeeJdbcConnection().display();
			                  break;
			     case 3:     new EmployeeJdbcConnection().displayByDesignation();
			    	         break;
			     case 4:    (new Clerk()).raiseSalary();
			                 System.out.println("Salaries Raised\n");
			                  break;
			     case 5:    new EmployeeJdbcConnection().raiseById();
			                System.out.println("Salary raised..!");
			                 break;
			     case 6:    new EmployeeJdbcConnection().deleteEmployee();
			          
			                System.out.println("Employee details Deleted permanently");
			                break;
			      default: System.out.println("Invalid Choice!");
			     }                    
		   }while(choice!=7);
		
	  }

	}


