package autoplant;

import autoplant.business.AccountManagementService;
import autoplant.business.OperationService;
import autoplant.business.domain.OperationLocation;
import autoplant.business.impl.AccountManagementServiceImpl;
import autoplant.business.impl.OperationServiceImpl;
import autoplant.ui.graphic.AutoPlantGraphicInterface;

/**
 *
 * @author gbljunior
 */
public abstract class AutoPlant {
    public static final String TEXT_FLAG = "-t";

    public static void main(String [] args) throws Exception {
        AutoPlant autoPlant = null;
        
        if (args != null && args.length > 0 && TEXT_FLAG.equals(args[0])){
            autoPlant = null;
        }
        else {
            autoPlant = new AutoPlantGraphic();
        }
        autoPlant.showUI();
    }

    protected AutoPlantGraphicInterface autoPlantInterface;
    protected OperationLocation location;
    
    public AutoPlant() {
         location = new OperationLocation(Long.parseLong("1"), "AutoPlant");
        
        AccountManagementService accountManagementService = new AccountManagementServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        
        autoPlantInterface = createOperationLocationInterface(location,accountManagementService, operationService);
    }
    
    public abstract AutoPlantGraphicInterface createOperationLocationInterface(OperationLocation operationLocation, AccountManagementService accountManagementService, OperationService operationService);
    public abstract void showUI();
    
    
}
