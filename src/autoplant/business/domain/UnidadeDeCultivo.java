package autoplant.business.domain;

import autoplant.business.BusinessException;

/**
 *
 * @author gbljunior
 */
public class UnidadeDeCultivo {
    private final Integer id;
    private String nomeCultivo;
    private Float metaLuminosidade;
    private Float metaPotassio;
    private Float metaCalcio;
    private Float metaNitrogenio;
    private Float metaUmidade;
    private Float metaTamanho;
    private Planta planta;

    public UnidadeDeCultivo(Integer id, String nomeCultivo, Float metaPotassio, Float metaCalcio, Float metaNitrogenio, Float metaUmidade, Float metaLuminosidade, Planta planta) throws BusinessException{
        this.id = id;
        setNomeCultivo(nomeCultivo);
        this.metaLuminosidade = metaLuminosidade;
        this.metaPotassio = metaPotassio;
        this.metaCalcio = metaCalcio;
        this.metaNitrogenio = metaNitrogenio;
        this.metaUmidade = metaUmidade;
        this.metaTamanho = Float.parseFloat("1");
        this.planta = planta;
    }

    public Float getMetaCalcio() {
        return metaCalcio;
    }

    public Float getMetaLuminosidade() {
        return metaLuminosidade;
    }

    public Float getMetaNitrogenio() {
        return metaNitrogenio;
    }

    public Float getMetaPotassio() {
        return metaPotassio;
    }

    public Float getMetaUmidade() {
        return metaUmidade;
    }

    public Float getMetaTamanho() {
        return metaTamanho;
    }

    public Integer getId() {
        return id;
    }

    public Planta getPlanta() {
        return planta;
    }

    public String getNomeCultivo() {
        return nomeCultivo;
    }
    
    public void setMetaLuminosidade(Float metaLuminosidade) {
        this.metaLuminosidade = metaLuminosidade;
    }

    public void setMetaCalcio(Float metaCalcio) {
        this.metaCalcio = metaCalcio;
    }

    public void setMetaPotassio(Float metaPotassio) {
        this.metaPotassio = metaPotassio;
    }

    public void setMetaNitrogenio(Float metaNitrogenio) {
        this.metaNitrogenio = metaNitrogenio;
    }

    public void setMetaUmidade(Float metaUmidade) {
        this.metaUmidade = metaUmidade;
    }

    public void setMetaTamanho(Float metaTamanho) {
        this.metaTamanho = metaTamanho;
    }

    private void setNomeCultivo(String nomeCultivo) throws BusinessException {
        if(nomeCultivo.isEmpty()){
            throw new BusinessException("exception.invalid.nomecultivo");
        }
        this.nomeCultivo = nomeCultivo;
    }
    
    @Override
    public String toString() {
        return getId() + " - " + getNomeCultivo();
    }
}
