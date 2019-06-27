package autoplant.business.domain;

public class EstabilizadorAgua extends Observer{ 
    
    private void ajustaIrrigacao(UnidadeDeCultivo uc){
        Planta planta = uc.getPlanta();
        
        planta.setUmidadeDoSolo(planta.getUmidadeDoSolo()+calculaDefict(uc.getMetaUmidade(), planta.getUmidadeDoSolo()));
        uc.setPlanta(planta);
    }

    @Override
    public void notify(UnidadeDeCultivo uc) {
        if (uc.isChangedDefictWater()) {
        	ajustaIrrigacao(uc);
        }
    }
}
