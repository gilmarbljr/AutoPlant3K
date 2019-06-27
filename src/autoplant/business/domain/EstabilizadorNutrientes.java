package autoplant.business.domain;

import java.util.LinkedList;

public class EstabilizadorNutrientes extends Observer{
    
    private void estabilizaCalcio(UnidadeDeCultivo uc) {
    	Planta planta = uc.getPlanta();
    	planta.setTeorCalcio(planta.getTeorCalcio()+calculaDefict(uc.getMetaCalcio(), planta.getTeorCalcio()));
    	uc.setPlanta(planta);
    }
    
    private void estabilizaPotassio(UnidadeDeCultivo uc) {
    	Planta planta = uc.getPlanta();
    	planta.setTeorPotassio(planta.getTeorPotassio()+calculaDefict(uc.getMetaPotassio(), planta.getTeorPotassio()));
    	uc.setPlanta(planta);
    }
    
    public void estabilizaNitrogenio(UnidadeDeCultivo uc) {
    	Planta planta = uc.getPlanta();
    	planta.setTeorNitrogenio(planta.getTeorNitrogenio()+calculaDefict(uc.getMetaNitrogenio(), planta.getTeorNitrogenio()));
    	uc.setPlanta(planta);
    }

    @Override
    public void notify(UnidadeDeCultivo uc) {
        if(uc.isChangedDefictNutrient()) {
        	estabilizaCalcio(uc);
        	estabilizaNitrogenio(uc);
        	estabilizaPotassio(uc);
        }
    }
    
}
