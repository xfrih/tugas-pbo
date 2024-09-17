private int price;

private int balance;

private int total;

public class circle{
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    public Circle{
        diameter = 30;
        xPosition = 20;
        yPosition = 60;
        color = 'blue';
        isVisible = false;
    }
}


public int getPrice(){
    return price;
}

public int getBalance(){
    return balance;
}

public int insertMoney(int amount){
    balance = balance + amount;
}

public void printTicket(){
    System.out.println("############");
    System.out.println("# The BlueJ line");
    System.out.println("# Ticket");
    System.out.println("# " + price + "cents.");
    System.out.println("############");
    System.out.println("");

    total = total + balance;
    balance = 0;
}




