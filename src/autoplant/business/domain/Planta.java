/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.domain;

import autoplant.business.BusinessException;

/**
 *
 * @author gbljunior
 */
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
