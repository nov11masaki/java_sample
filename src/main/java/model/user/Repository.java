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
            connection = Client.create();
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

    // 名前でユーザーがデータベースに登録されているかを検索
    public static User selectUserByName(String name) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // sql文を用意
            String sql = "select * from users where name = ?";
            // DBとの接続
            connection = Client.create();
            

            stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            // sql文を実行
            rs = stmt.executeQuery();
            // スコープの問題があるので空のインスタンスを定義
            User user = null;
            if (rs.next()) {    // rsの中身があれば(select文にヒットすれば)
                user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("pass")
                );
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            close(connection, stmt, rs);
        }
    }
}