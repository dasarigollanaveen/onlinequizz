package main;
import java.util.Arrays;
import java.util.List;

public class Question {
    private String questionText;
    private String correctAnswer;
    private String[] options;

    public Question(String questionText, String option1, String option2, String option3, String option4, String correctAnswer) {
        this.questionText = questionText;
        this.options = new String[]{option1, option2, option3, option4};
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return Arrays.asList(options);
    }

    public boolean checkAnswer(String answer) {
        return correctAnswer.equals(answer);
    }
    public String getCorrectAnswer()
    {
        return correctAnswer;
    }
}
