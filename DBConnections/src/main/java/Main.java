import Tickets.BuyTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.jar.Attributes;


/**
 * Created by atinkovan on 11/7/2016.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        //OracleJDBC oracleJDBC = new OracleJDBC("jdbc:oracle:thin:@odsoradb02.exigengroup.com:1521:odsoradb02", "atinkovan", "atinkovan");
        //oracleJDBC.getDBConnection();
        //JDBCConnection jdbcConnection = new JDBCConnection("jdbc:oracle:thin:@odsoradb02.exigengroup.com:1521:odsoradb02", "atinkovan", "atinkovan");
        //jdbcConnection.selectTable();

        /*

        http://odseisrnd01.exigengroup.com:8510/ipb-app/

        Database jdbc:oracle:thin:@odseisorcl01.exigengroup.com:1521:odseisorcl01
        user/pwd = odstrunkapp05/odstrunkapp05
        */

        BuyTicket buyTicket = new BuyTicket();
        buyTicket.run();
    }
}