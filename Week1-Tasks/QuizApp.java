import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    private static List<Quiz> quizzes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Quiz App!");
        
        while (true) {
            System.out.println("\nCommands: ");
            System.out.println("1. create_quiz - Create a new quiz");
            System.out.println("2. list_quizzes - List all quizzes");
            System.out.println("3. take_quiz - Take a quiz");
            System.out.println("4. exit - Exit the application");
            System.out.print("Enter command: ");
            command = scanner.nextLine();

            switch (command) {
                case "create_quiz":
                    createQuiz(scanner);
                    break;
                case "list_quizzes":
                    listQuizzes();
                    break;
                case "take_quiz":
                    takeQuiz(scanner);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }

    private static void createQuiz(Scanner scanner) {
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        Quiz quiz = new Quiz(title);

        while (true) {
            System.out.print("Enter question (or 'done' to finish): ");
            String questionText = scanner.nextLine();
            if (questionText.equals("done")) break;

            List<String> options = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter option " + (i + 1) + ": ");
                options.add(scanner.nextLine());
            }
            System.out.print("Enter the number of the correct option: ");
            int correctOption = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the leftover newline

            Question question = new Question(questionText, options, correctOption);
            quiz.addQuestion(question);
        }

        quizzes.add(quiz);
        System.out.println("Quiz created successfully!");
    }

    private static void listQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
            return;
        }

        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).toString());
        }
    }

    private static void takeQuiz(Scanner scanner) {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
            return;
        }

        listQuizzes();
        System.out.print("Enter the number of the quiz you want to take: ");
        int quizIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume the leftover newline

        if (quizIndex < 0 || quizIndex >= quizzes.size()) {
            System.out.println("Invalid quiz number.");
            return;
        }

        Quiz quiz = quizzes.get(quizIndex);
        quiz.takeQuiz();
    }
}
