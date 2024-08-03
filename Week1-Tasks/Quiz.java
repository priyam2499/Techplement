import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String title;
    private List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        System.out.println("Starting quiz: " + title);
        
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\n" + (i + 1) + ". " + q.getQuestionText());
            for (int j = 0; j < q.getOptions().size(); j++) {
                System.out.println((j + 1) + ". " + q.getOptions().get(j));
            }
            System.out.print("Your answer (number): ");
            int userAnswer = scanner.nextInt() - 1;
            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The correct answer was " + (q.getOptions().get(q.correctOptionIndex)));
            }
        }
        System.out.println("\nQuiz completed. Your score: " + score + "/" + questions.size());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Quiz: " + title + "\n");
        for (Question q : questions) {
            sb.append(q.toString()).append("\n");
        }
        return sb.toString();
    }
}
