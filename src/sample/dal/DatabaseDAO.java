package sample.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;


public class DatabaseDAO {

    //Datasource from the SQL server libary
    private SQLServerDataSource dataSource;

    /**
     * Values to getting access to the server database
     */
    public DatabaseDAO() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.31");
        dataSource.setDatabaseName("MyTunesAssignment");
        dataSource.setUser("CSe20A_18");
        dataSource.setPassword("CSe20A_18");
        dataSource.setPortNumber(1433);
    }

    //Using the getConnection function to create connection to the database
    public Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

    //Test method to test if there is a connection to the database
    public static void main(String[] args) throws SQLException {

        DatabaseDAO databaseConnector = new DatabaseDAO();
        Connection connection = databaseConnector.getConnection();

        System.out.println("Is it open? " + !connection.isClosed());
        connection.close();
    }
}
