package com.jsp.Jdbc;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.Dao.EmployeeDaoImp;

public class TestEmployee 
{
	public static void main(String[] args) 
	{
		//Create an Ioc Container
		ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeClassConfig.class);
		System.out.println("Class loaded");
		EmployeeDaoImp dao = context.getBean("employeeDaoImp",EmployeeDaoImp.class);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter  for 1 insert Employee record..");
		System.out.println("Enter  for 2 update Employee record..");
		System.out.println("Enter  for 3 delete Employee record..");
		int choice = scan.nextInt();
		switch(choice)
		{
		case 1 :{
			//Call the EmployeeDao
			dao.insertEmployee();
			System.out.println("Recorded inserted..!!");
			break;
		}
		case 2 :{
			//Call the EmployeeDao
			int value = dao.updateEmployeeSal();
			if(value>0)
			{
				System.out.println("Record updated..!!");
			}
			else
			{
				System.err.println("Invalid Employee id");
			}
			break;
		}
		case 3 :{
			int value = dao.deleteEmployeeid();
			if(value>0)
			{
				System.out.println("Record deleted");
			}
			else
			{
				System.err.println("Invalid Employee id..!!");
			}
			break;
		}
		} 
	} 
	}
