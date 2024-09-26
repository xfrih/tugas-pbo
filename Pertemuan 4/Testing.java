/**
 * Write a description of class TicketMachine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operasi {
    private float num1;
    private float num2;

    public void setNumber1(float amount) {
        num1 = amount;
    }

    public void setNumber2(float amount) {
        num2 = amount;
    }

    public float penjumlahan() {
        return num1 + num2;
    }

    public float pengurangan() {
        return num1 - num2;
    }

    public float perkalian() {
        return num1 * num2;
    }

    public float pembagian() {
        if(num2 != 0){
            return num1 / num2;
        }else{
            System.out.println("Error!");
            return 0;
        }
    }
}
