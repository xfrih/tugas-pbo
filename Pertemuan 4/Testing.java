import java.util.Scanner;

public class Testing
{
   public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Kalkulator kalkulator = new Kalkulator();

        System.out.println("------------------------");
        System.out.println("Kalkulator");
        System.out.println("------------------------");

        //input angka yang kan digunakan 
        System.out.println("Masukkan angka pertama: ");
        double num1 = input.nextDouble();
        kalkulator.isiNum1(num1); // Set num1 di Kalkulator
        System.out.println("Masukkan angka kedua: ");
        double num2 = input.nextDouble();
        kalkulator.isiNum2(num2); // Set num2 di Kalkulator

        System.out.println("------Jenis Operasi------");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("Pilih Operasi: ");
        int pilih = input.nextInt();
        System.out.println("-----------Hasil----------");
            
        switch (pilih) {
            case 1:
                System.out.println("Hasil dari: " + num1 + " + " + num2 + " = " + kalkulator.tambah());
                break;
            case 2:
                System.out.println("Hasil dari: " + num1 + " - " + num2 + " = " + kalkulator.kurang());
                break;
            case 3:
                System.out.println("Hasil dari: " + num1 + " * " + num2 + " = " + kalkulator.kali());
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Hasil dari: " + num1 + " / " + num2 + " = " + kalkulator.bagi());
                } else {
                    System.out.println("Pembagian dengan nol tidak valid.");
                }                
                break;
            default:
                System.out.println("Operasi tidak valid");
                break;
       }
       input.close();
       System.out.println("---------------------------");
   }
}