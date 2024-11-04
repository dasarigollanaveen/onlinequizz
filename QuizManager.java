package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; // Import for ArrayList
import java.util.List; // Import for List

public class QuizManager {

    // Method to add a new quiz
    public boolean addQuiz(String title) {
        String sql = "INSERT INTO quizzes (title) VALUES (?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.executeUpdate();
            return true; // Quiz added successfully
        } catch (SQLException e) {
            System.out.println("Error adding quiz: " + e.getMessage());
            return false; // Failed to add quiz
        }
    }

    // Method to fetch all quizzes
    public List<String> getAllQuizzes() {
        List<String> quizzes = new ArrayList<>(); // Create an ArrayList to hold quiz titles
        String sql = "SELECT title FROM quizzes";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                quizzes.add(rs.getString("title")); // Add each quiz title to the list
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving quizzes: " + e.getMessage());
        }
        return quizzes; // Return the list of quizzes
    }
}
