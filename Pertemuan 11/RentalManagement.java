import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Penyewa> penyewaList = new ArrayList<>();

        while (true) {
            System.out.println("Option: ");
            System.out.println("1. Tambah data sewa");
            System.out.println("2. Lihat semua data sewa");
            System.out.println("3. Keluar");
            System.out.print("Choose Option: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {

                System.out.println("Masukkan data kendaraan yang tersedia:");
                System.out.print("Merk: ");
                String merk = scanner.nextLine();
                System.out.print("Model: ");
                String model = scanner.nextLine();
                System.out.print("Tahun Produksi: ");
                int tahunProduksi = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Jenis Kendaraan (Mobil/Motor/Sepeda): ");
                String jenisKendaraan = scanner.nextLine();

                Kendaraan kendaraan;
                if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
                    System.out.print("Jumlah Roda: ");
                    int jumlahRoda = scanner.nextInt();
                    scanner.nextLine();
                    kendaraan = new Mobil(merk, model, tahunProduksi, jumlahRoda);
                } else if (jenisKendaraan.equalsIgnoreCase("Motor")) {
                    System.out.print("Jumlah Roda: ");
                    int jumlahRoda = scanner.nextInt();
                    scanner.nextLine();
                    kendaraan = new Motor(merk, model, tahunProduksi, jumlahRoda);
                } else if (jenisKendaraan.equalsIgnoreCase("Sepeda")) {
                    System.out.print("Jenis Sepeda: ");
                    String jenisSepeda = scanner.nextLine();
                    kendaraan = new Sepeda(merk, model, tahunProduksi, jenisSepeda);
                } else {
                    System.out.println("Jenis kendaraan tidak valid.");
                    continue;
                }

                System.out.print("\nNama: ");
                String namaPenyewa = scanner.nextLine();

                Penyewa penyewa = new Penyewa(namaPenyewa, kendaraan);
                penyewaList.add(penyewa);

                System.out.println("Data sewa berhasil ditambahkan.\n");
            } else if (pilihan == 2) {

                if (penyewaList.isEmpty()) {
                    System.out.println("\nTidak ada data sewa.\n");
                } else {
                    for (Penyewa penyewa : penyewaList) {
                        System.out.println(penyewa.getDetailSewa());
                    }
                }
            } else if (pilihan == 3) {

                System.out.println("\nTerima kasih!");
                break;
            } else {
                System.out.println("\nPilihan tidak valid.\n");
            }
        }

        scanner.close();
    }
}