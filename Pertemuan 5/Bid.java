public class Bid {
    private Person bidder;
    private double value;

    public Bid(Person bidder, double value) {
        this.bidder = bidder;
        this.value = value;
    }

    public Person getBidder() {
        return bidder;
    }

    public double getValue() {
        return value;
    }
}