public class Kalkulator
{
    private double num1;
    private double num2;

    //mengisi nilai num1
    public void isiNum1 (double x){
        num1 = x;
    }
    
    //mengisi nilai num2
    public void isiNum2 (double y) {
        num2 = y;
    }
    
    // Method operasi menggunakan variabel instance num1 dan num2
    public double tambah(){
        return num1 + num2;
    }
    
    public double kurang(){
        return num1 - num2;
    }
    
    public double kali(){
        return num1 * num2;
    }
    
    public double bagi(){
        return num1 / num2;
    }
}
