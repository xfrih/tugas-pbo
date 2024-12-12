import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorAndConverterGUI app = new CalculatorAndConverterGUI();
            app.setVisible(true);
        });
    }
}
