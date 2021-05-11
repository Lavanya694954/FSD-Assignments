package com.jdbc;

import java.sql.SQLException;

public class EmployeeDAOFactory {

    private static EmployeeDAO dao;

    public static EmployeeDAO getEmployeeDAO() throws SQLException {
        if(dao==null){
            dao = new EmployeeDAOImpl();
        }
        return dao;
    }
}
