package autoplant.business.impl;

import autoplant.business.AccountManagementService;
import autoplant.business.BusinessException;
import autoplant.business.domain.Employee;
import autoplant.data.JDBCUtil;
import java.sql.Date;

public class AccountManagementServiceImpl implements AccountManagementService{

    @Override
    public Employee login(String username, String password) throws BusinessException {
        Employee employee = JDBCUtil.getEmployeeDAO().getEmployee(username);
        
        if (employee == null){
            throw new BusinessException("exception.inexistent.employee");
        }
        if (!employee.getPassword().equals(password)){
            throw new BusinessException("exception.invalid.password");
        }
        
        return employee;
    }

    @Override
    public Employee insertEmployee(String firstName, String lastName, String password, String birthday, String username) throws BusinessException {
        Employee employee = new Employee(firstName, lastName, username, password, Date.valueOf(birthday));
        JDBCUtil.getEmployeeDAO().salva(employee);
        return employee;
    }
    
}
