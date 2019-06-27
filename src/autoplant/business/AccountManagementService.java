package autoplant.business;

import autoplant.business.domain.Employee;

public interface AccountManagementService {
    public Employee login (String username, String password) throws BusinessException;
    public Employee insertEmployee(String firstName, String lastName, String password, String birthday, String username) throws BusinessException;
    
}
