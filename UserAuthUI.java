package main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserAuthUI extends Application {

    private final Login login = new Login();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Authentication");

        // Create the layout
        VBox layout = createLayout();

        // Setup scene and show
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create the layout
    private VBox createLayout() {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> registerUser(usernameField.getText(), passwordField.getText()));

        Button loginButton = new Button("Login");
        loginButton.setOnAction(event -> loginUser(usernameField.getText(), passwordField.getText()));

        return new VBox(10, usernameField, passwordField, registerButton, loginButton);
    }

    // Handle user registration
    private void registerUser(String username, String password) {
        if (login.registerUser(username, password)) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Registration failed.");
        }
    }

    // Handle user login
    private void loginUser(String username, String password) {
        if (login.loginUser(username, password)) {
            System.out.println("Login successful!");
            // Proceed to quiz selection or starting a quiz
        } else {
            System.out.println("Invalid login credentials.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
