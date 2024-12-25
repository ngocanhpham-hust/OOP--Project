package shoppingoline.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DBConnectionDTO {

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://192.168.10.62:3306/online_shopping_app", "root", "HiloRS@2022");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không kết nối được hệ thống, kiểm tra lại internet");

            }
            return conn;
        } else {
            return conn;
        }
    }
}
