/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business;

/**
 *
 * @author gbljunior
 */
public class BusinessException extends Exception{
    
    public BusinessException(final String message) {
	super(message);
    }
    
    public BusinessException(final String message, final Throwable cause) {
	super(message, cause);
    }
    
    public BusinessException(final Throwable cause) {
	super(cause);
    }
    
}
