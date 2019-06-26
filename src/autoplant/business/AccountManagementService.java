package autoplant.business;

import autoplant.business.domain.Employee;

/**
 *
 * @author gbljunior
 */
public interface AccountManagementService {
    public Employee login (String username, String password) throws BusinessException;
    
}
