public class CommandWords {
    private static final String[] validCommands = {"go", "quit", "help"};

    public boolean isCommand(String aString) {
        for (String command : validCommands) {
            if (command.equals(aString)) {
                return true;
            }
        }
        return false;
    }

    public void showAll() {
        for (String command : validCommands) {
            System.out.print(command + " ");
        }
        System.out.println();
    }
}
