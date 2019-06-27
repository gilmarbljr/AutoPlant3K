package autoplant.data;

import autoplant.business.BusinessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JDBC {
    private Connection connection;
    private ResultSet resultSet;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String SERVER = "gbljunior.ddns.net:3306";
    private final String BANCO = "autoplant";
    private final String USER = "autoplant";
    private final String SENHA = "autoplant";
    private final String URL;

    public JDBC() {
        this.URL = "jdbc:mysql://"+SERVER+"/"+BANCO;
    }

    protected Connection openConnection() throws BusinessException {
        System.setProperty("jdbc.Drivers", DRIVER);
        try {
            connection = DriverManager.getConnection(URL, USER, SENHA);
        } catch (SQLException e) {
        	throw new BusinessException("Erro ao conectar com o banco de dados!\n" + e.getMessage());
        }
        return connection;
    }

    protected ResultSet getResultSet() {
        return resultSet;
    }

    protected void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    protected void disconnect() throws BusinessException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new BusinessException("Erro ao encerrar a conexão com o banco de dados\n" + e.getMessage());
        }
    }

}
