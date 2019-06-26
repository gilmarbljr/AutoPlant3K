package autoplant.business.domain;

import java.sql.Date;

/**
 *
 * @author gbljunior
 */
public class Employee extends User implements Credentials{
    
    private String username;

    public Employee(String firstName, String lastName, String username, String password, Date birthday) {
        super(firstName, lastName, password, birthday);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
	if (obj == null)
            return false;
	if (getClass() != obj.getClass())
            return false;
	Employee other = (Employee) obj;
            if (username == null) {
		if (other.username != null)
                    return false;
            } else if (!username.equals(other.username))
		return false;
	return true;
    }

    @Override
    public String toString() {
        return getUsername(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
