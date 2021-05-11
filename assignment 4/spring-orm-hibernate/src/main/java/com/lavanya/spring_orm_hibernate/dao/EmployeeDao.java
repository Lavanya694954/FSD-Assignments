package com.lavanya.spring_orm_hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lavanya.spring_orm_hibernate.entities.Employee;



public class EmployeeDao {
	
private HibernateTemplate hibernateTemplate;
	
	// insert employee
	@Transactional
	public int addEmployee(Employee employee) {
		Integer rows = (Integer)hibernateTemplate.save(employee);
		return rows;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = hibernateTemplate.loadAll(Employee.class);
		return employees;
		}
	
	public Employee getEmployeeById(int id) {
		Employee employee = hibernateTemplate.get(Employee.class, id);
		return employee;
	}
	
	@Transactional
	public int updateEmployee(Employee employee) {
		String query = " update employee set name=?,email=? where id=?";
		hibernateTemplate.update(query, employee);
		return 1;
	}
	
	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = hibernateTemplate.get(Employee.class,id);
		hibernateTemplate.delete(employee);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	

}
