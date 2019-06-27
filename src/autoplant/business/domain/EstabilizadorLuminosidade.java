package autoplant.business.domain;

public class EstabilizadorLuminosidade extends Observer{

    @Override
    public void notify(UnidadeDeCultivo uc) {
        if(uc.isChangedDefictLuminosidade()) {
        	ajustaLuminosidade(uc);
        }
    }
    
    public void ajustaLuminosidade(UnidadeDeCultivo uc){
        Planta planta = uc.getPlanta();
        planta.setNivelLuminosidade(calculaDefict(uc.getMetaLuminosidade(), planta.getNivelLuminosidade()));
        uc.setPlanta(planta);
    }
    
}
