package Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost/hospital_appointment_system";
    private static String USERNAME;
    private static String PASSWORD;

    public static Connection getConnection() throws SQLException, IOException {
        try {
            Properties props = new Properties();
            try(FileInputStream fis = new FileInputStream("resources/config.properties")){
                props.load(fis);
            }
            USERNAME = props.getProperty("username");
            PASSWORD = props.getProperty("password");
            Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Database driver not found");
        }
    }
}
