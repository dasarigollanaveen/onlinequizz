package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final List<Question> questions;
    private final QuizManager quizManager;

    public Main(QuizManager quizManager) {
        this.quizManager = quizManager;
        this.questions = loadQuestions();
    }

    // Load questions based on selected quiz title (for simplicity, here are hardcoded questions)
    private List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is 2 + 2?", "2", "3", "4", "5", "4"));
        questions.add(new Question("What is 5 - 3?", "1", "2", "3", "4", "2"));
        return questions;
    }

    // CLI-compatible quiz method
    public void startQuiz(String quizTitle) {
        System.out.println("\nStarting Quiz: " + quizTitle);
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.println("Options: ");
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ": " + question.getOptions().get(i));
            }


            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (question.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + question.getCorrectAnswer());
            }
        }

        System.out.println("\nQuiz finished! Your score: " + score + "/" + questions.size());
    }
}
