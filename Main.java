package com.javaLearn;
import java.util.*;
 
class Employee{
	private int id;
	private String name;
	private String designation;
	private String department;
	private double salary;
	private long phno;
	private String address;
	private String email;
//constructor for Employee class
	public Employee(int id, String name, String designation, String department, double salary, long phno, String address, String email) {
	this.id=id;
	this.name=name;
	this.designation=designation;
	this.department=department;
	this.salary=salary;
	this.phno=phno;
	this.address=address;
	this.email=email;
	}
	
//getters and setters for accessing the private variables outside the employee class
	
	//for id field
	public int getid() {
	return id;
	}
	public void setid(int id) {
		this.id=id;
	}
	//for name field
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	//for designation field
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designation) {
		this.designation=designation;
	}
	//for department field
	public String getdepartment() {
		return department;
	}
	public void setdepartment(String department) {
		this.department=department;
	}
	//for salary field
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}
	//for phno field
	public long getphno() {
		return phno;
	}
	public void setphno(long phno) {
		this.phno=phno;
	}
	//for address field
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address=address;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email=email;
	}
	
	//function to display employee details
	public void displayEmployee() {
		System.out.println("ID:"+" "+id);
		System.out.println("Name:"+" "+name);
		System.out.println("Designation:"+" "+designation);
		System.out.println("Department"+" "+department);
		System.out.println("Salary:"+" "+salary);
		System.out.println("PhoneNumber:"+" "+phno);
		System.out.println("Address:"+" "+address);
		System.out.println("Email:"+" "+email);
	}
}
 
//class to perform all functionalities
 
class EmployeeManagementSystem{
	private ArrayList<Employee>employees=new ArrayList<>();
	@SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	
	//method to add employee
	
	public void addEmployee() {
		System.out.println("Enter Your Employee ID:");
		int id=sc.nextInt();
		System.out.println("Enter Your Name:");
		String name=" ";
		name=sc.nextLine();
		name+=sc.nextLine();
		System.out.println("Enter Your Designation:");
		String designation=sc.next();
		System.out.println("Enter Your Department:");
		String department=sc.next();
		System.out.println("Enter Your Salary:");
		double salary=sc.nextDouble();
		System.out.println("Enter Your Phone number");
		long phno=sc.nextInt();
		System.out.println("Enter Your address:");
		String address=sc.next();
		System.out.println("Enter Your Email:");
		String email=sc.next();
		
		Employee emp=new Employee(id,name,designation,department,salary,phno,address,email);
		employees.add(emp);
		System.out.println("Employee added successfully");
		
		ShowMenu();//method to redirect user back to main menu
	}
	
	//method to view employee
	
	public void viewEmployee() {
		if(employees.isEmpty()) {
			System.out.println("No Employees to display");
		}else {
			for(Employee employee:employees) {
				employee.displayEmployee();
			}
		}
		ShowMenu();
	}
	
	//method to update details 
	
	public void UpdateDetails() {
		System.out.println("Enter Employee id to update details:");
		int id=sc.nextInt();
		sc.nextLine();
		boolean found=false;
		
		for(Employee employee:employees) {
			if(employee.getid()==id) {
				found=true;
				System.out.println("Enter New Employee Name:");
				String name=sc.nextLine();
				System.out.println("Enter New Employee Designation:");
				String designation=sc.nextLine();
				System.out.println("Enter New Employee Department:");
				String department=sc.nextLine();
				System.out.println("Enter New Employee Salary:");
				double salary=sc.nextDouble();
				System.out.println("Enter New Employee Phone number");
				long phno=sc.nextInt();
				System.out.println("Enter New Employee address:");
				String address=sc.next();
				System.out.println("Enter New Employee Email:");
				String email=sc.next();
				
				employee.setname(name);
				employee.setdesignation(designation);
				employee.setdepartment(department);
				employee.setsalary(salary);
				employee.setphno(phno);
				employee.setaddress(address);
				employee.setemail(email);
				
				System.out.println("Employee Details Updated Successfully");
				break;
			}
		}
		if(!found) {
			System.out.println("Employee with ID"+" "+id+" "+"Not found");
		}
		ShowMenu();
	}
	
	//method to delete employee
	
	public void deleteEmployee() {
		System.out.println("Enter Employee ID to Delete");
		int id=sc.nextInt();
		sc.nextLine();
		boolean found=false;
		for(Employee employee:employees) {
			if(employee.getid()==id) {
				found=true;
				employees.remove(employee);
				System.out.println("Employee Deleted Successfully");
				break;
			}
		}
		if(!found) {
			System.out.println("The ID Does not exist");
		}
		ShowMenu();
	}
	
	//method to sort employee by department
	
	public void SortByDepartment() {
		if(employees.isEmpty()) {
			System.out.println("No Employees To Display");
			return;
		}
		System.out.println("Enter Department Name of Employee to Sort By:");
		String department=sc.nextLine();
		ArrayList<Employee>SameDepartmentEmployee=new ArrayList<>();
		
		for(Employee employee:employees) {
			if(employee.getdepartment().equalsIgnoreCase(department)) {
				SameDepartmentEmployee.add(employee);
			}
		}
		SameDepartmentEmployee.sort(Comparator.comparing(Employee::getname));
		if(SameDepartmentEmployee.isEmpty()) {
			System.out.println("No Employees to display in the entered department"+" "+department);
		}else {
			System.out.println("Employee Present in the given department"+" "+department);
			for(Employee employee:SameDepartmentEmployee) {
				employee.displayEmployee();
			}
		}
		ShowMenu();
	}
	
	
	//menu to perform operations
	
	public void ShowMenu() {
		System.out.println("Enter Your Choice");
		int choice;
		do {
			System.out.println("Welcome To Your Employee Management System Portal::");
			System.out.println("1:Add Employee");
			System.out.println("2: View Employee");
			System.out.println("3: Update Employee");
			System.out.println("4: Delete an Employee");
			System.out.println("5: Sort Employee By Department");
			System.out.println("Enter Your Choice:");
			choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				viewEmployee();
				break;
			case 3:
				UpdateDetails();
				break;
			case 4:
				deleteEmployee();
				break;
			case 5:
				SortByDepartment();
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		while(choice!=4);
	}
}
 
 
 
public class Main {
 
	public static void main(String[] args) {
		EmployeeManagementSystem ems=new EmployeeManagementSystem();
		ems.ShowMenu();
	}
}
 
 
