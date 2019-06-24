/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.impl;

import autoplant.business.AccountManagementService;
import autoplant.business.BusinessException;
import autoplant.business.domain.Employee;
import autoplant.data.Database;

/**
 *
 * @author gbljunior
 */
public class AccountManagementServiceImpl implements AccountManagementService{
    
    private final Database database;

    public AccountManagementServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public Employee login(String username, String password) throws BusinessException {
        Employee employee = database.getEmployee(username);
        
        if (employee == null){
            throw new BusinessException("exception.inexistent.employee");
        }
        if (!employee.getPassword().equals(password)){
            throw new BusinessException("exception.invalid.password");
        }
        
        return employee;
    }
    
}
