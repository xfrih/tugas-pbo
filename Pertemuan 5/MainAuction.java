public class MainAuction
{
    public static void main(String[] args) {
        Auction auction = new Auction();

        auction.enterLot("BMW E36");
        auction.enterLot("Mazda RX-7");
        auction.enterLot("Toyota Supra MK4");

        System.out.println("Available Lots:");
        auction.showLots();

        Person person1 = new Person("Mufrih");
        Person person2 = new Person("Vino");
        Person person3 = new Person("Rafie");

        System.out.println("\nBidding:");

        auction.makeABid(1, person1, 100);
        auction.makeABid(1, person2, 80);
        auction.makeABid(1, person2, 120);
        auction.makeABid(2, person1, 5000);
        auction.makeABid(2, person3, 1000);
        auction.makeABid(3, person3, 2000);

        System.out.println("\nINFO:");
        auction.showLots();
    }
}