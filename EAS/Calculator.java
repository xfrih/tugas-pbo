public class Calculator {
    private double num1, num2;
    private char operator;

    // Setter for num1
    public void setNum1(double num1) {
        this.num1 = num1;
    }

    // Setter for num2
    public void setNum2(double num2) {
        this.num2 = num2;
    }

    // Setter for operator
    public void setOperator(char operator) {
        // Validate operator
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        this.operator = operator;
    }

    // Method to calculate the result
    public double calculate() {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                return num1 / num2;
            default:
                throw new IllegalStateException("Operator not set or unsupported");
        }
    }

    // Reset method to clear all values
    public void reset() {
        num1 = 0;
        num2 = 0;
        operator = '\0'; // Null character to signify no operator is set
    }

    // Debugging or Logging method (Optional)
    @Override
    public String toString() {
        return "Calculator{" +
               "num1=" + num1 +
               ", num2=" + num2 +
               ", operator=" + operator +
               '}';
    }
}
