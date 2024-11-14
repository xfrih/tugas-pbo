import java.util.Scanner;

public class Parser {
    private CommandWords commandWords;
    private Scanner reader;

    public Parser() {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();
        String word1 = null;
        String word2 = null;

        String[] words = inputLine.split(" ");
        if (words.length > 0) {
            word1 = words[0];
            if (words.length > 1) {
                word2 = words[1];
            }
        }

        if (commandWords.isCommand(word1)) {
            return new Command(word1, word2);
        } else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        commandWords.showAll();
    }
}
