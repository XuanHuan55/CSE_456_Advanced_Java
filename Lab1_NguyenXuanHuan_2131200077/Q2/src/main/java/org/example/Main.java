package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_q3_2024";
            String user = "root";
            String password = "xuanhuan2003@";

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database successfully");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Student");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int yob = rs.getInt("yearOfBirth");
                double gpa = rs.getDouble("gpa");

                System.out.println(id + " | " + firstName + " " + lastName + " | " + yob + " | GPA: " + gpa);
            }

            rs.close();
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
