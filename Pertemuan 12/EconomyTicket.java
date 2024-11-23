public class EconomyTicket extends Ticket {
  public EconomyTicket(double baseFare) {
      super(baseFare);
  }

  @Override
  public double calculateFare() {
      // Diskon 10% untuk ekonomi
      return baseFare - (baseFare * 0.10);
  }
}
