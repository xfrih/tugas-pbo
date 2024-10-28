public class Lot {
    private int number;
    private String description;
    private Bid highestBid;

    public Lot(int number, String description) {
        this.number = number;
        this.description = description;
        this.highestBid = null;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public boolean bidFor(Bid bid) {
        if (highestBid == null || bid.getValue() > highestBid.getValue()) {
            highestBid = bid;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Lot " + number + ": " + description + 
               (highestBid != null ? " (Highest bid: " + highestBid.getValue() + ")" : " (No bids yet)");
    }
}