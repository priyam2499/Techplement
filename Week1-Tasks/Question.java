import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    public int correctOptionIndex;

    public Question(String questionText, List<String> options, int correctOptionIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctOptionIndex;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(questionText + "\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1) + ". " + options.get(i) + "\n");
        }
        return sb.toString();
    }
}
