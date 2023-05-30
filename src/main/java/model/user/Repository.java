package model.user;

import lib.mysql.Client;
import java.sql.*;


public class Repository extends Client{
    public static void signUpUser(User user) {
        Connection connection = null;
        PreparedStatement stmt = null;
        //ResultSet rs = null;

        try {
            //sql文を用意
            String sql = "insert into users(name, pass) values (?, ?)";
            //DBとの接続
            connection = create();
            // 必要事項を代入
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPass());
            stmt.executeUpdate();
            System.out.println("this is coneections");

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, stmt, null);
        }
    }
}