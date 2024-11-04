package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuizApp extends Application {
    private QuizManager quizManager; // Instance to manage quizzes

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Online Quiz Application");
        quizManager = new QuizManager(); // Initialize QuizManager

        // Create the main layout
        VBox layout = new VBox();
        Scene scene = new Scene(layout, 400, 400);

        // Add UI components
        addRegistrationForm(layout);
        addLoginForm(layout);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void addRegistrationForm(VBox layout) {
        // Registration form
        Label registerLabel = new Label("Register");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        Button registerButton = new Button("Register");

        registerButton.setOnAction(e -> {
            // Handle registration
            Login login = new Login();
            boolean success = login.registerUser(usernameField.getText(), passwordField.getText());
            if (success) {
                showAlert("Registration Successful");
            } else {
                showAlert("Registration Failed");
            }
        });

        layout.getChildren().addAll(registerLabel, usernameField, passwordField, registerButton);
    }

    private void addLoginForm(VBox layout) {
        // Login form
        Label loginLabel = new Label("Login");
        TextField loginUsernameField = new TextField();
        loginUsernameField.setPromptText("Username");
        PasswordField loginPasswordField = new PasswordField();
        loginPasswordField.setPromptText("Password");
        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            // Handle login
            Login login = new Login();
            boolean success = login.loginUser(loginUsernameField.getText(), loginPasswordField.getText());
            if (success) {
                showAlert("Login Successful");
                showQuizSelection(layout); // Proceed to quiz selection
            } else {
                showAlert("Login Failed");
            }
        });

        layout.getChildren().addAll(loginLabel, loginUsernameField, loginPasswordField, loginButton);
    }

    private void showQuizSelection(VBox layout) {
        layout.getChildren().clear(); // Clear previous components

        // Quiz selection
        Label quizLabel = new Label("Select a Quiz");
        ListView<String> quizListView = new ListView<>();
        quizListView.getItems().addAll(quizManager.getAllQuizzes());

        Button takeQuizButton = new Button("Take Quiz");
        takeQuizButton.setOnAction(e -> {
            String selectedQuiz = quizListView.getSelectionModel().getSelectedItem();
            if (selectedQuiz != null) {
                // Start the quiz
                Quiz quiz = new Quiz(quizManager);
                quiz.startQuiz(layout); // Pass the layout to startQuiz
            } else {
                showAlert("Please select a quiz.");
            }
        });

        layout.getChildren().addAll(quizLabel, quizListView, takeQuizButton);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
