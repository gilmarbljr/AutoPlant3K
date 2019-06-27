package autoplant.business.domain;

import java.util.ArrayList;

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
