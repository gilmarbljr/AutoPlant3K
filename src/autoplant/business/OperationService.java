package autoplant.business;

import autoplant.business.domain.UnidadeDeCultivo;
import java.util.List;

public interface OperationService {
    public List<UnidadeDeCultivo> getAllUnidadeDeCultivo() throws BusinessException;
    public UnidadeDeCultivo getUnidadeDeCultivoByID(Integer id) throws BusinessException;
    public UnidadeDeCultivo insertUnidadeDeCultivo(String nomeCultivo, String nomeSemente, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException; 
    public UnidadeDeCultivo insertUnidadeDeCultivo(Integer id, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException; 
    public void removeUnidadeDeCultivo(UnidadeDeCultivo unidadeDeCultivo) throws BusinessException;
}
