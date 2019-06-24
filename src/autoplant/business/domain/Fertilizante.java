/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.domain;

/**
 *
 * @author gbljunior
 */
public class Fertilizante {
    private String nome;
    private float concentracaoNitrogenio;
    private float concentracaoPotassio;
    private float concentracaoCalcio;

    public float getConcentracaoCalcio() {
        return concentracaoCalcio;
    }

    public float getConcentracaoNitrogenio() {
        return concentracaoNitrogenio;
    }

    public float getConcentracaoPotassio() {
        return concentracaoPotassio;
    }

    public String getNome() {
        return nome;
    }
}
