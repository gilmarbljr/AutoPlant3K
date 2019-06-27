package autoplant;

import autoplant.business.AccountManagementService;
import autoplant.business.OperationService;
import autoplant.business.domain.OperationLocation;
import autoplant.ui.graphic.AutoPlantGraphicInterface;

class AutoPlantGraphic extends AutoPlant {

    @Override
    public void showUI() {
            autoPlantInterface.setVisible(true);
    }

    @Override
    public AutoPlantGraphicInterface createOperationLocationInterface(OperationLocation operationLocation, AccountManagementService accountManagementService, OperationService operationService) {
        return new AutoPlantGraphicInterface(operationLocation,accountManagementService,operationService);
    }
    
}
