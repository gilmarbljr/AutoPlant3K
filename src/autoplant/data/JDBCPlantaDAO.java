package autoplant.data;

import autoplant.business.BusinessException;
import autoplant.business.domain.Planta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPlantaDAO extends JDBC {
    
    public void salva(Planta planta) throws BusinessException{
        String sql = "insert into planta " +
                "(semente, teorPotassio, teorCalcio, teorNitrogenio, umidadeDoSolo, nivelLuminosidade, tamanho)"+
                " values (?,?,?,?,?,?,?)";
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            
            ps.setString(1, planta.getSemente());
            ps.setString(2, planta.getTeorPotassio().toString());
            ps.setString(3, planta.getTeorCalcio().toString());
            ps.setString(4, planta.getTeorNitrogenio().toString());
            ps.setString(5, planta.getUmidadeDoSolo().toString());
            ps.setString(6, planta.getNivelLuminosidade().toString());
            ps.setString(7, planta.getTamanho().toString());
            
            ps.execute();
            
            disconnect();
            
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
    }
    
    public Planta getPlanta(Integer id) throws BusinessException{
        String sql = "select * from planta where plantaId = ?";
        Planta planta = null;
        
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            setResultSet(ps.executeQuery());
            
            if (getResultSet().next()) {
                 planta = new Planta(
                        getResultSet().getString("semente"),
                        getResultSet().getFloat("teorPotassio"),
                        getResultSet().getFloat("teorCalcio"),
                        getResultSet().getFloat("teorNitrogenio"),
                        getResultSet().getFloat("umidadeDoSolo"),
                        getResultSet().getFloat("nivelLuminosidade"),
                        getResultSet().getFloat("tamanho"));
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        return planta;
    }
    
    public Integer getLastPlantaId() throws BusinessException{
        String sql = "select plantaId from planta order by plantaId desc limit 1";
        Integer n = 0;
        try {
            Connection c = openConnection();
            PreparedStatement ps = null;
            ps = c.prepareStatement(sql);
            setResultSet(ps.executeQuery());
            
            if (getResultSet().next()) {
                 n = getResultSet().getInt("plantaId");
            }
            else {
                throw new BusinessException("exception.planta.empty");
            }
            
            disconnect();
        } catch (SQLException e) {
            throw new BusinessException(e.getMessage());
        }
        return n;
    }

}
