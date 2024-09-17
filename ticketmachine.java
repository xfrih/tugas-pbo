import java.util.Scanner;  

public class ticketmachine {
    private int price;          
    private int balance;        
    private int total;          

   
    public ticketmachine(int ticketPrice) {
        this.price = ticketPrice;
        this.balance = 0;
        this.total = 0;
    }

   
    public int getBalance() {
        return balance;
    }

   
    public int getPrice() {
        return price;
    }

    
    public void insertMoney(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Uang berhasil dimasukkan: " + amount);
        } else {
            System.out.println("Masukkan jumlah uang yang valid.");
        }
    }

    
    public void printTicket(int quantity) {
        int totalCost = price * quantity;  
        if (balance >= totalCost) {
            System.out.println("Mencetak " + quantity + " tiket...");
            balance -= totalCost;
            total += totalCost;
            System.out.println("Tiket berhasil dicetak.");
            System.out.println("Saldo tersisa: " + balance);
        } else {
            System.out.println("Saldo tidak cukup untuk mencetak tiket.");
            System.out.println("Harga total: " + totalCost + ", Saldo Anda: " + balance);
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        
        System.out.print("Masukkan harga tiket: ");
        int ticketPrice = scanner.nextInt();
        ticketmachine machine = new ticketmachine(ticketPrice); 
        
       
        while (true) {
            System.out.println("\n1. Masukkan uang");
            System.out.println("2. Cetak tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Masukkan jumlah uang: ");
                    int amount = scanner.nextInt();
                    machine.insertMoney(amount);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
                    int quantity = scanner.nextInt();  
                    if (quantity > 0) {
                        machine.printTicket(quantity);  
                    } else {
                        System.out.println("Masukkan jumlah tiket yang valid.");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan mesin tiket.");
                    System.out.println("Saldo akhir Anda: " + machine.getBalance());
                    scanner.close();
                    return;  
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}
