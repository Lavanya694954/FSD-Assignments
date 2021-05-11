package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static Statement statement = null;
    private Connection conn;
  

    public EmployeeDAOImpl() throws SQLException {
        conn = ConnectionFactory.getConnection();
        statement = conn.createStatement();
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String sql = "insert into employee values (" + employee.getEmpId() + ",'"+employee.getName() + "','" + employee.getEmail()+"')";
        int count =0;
        count = statement.executeUpdate(sql);

        if ( count > 0){
         System.out.println("Employee saved");
         }else {
         System.out.println("Not completed");
        }
         }

        @Override
        public void updateEmployee (Employee employee) throws SQLException{
            String sql = "update employee set name(" + employee.getEmpId() + ",'"+employee.getName() + "','" + employee.getEmail()+"')";
            int count =0;
            count = statement.executeUpdate(sql);

            if ( count > 0){
                System.out.println("Employee updated");
            }else {
                System.out.println("Not completed");
            }

        }

        @Override
        public void deleteEmployee (int id) throws SQLException{

            String sql = "delete from employee where id = "+ id;
            int count = 0;
            count = statement.executeUpdate(sql);

            if ( count > 0){
                System.out.println("Employee deleted");
            }else {
                System.out.println("Not completed");
            }

        }

        @Override
        public Employee getEmployeeById ( int id) throws  SQLException{

            Employee employee = null;
            String sql = "select * from employee where id = "+ id;
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                int empId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                employee = new Employee(empId, name, email);
            }
            return employee;
        }

        @Override
       public List<Employee> getEmployees() throws SQLException {
            List<Employee> list = new ArrayList<>();
            String sql = " select * from employee";
           ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                int id = rs.getInt("empId");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Employee employee = new Employee(id, name, email);
                list.add(employee);
            }

           return list;
        }
    }



