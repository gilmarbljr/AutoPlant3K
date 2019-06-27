package autoplant.data;

import autoplant.business.BusinessException;
import autoplant.business.domain.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmployeeDAO extends JDBC{
    
    public void salva(Employee employee) throws BusinessException{
        String sql = "insert into employee " +
                "(firstName, lastName, birthDay, passwd, username)"+
                " values (?,?,?,?,?)";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setDate(3, employee.getBirthday());
            ps.setString(4, employee.getPassword());
            ps.setString(5, employee.getUsername());
            
            ps.execute();
            
            disconnect();
            
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        } 
    }
    
    public List<Employee> lista() throws BusinessException{
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            setResultSet(ps.executeQuery());
            while (getResultSet().next()) {
                Employee employee = new Employee(
                        getResultSet().getString("firstName"),
                        getResultSet().getString("lastName"),
                        getResultSet().getString("username"),
                        getResultSet().getString("passwd"),
                        getResultSet().getDate("birthDay"));
                employees.add(employee);
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        } 
        return employees;
    }
    
    public Employee getEmployee(String username) throws BusinessException{
        String sql = "select * from employee where username = ?";
        Employee employee = null;
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            ps.setString(1, username);
            setResultSet(ps.executeQuery());
            
            if (getResultSet().next()) {
                 employee = new Employee(
                        getResultSet().getString("firstName"),
                        getResultSet().getString("lastName"),
                        getResultSet().getString("username"),
                        getResultSet().getString("passwd"),
                        getResultSet().getDate("birthDay"));
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        return employee;
    }
}
