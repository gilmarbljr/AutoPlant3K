package autoplant.data;

/**
 *
 * @author gbljunior
 */
public class JDBCUtil {
    private static final JDBCEmployeeDAO EDAO = new JDBCEmployeeDAO();
    private static final JDBCPlantaDAO PDAO = new JDBCPlantaDAO();
    private static final JDBCUnidadeCultivoDAO UCDAO = new JDBCUnidadeCultivoDAO();
    
    public static JDBCEmployeeDAO getEmployeeDAO(){
        return EDAO;
    }
    
    public static JDBCPlantaDAO getPlantaDAO(){
        return PDAO;
    }
    
    public static JDBCUnidadeCultivoDAO getUnidadeCultivoDAO(){
        return UCDAO;
    }

}
