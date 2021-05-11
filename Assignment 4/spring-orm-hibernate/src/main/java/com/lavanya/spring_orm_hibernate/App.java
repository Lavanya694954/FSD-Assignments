package com.lavanya.spring_orm_hibernate;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.lavanya.spring_orm_hibernate.dao.EmployeeDao;
import com.lavanya.spring_orm_hibernate.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
         EmployeeDao dao = context.getBean("employeeDao", EmployeeDao.class);
         
         Employee newEmployee = new Employee();
         
         int option1 = 6;
         int option = 0;
         
         do {
        	System.out.println("===========================================================");
        	System.out.println("press 1: Insert Employee");
        	System.out.println("press 2: Update Employee");
        	System.out.println("press 3: Delete Employee");
        	System.out.println("press 4: Get All Employee");
        	System.out.println("press 5: Get Employee By Id ");
        	System.out.println("press 6: For Terminate this loop");
        	System.out.println("===========================================================");
        	
        	System.out.println("Please select any one options");
        	
        	Scanner scanner = new Scanner(System .in);
        	option = scanner.nextInt();
        	
        	switch(option) {
        	case 1:{
        		newEmployee.setId(2);
        		newEmployee.setName("stefan");
        		newEmployee.setEmail("s@gmail.com");
        		int result = dao.addEmployee(newEmployee);
        		System.out.println("("+result+") rows inserted...");
        		
        		break;
        		
        	}
        	
        	case 2:{
        		newEmployee.setId(2);
        		newEmployee.setName("kashyap");
        		newEmployee.setEmail("k@gmail.com");
        	    int  result = (int) dao.updateEmployee(newEmployee);
        		System.out.println("("+result+") Employee Updated...");
       
        		break;
        	}
        	
        	case 3:{
        		dao.deleteEmployee(2);
        		System.out.println("rows deleted");
        	
        		break;
        	}
        	
        	case 4:{
        		List<Employee> list = dao.getAllEmployees();
        		for(Employee employee : list) {
        			System.out.println(list);
        		}
        		break;
        	}
        	case 5:{
    			System.out.println("Enter Employee id..");
    			int id = scanner.nextInt();
    			Employee emp1 = dao.getEmployeeById(id);
    			System.out.println(emp1);
    			break;
        	}
        	
        	case 6:{
        		break;
        	}
        	default:{
    			System.out.println("Incorrect options");
        	}
        	}
         } while(option != 6);
         
    }
       
        	
        	
        	
     
         
        
         		
         
        		
        
        
}
