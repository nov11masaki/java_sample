package model.mutter;

import model.user.User;

import lib.mysql.Client;
import java.sql.*;
import java.util.ArrayList;

public class Repository{
    public static void insert(Mutter mutter) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            String sql = "insert into mutters (name, text) values (?, ?)";

            connection = Client.create();


            stmt = connection.prepareStatement(sql);
            stmt.setString(1, mutter.getName());
            stmt.setString(2, mutter.getText());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Client.close(connection, stmt, null);
        }
    }

    public static ArrayList<Mutter> indexMutters() { 
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // nameで検索
            String sql = "select * from mutters order by id desc";

            connection = Client.create();
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            // つぶやきの一覧を保存する配列
            ArrayList<Mutter> mutters = new ArrayList<>();

            // rsがある限り保存
            while (rs.next()) {
                Mutter mutter = new Mutter(
                        Integer.parseInt(rs.getString("id")) , // idを追加
                        rs.getString("name"),
                        rs.getString("text")
                );
                // 配列に保存
                mutters.add(mutter);
            }
            return mutters;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            Client.close(connection, stmt, rs);
        }
    
    }

    // そのユーザーのつぶやき一覧(配列)を取得
    public static ArrayList<Mutter> indexMutters(User user){
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // nameで検索
            String sql = "select * from mutters where name = ? order by id desc";

            connection = Client.create();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getName());
            rs = stmt.executeQuery();

            // つぶやきの一覧を保存する配列
            ArrayList<Mutter> mutters = new ArrayList<>();

            // rsがある限り保存
            while (rs.next()) {
                Mutter mutter = new Mutter(
                        Integer.parseInt(rs.getString("id")),
                        rs.getString("name"),
                        rs.getString("text")
                );
                // 配列に保存
                mutters.add(mutter);
            }
            return mutters;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            Client.close(connection, stmt, rs);
        }
    }

    public static void delete(Mutter mutter){
        Connection connection = null;
        PreparedStatement stmt = null;

        try{
            String sql = "DELETE from mutters where id = ?";

            connection = Client.create();

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1,mutter.getId());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Client.close(connection, stmt,null);
        }
    }
}