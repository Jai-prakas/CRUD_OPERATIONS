package com.jsp.Dao;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jsp.entity.Employee;

public class EmployeeDaoImp implements EmployeeDao {

	private JdbcTemplate template;
	Scanner scan = new Scanner(System.in);

	public void setTemplate(JdbcTemplate template) {

		this.template = template;
	}

	public int insertEmployee() {
		String query = "insert into tejm36.employee values(?,?,?,?)";
		// Create an Employee Object
		Employee emp = new Employee();
		// Intialize the values to the Object by reading from Scanner Class and setter
		// methods
		System.out.println("Enter the Employee id : ");
		int id = scan.nextInt();
		System.out.println("Enter the Employee name : ");
		String name = scan.next();
		System.out.println("Enter the Employee sal : ");
		double sal = scan.nextDouble();
		System.out.println("Enter the Deptno : ");
		int deptno = scan.nextInt();
		emp.setEid(id);
		emp.setEname(name);
		emp.setSal(sal);
		emp.setDeptno(deptno);

		int res = template.update(query, emp.getEid(), emp.getEname(), emp.getSal(), emp.getDeptno());
		return res;

	}

	public int updateEmployeeSal() {
		String query = "update tejm36.employee set sal=? where eid=?";
		System.out.println("Enter the employee id : ");
		int id = scan.nextInt();
		System.out.println("Enter the EMployee salary");
		double sal = scan.nextDouble();
		int res = template.update(query,sal,id);
		return res;
	}

	public int deleteEmployeeid() 
	{
		String query = "delete from tejm36.employee where eid=?";
		System.out.println("Enter the employee id : ");
		int id = scan.nextInt();
		int res = template.update(query, id);
		return res;
	}

}
