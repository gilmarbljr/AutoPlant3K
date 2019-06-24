/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.domain;

import java.util.ArrayList;

/**
 *
 * @author gbljunior
 */
public class EstabilizadorAgua extends Observer{
    public static final String WATER = "Water";
    private ArrayList<Float> planoIrrigacao;
    
    public void ajustaIrrigacao(Float deficit){
        
    }

    @Override
    public void notify(String aspectDeficit, Float deficit) {
        if(aspectDeficit.equals(WATER)){
            ajustaIrrigacao(deficit);
        }
    }
}
