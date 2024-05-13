package com.sample.springJDBCDemo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.springJDBCDemo.model.User;

@Repository
public class DemoRepository {
    
    @Autowired
    DataSource dbConection;

    public User saveUser(User user){
        try {
            Connection connection = dbConection.getConnection();
            PreparedStatement psmt = connection.prepareStatement("INSERT INTO users (id, name, city) VALUES (?, ?, ?)");
            psmt.setInt(1, user.getId());
            psmt.setString(2, user.getName());
            psmt.setString(3, user.getCity());
            psmt.executeUpdate();
            psmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleted(int id){
        try {
            Connection connection = dbConection.getConnection();
            PreparedStatement psmt = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = dbConection.getConnection();
            PreparedStatement psmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                User user = new User(id, name, city);
                users.add(user);
            }
            rs.close();
            psmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int id) {
        User user = null;
        try {
            Connection con = dbConection.getConnection();
            PreparedStatement psmt = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            psmt.setInt(1, id);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                user = new User(userId, name, city);
            }
            rs.close();
            psmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return user;
    }

    public User updateUser(User user) {
        try {
            Connection con = dbConection.getConnection();
            PreparedStatement psmt = con.prepareStatement("UPDATE users SET name = ?, city = ? WHERE id = ?");
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getCity());
            psmt.setInt(3, user.getId());
            psmt.executeUpdate();
            psmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
