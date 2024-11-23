public class TicketReservationSystem {
  public static void main(String[] args) {
      // Membuat objek untuk masing-masing tiket
      Ticket economyTicket = new EconomyTicket(1000);   // Tarif dasar $1000
      Ticket businessTicket = new BusinessTicket(1000); // Tarif dasar $1000
      Ticket firstClassTicket = new FirstClassTicket(1000); // Tarif dasar $1000

      // Menampilkan informasi tentang tiket
      System.out.println("Tiket Ekonomi:");
      economyTicket.displayInfo();

      System.out.println("\nTiket Bisnis:");
      businessTicket.displayInfo();

      System.out.println("\nTiket First Class:");
      firstClassTicket.displayInfo();
  }
}
