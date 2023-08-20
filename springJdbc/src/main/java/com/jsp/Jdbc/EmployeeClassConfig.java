package com.jsp.Jdbc;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmployeeDaoImp;
@Configurable
public class EmployeeClassConfig 
{
	@Bean
	public DriverManagerDataSource getDriverManagerDataSourceObject()
	{
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306");
		dm.setUsername("root");
		dm.setPassword("12345");
		return dm;
		
	}
	@Bean
	public JdbcTemplate getJdbcTemplateObject()
	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDriverManagerDataSourceObject());
		return template;
	}
	@Bean("employeeDaoImp")
	public EmployeeDao getEmployeeDaoObject()
	{
		EmployeeDaoImp dao = new EmployeeDaoImp();
		dao.setTemplate(getJdbcTemplateObject());
		return dao;
		
	}
	
}
