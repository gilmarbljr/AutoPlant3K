package autoplant.business.domain;

import java.util.ArrayList;

/**
 *
 * @author gbljunior
 */
public class EstabilizadorLuminosidade extends Observer{
    public static final String LUMINOSITY = "Luminosity";
    private ArrayList<Float> planoLuminosidade;

    @Override
    public void notify(String aspectDeficit, Float deficit) {
        if(aspectDeficit.equals(LUMINOSITY)){
            ajustaLuminosidade(deficit);
        }
    }
    
    public void ajustaLuminosidade(Float deficit){
        
    }
    
}
