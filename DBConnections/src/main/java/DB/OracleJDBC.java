/**
 * Created by atinkovan on 10/19/2016.
 */

/*
import java.sql.*;


public class OracleJDBC {


    static String connectionAddress;
    static String connectionLogin;
    static String connectionPass;

    public void getDBConnection() {

        System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return ;

        }

        System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionAddress, connectionLogin, connectionPass);

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
        OracleJDBC (String addr, String login, String pass){
        connectionAddress = addr;
        connectionLogin = login;
        connectionPass = pass;
    }
}
*/