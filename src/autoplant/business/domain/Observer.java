package autoplant.business.domain;

public abstract class Observer {
    public abstract void notify(UnidadeDeCultivo uc);
    
    public Float calculaDefict (Float meta, Float teor) {
    	return meta - teor;
    }
}
