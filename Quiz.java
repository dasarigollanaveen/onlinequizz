package main;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private final List<Question> questions;
    private final QuizManager quizManager;

    public Quiz(QuizManager quizManager) {
        this.quizManager = quizManager;
        this.questions = loadQuestions(); // Load questions
    }

    private List<Question> loadQuestions() {
        // For simplicity, we can hardcode questions here
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is 2 + 2?", "2", "3", "4", "5", "4"));
        questions.add(new Question("What is 5 - 3?", "1", "2", "3", "4", "2"));
        return questions; // Return the list of questions
    }

    public void startQuiz(VBox layout) {
        layout.getChildren().clear(); // Clear the layout for the quiz

        for (Question question : questions) {
            Label questionLabel = new Label(question.getQuestionText());
            TextField answerField = new TextField();
            Button submitButton = new Button("Submit");

            submitButton.setOnAction(e -> {
                String answer = answerField.getText();
                if (question.checkAnswer(answer)) {
                    showAlert("Correct!");
                } else {
                    showAlert("Incorrect. The correct answer is: " + question.getCorrectAnswer());
                }
                // Load next question or finish quiz
                // You can implement a mechanism to navigate through questions
            });

            layout.getChildren().addAll(questionLabel, answerField, submitButton);
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
