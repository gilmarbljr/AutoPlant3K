/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoplant.business.impl;

import autoplant.business.BusinessException;
import autoplant.business.OperationService;
import autoplant.business.domain.UnidadeDeCultivo;
import autoplant.data.Database;
import java.util.Collection;

/**
 *
 * @author gbljunior
 */
public class OperationServiceImpl implements OperationService{
    
    private final Database database;

    public OperationServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public Collection<UnidadeDeCultivo> getAllUnidadeDeCultivo() {
        return database.getAllUnidadeDeCultivos();
    }

    @Override
    public UnidadeDeCultivo getUnidadeDeCultivoByID(Integer id) {
        return database.getUnidadeDeCultivo(id);
    }

    @Override
    public UnidadeDeCultivo insertUnidadeDeCultivo(String nomeCultivo, String nomeSemente, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException{
        UnidadeDeCultivo uc = null;
        Float calcio = Float.parseFloat(metaCalcio);
        Float potassio = Float.parseFloat(metaPotassio);
        Float nitrogenio = Float.parseFloat(metaNitrogenio);
        Float umidade = Float.parseFloat(metaUmidade);
        Float luminosidade = Float.parseFloat(metaLuminosidade);
        uc = new UnidadeDeCultivo(database.getNextUCId(), nomeCultivo, nomeSemente, potassio, calcio, nitrogenio, umidade, luminosidade);
        database.save(uc);
        return uc;
    }

    @Override
    public UnidadeDeCultivo insertUnidadeDeCultivo(Integer id, String metaPotassio, String metaCalcio, String metaNitrogenio, String metaUmidade, String metaLuminosidade) throws BusinessException {
        UnidadeDeCultivo uc = database.getUnidadeDeCultivo(id);
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
        database.save(uc);
        return uc;
    }
    
    @Override
    public void removeUnidadeDeCultivo(UnidadeDeCultivo unidadeDeCultivo) {
        database.remove(unidadeDeCultivo);
    }
}
