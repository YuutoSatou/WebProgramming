package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB接続処理全般
 * @author takano
 */
public class DBManager {
    final private static String URL = "jdbc:mysql://localhost/";
    final private static String DB_NAME = "rezodb";
    final private static String USER = "root";
    final private static String PASS = "password";

    /**
     * DBへ接続するコネクションを返す
     */
    public static Connection getConnection() {
        Connection con = null;
        try {		//例外処理の部分(try catch文)
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL+DB_NAME,USER,PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}

