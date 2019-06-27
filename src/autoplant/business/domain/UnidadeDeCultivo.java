package autoplant.business.domain;

import autoplant.business.BusinessException;

import java.util.ArrayList;
import java.util.List;

public class UnidadeDeCultivo {
    private final Integer id;
    private String nomeCultivo;
    private Float metaLuminosidade;
    private Float metaPotassio;
    private Float metaCalcio;
    private Float metaNitrogenio;
    private Float metaUmidade;
    private Float metaTamanho;
    private Planta planta;
    private List<Observer> observers;

    public UnidadeDeCultivo(Integer id, String nomeCultivo, Float metaPotassio, Float metaCalcio, Float metaNitrogenio, Float metaUmidade, Float metaLuminosidade, Planta planta) throws BusinessException{
        this.id = id;
        setNomeCultivo(nomeCultivo);
        this.metaLuminosidade = metaLuminosidade;
        this.metaPotassio = metaPotassio;
        this.metaCalcio = metaCalcio;
        this.metaNitrogenio = metaNitrogenio;
        this.metaUmidade = metaUmidade;
        this.metaTamanho = Float.parseFloat("1");
        this.planta = planta;
        this.observers = new ArrayList<>();
        registerObservers();
    }

    public Float getMetaCalcio() {
        return metaCalcio;
    }

    public Float getMetaLuminosidade() {
        return metaLuminosidade;
    }

    public Float getMetaNitrogenio() {
        return metaNitrogenio;
    }

    public Float getMetaPotassio() {
        return metaPotassio;
    }

    public Float getMetaUmidade() {
        return metaUmidade;
    }

    public Float getMetaTamanho() {
        return metaTamanho;
    }

    public Integer getId() {
        return id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public String getNomeCultivo() {
        return nomeCultivo;
    }
    
    public void setMetaLuminosidade(Float metaLuminosidade) {
        this.metaLuminosidade = metaLuminosidade;
        notifyObservers();
    }

    public void setMetaCalcio(Float metaCalcio) {
        this.metaCalcio = metaCalcio;
        notifyObservers();
    }

    public void setMetaPotassio(Float metaPotassio) {
        this.metaPotassio = metaPotassio;
        notifyObservers();
    }

    public void setMetaNitrogenio(Float metaNitrogenio) {
        this.metaNitrogenio = metaNitrogenio;
        notifyObservers();
    }

    public void setMetaUmidade(Float metaUmidade) {
        this.metaUmidade = metaUmidade;
        notifyObservers();
    }

    public void setMetaTamanho(Float metaTamanho) {
        this.metaTamanho = metaTamanho;
        notifyObservers();
    }

    private void setNomeCultivo(String nomeCultivo) throws BusinessException {
        if(nomeCultivo.isEmpty()){
            throw new BusinessException("exception.invalid.nomecultivo");
        }
        this.nomeCultivo = nomeCultivo;
    }
    
    public void setPlanta(Planta planta) {
		this.planta = planta;
	}
    
    private void notifyObservers() {
    	for (Observer observer : this.observers) {
    		observer.notify(this);
    	}
    }
    
    private void registerObservers() {
    	EstabilizadorAgua observerAgua = new EstabilizadorAgua();
    	EstabilizadorLuminosidade observerLuz = new EstabilizadorLuminosidade();
    	EstabilizadorNutrientes observerNutrientes = new EstabilizadorNutrientes();
    	this.observers.add(observerAgua);
    	this.observers.add(observerLuz);
    	this.observers.add(observerNutrientes);
    }
    
    public Boolean isChangedDefictWater() {
    	return getPlanta().getUmidadeDoSolo() != metaUmidade;
    }
    
    public Boolean isChangedDefictLuminosidade() {
    	return getPlanta().getNivelLuminosidade() != metaLuminosidade;
    }
    
    public Boolean isChangedDefictNutrient() {
    	return getPlanta().getTeorCalcio() != metaCalcio
    			|| getPlanta().getTeorNitrogenio() != metaNitrogenio
    			|| getPlanta().getTeorPotassio() != metaPotassio;
    }
    
    @Override
    public String toString() {
        return getId() + " - " + getNomeCultivo();
    }
}
