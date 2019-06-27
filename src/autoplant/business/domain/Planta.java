package autoplant.business.domain;

import autoplant.business.BusinessException;

public class Planta {
    
    private final Float ZERO = Float.parseFloat("1");
    private String semente;
    private Float umidadeDoSolo;
    private Float teorPotassio;
    private Float teorNitrogenio;
    private Float teorCalcio;
    private Float nivelLuminosidade;
    private Float tamanho;

    public Planta(String semente) throws BusinessException{
        setSemente(semente);
        this.umidadeDoSolo = ZERO;
        this.teorCalcio = ZERO;
        this.teorPotassio = ZERO;
        this.teorNitrogenio = ZERO;
        this.nivelLuminosidade = ZERO;
        this.tamanho = ZERO;
    }

    public Planta(String semente, Float umidadeDoSolo, Float teorPotassio, Float teorNitrogenio, Float teorCalcio, Float nivelLuminosidade, Float tamanho) {
        this.semente = semente;
        this.umidadeDoSolo = umidadeDoSolo;
        this.teorPotassio = teorPotassio;
        this.teorNitrogenio = teorNitrogenio;
        this.teorCalcio = teorCalcio;
        this.nivelLuminosidade = nivelLuminosidade;
        this.tamanho = tamanho;
    }

    public Float getNivelLuminosidade() {
        return nivelLuminosidade;
    }

    public String getSemente() {
        return semente;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public Float getTeorCalcio() {
        return teorCalcio;
    }

    public Float getTeorNitrogenio() {
        return teorNitrogenio;
    }

    public Float getTeorPotassio() {
        return teorPotassio;
    }

    public Float getUmidadeDoSolo() {
        return umidadeDoSolo;
    }

    private void setSemente(String semente) throws BusinessException{
        if(semente.isEmpty()){
            throw new BusinessException("exception.invalid.semente");
        }
        this.semente = semente;
    }
}
