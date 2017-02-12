/**
 * Created by atinkovan on 11/7/2016.
 *//*

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JDBCConnection {

    static String connectionAddress;
    static String connectionLogin;
    static String connectionPass;

    public static Connection getDBConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("DB_DRIVER");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@odsoradb02.exigengroup.com:1521:odsoradb02", "atinkovan","atinkovan");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }

    private static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE DBUSER("
                + "USER_ID NUMBER(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "CREATED_BY VARCHAR(20) NOT NULL, "
                + "CREATED_DATE DATE NOT NULL, " + "PRIMARY KEY (USER_ID) "
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void main(String[] argv) {
        try {
            selectTable();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertInto() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String insertTableSQL = "INSERT INTO DBUSER"
                + "(USER_ID, USERNAME, CREATED_BY, CREATED_DATE) " + "VALUES"
                + "(1,'mkyong','system', " + "to_date('"
                + getCurrentTimeStamp() + "', 'yyyy/mm/dd hh24:mi:ss'))";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.executeUpdate(insertTableSQL);
            System.out.println("Table \"dbuser\" is updated!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static String getCurrentTimeStamp() {
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        return simpleDateFormat.format(today.getTime());
    }

    private static void selectTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String selectTableSQL = "select ps.id policyId,ps.policyNumber,c.id coverage,c.coverageCd,c.oid covOID,ps.txType,ps.txSubType,ps.oosTxType,tv.oid riskItem,\n" +
                "CONCAT(tax.CODE, fee.CODE) code, \n" +
                "CONCAT(tr.AMOUNT, fr.AMOUNT) amount,\n" +
                "CONCAT(tr.DENOMINATION,fr.DENOMINATION) denomination, \n" +
                "CONCAT(tr.APPLYLEVEL, fr.APPLYLEVEL) applyLevel,pe.premiumCd, pe.periodAmt,pe.premiumAmt,pe.changeAmt,pe.factor\n" +
                "from PremiumEntry pe \n" +
                "left OUTER join Coverage c on pe.Coverage_ID=c.id \n" +
                "LEFT OUTER join RiskItem tv on c.RiskItem_ID=tv.id \n" +
                "LEFT OUTER join PolicyDetail pd on tv.POLICYDETAIL_ID=pd.id \n" +
                "LEFT OUTER join PolicySummary ps on ps.policyDetail_id=pd.id \n" +
                "LEFT JOIN TAXRULE tr on pe.premiumCd = CAST(tr.id AS VARCHAR(20)) \n" +
                "LEFT JOIN FEERULE fr on pe.premiumCd = CAST(fr.id AS VARCHAR(20)) \n" +
                "LEFT JOIN TAX tax ON (tax.id = tr.TAX_ID) \n" +
                "LEFT JOIN FEE fee ON (fee.id = fr.FEE_ID)\n" +
                "where pe.PREMIUMCD not in ('CMR', 'CMS', 'NWT/R', 'RAW') \n" +
                "and \n" +
                "--c.COVERAGECD in ('PP','PL','LAC','MOLD','FRAUD', 'SEWER')and\n" +
                "--c.COVERAGECD not in ('WC', 'LOU') and \n" +
                "--c.COVERAGECD in ('PP', 'SEWER', 'LAC') and \n" +
                "--c.COVERAGECD in ('COMP', 'CSL') and \n" +
                "--c.COVERAGECD in ('UMPD', 'RREIM') and \n" +
                "--c.COVERAGECD in ('CSL', 'UMCSL') and \n" +
                "--c.COVERAGECD in ('ADwellingLimit', 'DFairRentalValue', 'CPersonalProperty') and \n" +
                "--c.COVERAGECD in ('CLTTTCSLCoverage', 'CLTTTUMCSLCoverage', 'CLTTTTLCoverage') and\n" +
                "(ps.policyNumber = 'H0000700527' ) \n" +
                "order by ps.id, c.id,tv.oid,pe.premiumCd asc";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);
            System.out.println(rs);
            while (rs.next()) {
                String periodamt = rs.getString("periodamt");
                String premiumamt = rs.getString("premiumamt");
                String changeamt = rs.getString("changeamt");

                System.out.println(  periodamt + premiumamt + changeamt);
//                System.out.println("periodamt : " + periodamt);
//                System.out.println("premiumamt : " + premiumamt);
//                System.out.println("changeamt : " + changeamt);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String deleteTableSQL = "DELETE DBUSER WHERE USER_ID = 1";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос delete SQL
            statement.execute(deleteTableSQL);
            System.out.println("Record is deleted from DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String updateTableSQL = "UPDATE DBUSER SET USERNAME = 'mkyong_new' WHERE USER_ID = 1";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполняем запрос update SQL
            statement.execute(updateTableSQL);

            System.out.println("Record is updated to DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    JDBCConnection (String addr, String login, String pass) {
        connectionAddress = addr;
        connectionLogin = login;
        connectionPass = pass;
    }
}
*/
