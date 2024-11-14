import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getExitString() {
        StringBuilder exitString = new StringBuilder("Exits: ");
        for (String direction : exits.keySet()) {
            exitString.append(direction).append(" ");
        }
        return exitString.toString();
    }
}
