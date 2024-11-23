public class BusinessTicket extends Ticket {
  public BusinessTicket(double baseFare) {
      super(baseFare);
  }

  @Override
  public double calculateFare() {
      // Biaya tambahan 25% untuk bisnis
      return baseFare + (baseFare * 0.25);
  }
}
