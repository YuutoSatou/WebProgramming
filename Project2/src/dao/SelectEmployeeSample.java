package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmployeeSample {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            // データベースへ接続
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=utf8", "root", "password");

            // SELECT文を準備
            String sql = "SELECT id, name, age FROM employee";

            // SELECTを実行し、結果表（ResultSet）を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を表示
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                // 取得したデータを出力
                System.out.println("ID:" + id);
                System.out.println("名前:" + name);
                System.out.println("年齢:" + age + "\n");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
