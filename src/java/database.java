
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

    public static Connection getConn() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventshala", "root", "");
            System.out.println(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return conn;
    }

    public static ResultSet MyexecuteQuery(Connection conn, String sql) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);
        return resultSet;

    }

    public static int MyexecuteUpdate(Connection conn, String sql) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        int result = stmt.executeUpdate(sql);
        return result;
    }

    public static void CloseConnection(Connection database) throws SQLException {
        database.close();
    }

    public static String md5Map(String input) {

        String Password = null;

        if (null == input) {
            return null;
        }

        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            Password = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
        }
        return Password;
    }

}
