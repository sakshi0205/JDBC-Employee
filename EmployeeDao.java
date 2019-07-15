package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDao {
	Connection con=null;
	int rows=0;
	
	public Integer addEmployee(Employee e) throws SQLException, ClassNotFoundException
	{
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
			String sql="insert into employees values("+e.getEmpId()+",'"+e.getEmpName()+"',"+e.getEmpSalary()+",'"+e.getEmpCity()+"');";
			rows=s.executeUpdate(sql);
		}
		catch(SQLException e1)
		{
			throw e1;
		}
		finally
		{
			if(con!=null)
				try{
					con.close();
				}
			catch(SQLException e2)
			{
				
			}
		}
		return rows;
	}
	
	public List<Employee> getEmployees() throws ClassNotFoundException, SQLException
	{
		List<Employee>empList=new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("Select empId,empName,empSalary,empCity from  employees");
		
			while(rs.next())
			{
				int empId=rs.getInt("empId");
				String empName=rs.getString("empName");
				int empSalary=rs.getInt("empSalary");
				String empCity=rs.getString("empCity");
				
				Employee e=new Employee();
				e.setEmpId(empId);
				e.setEmpName(empName);
				e.setEmpSalary(empSalary);
				e.setEmpCity(empCity);
				
				
				System.out.println("empName "+rs.getString("EmpName"));
				System.out.println("empCity "+rs.getString("empCity"));
				System.out.println("empSalary "+rs.getInt("empSalary"));
				System.out.println("empId "+rs.getInt("empId"));
				System.out.println();
				
			}}
			catch(SQLException e3)
			{
				throw e3;
			}
			finally
			{
				if(con!=null)
					try{
						con.close();
					}
				catch(SQLException e2)
				{
					
				}
			}
			return empList;
		}
	
	
	public Integer updateEmployee(Integer empId,Integer newSalary) throws ClassNotFoundException, SQLException
	
	{
		int rows=0;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
			
		    rows=s.executeUpdate("Update employees set empSalary =empSalary+ "+newSalary+" where empId ="+empId);
			
	}
		catch(SQLException e3)
		{
			throw e3;
		}
		finally
		{
			if(con!=null)
				try{
					con.close();
				}
			catch(SQLException e2)
			{
				
			}
		}
		return rows;
		
	}

	
	public Integer deleteEmployee(Integer empId) throws ClassNotFoundException, SQLException
	{
		int rows=0;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			System.out.println("load driver");
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demodb","root","root");
			System.out.println("establish connection");
			
			Statement s=con.createStatement();
			
		    rows=s.executeUpdate("Delete from employees where empId ="+empId);
			
	}
		catch(SQLException e3)
		{
			throw e3;
		}
		finally
		{
			if(con!=null)
				try{
					con.close();
				}
			catch(SQLException e2)
			{
				
			}
		}
		return rows;
		
	}
	}

