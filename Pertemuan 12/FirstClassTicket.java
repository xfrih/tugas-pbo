public class FirstClassTicket extends Ticket {
  public FirstClassTicket(double baseFare) {
      super(baseFare);
  }

  @Override
  public double calculateFare() {
      // Biaya tambahan 50% untuk first class
      return baseFare + (baseFare * 0.50);
  }
}
