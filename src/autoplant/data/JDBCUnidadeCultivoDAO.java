package autoplant.data;

import autoplant.business.BusinessException;
import autoplant.business.domain.Planta;
import autoplant.business.domain.UnidadeDeCultivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gbljunior
 */
public class JDBCUnidadeCultivoDAO extends JDBC{
    
    public void save(UnidadeDeCultivo unidadeDeCultivo, Integer plantaId) throws BusinessException{
        String sql = "insert into unidadeCultivo " +
                "(nomeCultivo, metaPotassio, metaCalcio, metaNitrogenio, metaUmidade, metaLuminosidade, metaTamanho, plantaId)"+
                " values (?,?,?,?,?,?,?,?)";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            
            ps.setString(1, unidadeDeCultivo.getNomeCultivo());
            ps.setFloat(2, unidadeDeCultivo.getMetaPotassio());
            ps.setFloat(3, unidadeDeCultivo.getMetaCalcio());
            ps.setFloat(4, unidadeDeCultivo.getMetaNitrogenio());
            ps.setFloat(5, unidadeDeCultivo.getMetaUmidade());
            ps.setFloat(6, unidadeDeCultivo.getMetaLuminosidade());
            ps.setFloat(7, unidadeDeCultivo.getMetaTamanho());
            ps.setInt(8, plantaId);
            
            ps.execute();
            
            disconnect();
            
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        } 
    }
    
    public List<UnidadeDeCultivo> lista() throws BusinessException{
        List<UnidadeDeCultivo> unidades = new ArrayList<>();
        
        String sql = "select * from unidadeCultivo join planta using (plantaId)";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            setResultSet(ps.executeQuery());
            while (getResultSet().next()) {
                Planta planta = new Planta(getResultSet().getString("semente"),
                        getResultSet().getFloat("umidadeDoSolo"),
                        getResultSet().getFloat("teorPotassio"),
                        getResultSet().getFloat("teorNitrogenio"),
                        getResultSet().getFloat("teorCalcio"),
                        getResultSet().getFloat("nivelLuminosidade"),
                        getResultSet().getFloat("tamanho"));
                UnidadeDeCultivo cultivo = new UnidadeDeCultivo(getResultSet().getInt("id"),
                        getResultSet().getString("nomeCultivo"),
                        getResultSet().getFloat("metaPotassio"),
                        getResultSet().getFloat("metaCalcio"),
                        getResultSet().getFloat("metaNitrogenio"),
                        getResultSet().getFloat("metaUmidade"),
                        getResultSet().getFloat("metaLuminosidade"),
                        planta);
                unidades.add(cultivo);
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        
        return unidades;
    }
    
    public void update(UnidadeDeCultivo unidadeDeCultivo) throws BusinessException{
        String sql = "update unidadeCultivo set "+
                "metaPotassio = ?, "+
                "metaCalcio = ?, "+
                "metaNitrogenio = ?, "+
                "metaUmidade = ?, "+
                "metaLuminosidade = ?, "+
                "metaTamanho = ? "+
                "where id = ?";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            
            ps.setFloat(1, unidadeDeCultivo.getMetaPotassio());
            ps.setFloat(2, unidadeDeCultivo.getMetaCalcio());
            ps.setFloat(3, unidadeDeCultivo.getMetaNitrogenio());
            ps.setFloat(4, unidadeDeCultivo.getMetaUmidade());
            ps.setFloat(5, unidadeDeCultivo.getMetaLuminosidade());
            ps.setFloat(6, unidadeDeCultivo.getMetaTamanho());
            ps.setInt(7, unidadeDeCultivo.getId());
            
            ps.execute();
            
            disconnect();
            
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }
    
    public UnidadeDeCultivo getUnidadeDeCultivo(Integer id) throws BusinessException{
        UnidadeDeCultivo cultivo = null;
        String sql = "select * from unidadeCultivo join planta using (plantaId) where id = ?";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            setResultSet(ps.executeQuery());
            while (getResultSet().next()) {
                Planta planta = new Planta(getResultSet().getString("semente"),
                        getResultSet().getFloat("umidadeDoSolo"),
                        getResultSet().getFloat("teorPotassio"),
                        getResultSet().getFloat("teorNitrogenio"),
                        getResultSet().getFloat("teorCalcio"),
                        getResultSet().getFloat("nivelLuminosidade"),
                        getResultSet().getFloat("tamanho"));
                cultivo = new UnidadeDeCultivo(getResultSet().getInt("id"),
                        getResultSet().getString("nomeCultivo"),
                        getResultSet().getFloat("metaPotassio"),
                        getResultSet().getFloat("metaCalcio"),
                        getResultSet().getFloat("metaNitrogenio"),
                        getResultSet().getFloat("metaUmidade"),
                        getResultSet().getFloat("metaLuminosidade"),
                        planta);
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        
        return cultivo;
    }
    
    public void delete(UnidadeDeCultivo unidadeDeCultivo) throws BusinessException{
        String sql = "delete from unidadeCultivo where id = ?";
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            
            ps.setInt(1, unidadeDeCultivo.getId());
            ps.execute();
            
            disconnect();
            
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }

}
