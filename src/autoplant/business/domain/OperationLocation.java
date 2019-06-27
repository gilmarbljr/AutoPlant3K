package autoplant.business.domain;

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
