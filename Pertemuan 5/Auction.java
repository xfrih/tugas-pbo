import java.util.ArrayList;

public class Auction{
    private ArrayList<Lot> lots;
    private int nextLotNumber;

    public Auction(){
        lots = new ArrayList<>();
        nextLotNumber = 1;
    }
    
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    public void showLots(){
        for(Lot lot : lots){
            System.out.println(lot.toString());
        }
    }

    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null){
            Bid bid = new Bid(bidder, value);
            boolean successful = selectedLot.bidFor(bid);
            if(successful){
                System.out.println(bidder + " Bid for lot number " + lotNumber + " success!");
            }else{
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println(bidder + " Bid for Lot number " + lotNumber +
                        " is lower than the highest Bid: " + highestBid.getValue());
            }
        }
    }
    
    public Lot getLot(int lotNumber) {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)){
            Lot selectedLot = lots.get(lotNumber - 1);

            if(selectedLot.getNumber() != lotNumber){
                System.out.println("Error: Lot number " +
                        selectedLot.getNumber() + " was returned instead of " + 
                        lotNumber);
                return null;
            }
            return selectedLot;
        }else{
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }
    }
}