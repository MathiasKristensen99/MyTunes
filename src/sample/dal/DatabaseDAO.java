package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseDAO {

    private SQLServerDataSource dataSource;

    public DatabaseDAO() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("MyTunesAssignment");
        dataSource.setUser("CSe20A_18");
        dataSource.setPassword("CSe20A_18");
        dataSource.setPortNumber(1433);
    }

    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {

        DatabaseDAO databaseConnector = new DatabaseDAO();
        Connection connection = databaseConnector.getConnection();

        System.out.println("Is it open? " + !connection.isClosed());
        connection.close();
    }
}
