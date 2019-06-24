/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.domain;

/**
 *
 * @author gbljunior
 */
public class OperationLocation {
    private Long number;
    private String name;

    public OperationLocation(long number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getNumber() {
        return number;
    }
    
    

    @Override
    public String toString() {
        return getName();
    }
    
    
    
    
}
