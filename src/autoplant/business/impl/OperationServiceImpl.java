package autoplant.business.impl;

import autoplant.business.BusinessException;
import autoplant.business.OperationService;
import autoplant.business.domain.Planta;
import autoplant.business.domain.UnidadeDeCultivo;
import autoplant.data.JDBCUtil;
import java.util.List;

/**
 *
 * @author gbljunior
 */
public class OperationServiceImpl implements OperationService{

    @Override
    public List<UnidadeDeCultivo> getAllUnidadeDeCultivo() throws BusinessException{
        return JDBCUtil.getUnidadeCultivoDAO().lista();
    }

    @Override
    public UnidadeDeCultivo getUnidadeDeCultivoByID(Integer id)throws BusinessException{
        return JDBCUtil.getUnidadeCultivoDAO().getUnidadeDeCultivo(id);
    }

    @Override
    public UnidadeDeCultivo insertUnidadeDeCultivo(String nomeCultivo, String nomeSemente, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException{
        UnidadeDeCultivo uc = null;
        Float calcio = Float.parseFloat(metaCalcio);
        Float potassio = Float.parseFloat(metaPotassio);
        Float nitrogenio = Float.parseFloat(metaNitrogenio);
        Float umidade = Float.parseFloat(metaUmidade);
        Float luminosidade = Float.parseFloat(metaLuminosidade);
        Planta planta = new Planta(nomeSemente);
        JDBCUtil.getPlantaDAO().salva(planta);
        Integer plantaId = JDBCUtil.getPlantaDAO().getLastPlantaId();
        uc = new UnidadeDeCultivo(plantaId, nomeCultivo, potassio, calcio, nitrogenio, umidade, luminosidade, planta);
        JDBCUtil.getUnidadeCultivoDAO().save(uc, plantaId);
        return uc;
    }

    @Override
    public UnidadeDeCultivo insertUnidadeDeCultivo(Integer id, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException {
        UnidadeDeCultivo uc = JDBCUtil.getUnidadeCultivoDAO().getUnidadeDeCultivo(id);
        Float calcio = Float.parseFloat(metaCalcio);
        Float potassio = Float.parseFloat(metaPotassio);
        Float nitrogenio = Float.parseFloat(metaNitrogenio);
        Float umidade = Float.parseFloat(metaUmidade);
        Float luminosidade = Float.parseFloat(metaLuminosidade);
        uc.setMetaCalcio(calcio);
        uc.setMetaPotassio(potassio);
        uc.setMetaNitrogenio(nitrogenio);
        uc.setMetaUmidade(umidade);
        uc.setMetaLuminosidade(luminosidade);
        JDBCUtil.getUnidadeCultivoDAO().update(uc);
        return uc;
    }
    
    @Override
    public void removeUnidadeDeCultivo(UnidadeDeCultivo unidadeDeCultivo) throws BusinessException{
        JDBCUtil.getUnidadeCultivoDAO().delete(unidadeDeCultivo);
    }
}
