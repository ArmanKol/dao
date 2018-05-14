package src.p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class OracleBaseDao {

    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER = "mok_1";
    private static final String DB_PASS = "Greg1405@";

    protected static Connection connection;

    protected Connection  getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    }
}
