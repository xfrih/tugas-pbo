public class Ticket {
  protected double baseFare; // Tarif dasar

  // Konstruktor
  public Ticket(double baseFare) {
      this.baseFare = baseFare;
  }

  // Metode untuk menghitung tarif tiket (akan dioverride oleh subclass)
  public double calculateFare() {
      return baseFare;
  }

  // Menampilkan informasi tentang tiket
  public void displayInfo() {
      System.out.println("Tarif dasar: $" + baseFare);
      System.out.println("Total tarif: $" + calculateFare());
  }
}
