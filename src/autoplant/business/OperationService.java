/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business;

import autoplant.business.domain.UnidadeDeCultivo;
import java.util.Collection;

/**
 *
 * @author gbljunior
 */
public interface OperationService {
    public Collection<UnidadeDeCultivo> getAllUnidadeDeCultivo();
    public UnidadeDeCultivo getUnidadeDeCultivoByID(Integer id);
    public UnidadeDeCultivo insertUnidadeDeCultivo(String nomeCultivo, String nomeSemente, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException; 
    public UnidadeDeCultivo insertUnidadeDeCultivo(Integer id, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException; 
    public void removeUnidadeDeCultivo(UnidadeDeCultivo unidadeDeCultivo);
}
