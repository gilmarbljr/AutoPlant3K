package autoplant.business.impl;

import autoplant.business.AccountManagementService;
import autoplant.business.BusinessException;
import autoplant.business.domain.Employee;
import autoplant.data.JDBCEmployeeDAO;
import autoplant.data.JDBCUtil;

/**
 *
 * @author gbljunior
 */
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
    
}
