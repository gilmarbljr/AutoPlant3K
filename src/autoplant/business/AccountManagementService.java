/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business;

import autoplant.business.domain.Employee;

/**
 *
 * @author gbljunior
 */
public interface AccountManagementService {
    public Employee login (String username, String password) throws BusinessException;
    
}
