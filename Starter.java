package pack1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Starter {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDao dao=new EmployeeDao();
		Scanner sc=new Scanner(System.in);

	
		System.out.println("enter choice");
		int c = sc.nextInt();
		switch(c){
		case 1:
		System.out.println("------Enter Employee Details-------");
		
		System.out.println("Enter employee id: ");
		Integer empId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name: ");
		String empName=sc.next();
		System.out.println("Enter employee city: ");
		String empCity=sc.next();
		sc.nextLine();
		System.out.println("Enter employee salary: ");
		Integer empSalary=sc.nextInt();
		
		
		Employee emp=new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpCity(empCity);
		emp.setEmpSalary(empSalary);
		int rows=dao.addEmployee(emp);
		
		System.out.println(rows +" Row Insert Succesfully");
		break;
		
		case 2 :
			
		List<Employee> elist=dao.getEmployees();
		for(Employee e:elist)
		{
			System.out.println();
		}
		break;
		
		case 3:
		System.out.println("Enter employee id: ");
		 empId=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee new salary: ");
		Integer newSalary=sc.nextInt();
		
		rows=dao.updateEmployee(empId, newSalary);
		System.out.println(rows + "Updated successfully");
		break;
		
		case 4:
			System.out.println("Enter employee id: ");
			 empId=sc.nextInt();
			 sc.nextLine();
			 rows=dao.deleteEmployee(empId);
			 System.out.println(rows + "Deleted successfully");
			
	
}
		System.out.println("Program ends");
}}
