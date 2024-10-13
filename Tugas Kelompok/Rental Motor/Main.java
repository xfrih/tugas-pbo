import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Rental Motor:");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Item");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String namaItem = scanner.nextLine();
                    System.out.print("Masukkan jumlah item: ");
                    int jumlahItem = scanner.nextInt();
                    inventory.tambahItem(namaItem, jumlahItem);
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String itemHapus = scanner.nextLine();
                    inventory.hapusItem(itemHapus);
                    break;
                case 3:
                    inventory.tampilkanItem();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);

        scanner.close();
    }
}
