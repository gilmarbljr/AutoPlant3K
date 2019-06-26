package autoplant.business.domain;

import java.util.LinkedList;

/**
 *
 * @author gbljunior
 */
public class EstabilizadorNutrientes extends Observer{
    
    public static final String NUTRIENT = "Nutrient";
    private LinkedList<Fertilizante> listaFertilizantes;
    
    public void estabilizaSolo(Float deficitN, Float deficitK, Float deficitCa){
        
    }
    
    public void addFertilizante(Fertilizante newFertilizante){
        this.listaFertilizantes.add(newFertilizante);
    }

    @Override
    public void notify(String aspectDeficit, Float deficit) {
        if(aspectDeficit.equals(NUTRIENT)){
            estabilizaSolo(deficit, deficit, deficit);
        }
    }
    
}
