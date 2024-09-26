import java.util.Scanner;

public class Kalkulator {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        Operasi operasi = new Operasi();

        System.out.print("Masukkan angka pertama: ");
        float number1 = scanner.nextFloat();
        operasi.setNumber1(number1);

        System.out.print("Masukkan angka kedua: ");
        float number2 = scanner.nextFloat();
        operasi.setNumber2(number2);

        System.out.print("Operasi (1: Penjumlahan, 2: Pengurangan, 3: Perkalian, 4: Pembagian): ");
        int pilihan = scanner.nextInt();

        if(pilihan == 1){
            System.out.println("Hasil: " + operasi.penjumlahan());
        }else if (pilihan == 2){
            System.out.println("Hasil: " + operasi.pengurangan());
        }else if (pilihan == 3){
            System.out.println("Hasil: " + operasi.perkalian());
        }else if (pilihan == 4){
            System.out.println("Hasil: " + operasi.pembagian());
        }else{
            System.out.println("Error!");
        }
    }
}
