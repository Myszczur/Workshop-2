package pl.coderslab.entity;

import pl.coderslab.entity.User;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class DbUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "coderslab";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    static User[] addToArray(User s, User[] users) {
        User[] usersData = Arrays.copyOf(users, users.length + 1);
        usersData[users.length] = s;
        return usersData;
    }

    public static int getInt(Scanner scanner, String text) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.err.println(text);
        }
        return scanner.nextInt();
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectOption() {

        System.out.println("Please select an option:\n" + "-Add New User (write: add)\n" + "-Update User (write: update)\n" + "-Show User(write: show)\n" + "-Remove User (write: remove)\n" + "-List All users (write: all)\n" + "-exit (write: exit)\n");
    }

}
