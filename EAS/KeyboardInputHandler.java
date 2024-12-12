import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class KeyboardInputHandler implements KeyListener {
    private boolean isCalculatorMode;
    private JTextField textField;
    private JButton addButton, subButton, mulButton, divButton, decButton, equButton, clrButton;

    public KeyboardInputHandler(
        boolean isCalculatorMode,
        JTextField textField,
        JButton addButton,
        JButton subButton,
        JButton mulButton,
        JButton divButton,
        JButton decButton,
        JButton equButton,
        JButton clrButton
    ) {
        this.isCalculatorMode = isCalculatorMode;
        this.textField = textField;
        this.addButton = addButton;
        this.subButton = subButton;
        this.mulButton = mulButton;
        this.divButton = divButton;
        this.decButton = decButton;
        this.equButton = equButton;
        this.clrButton = clrButton;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (isCalculatorMode) {
            // Kalkulator mode
            if (Character.isDigit(c)) {
                textField.setText(textField.getText() + c);
            } else if (c == '+') {
                addButton.doClick();
            } else if (c == '-') {
                subButton.doClick();
            } else if (c == '*') {
                mulButton.doClick();
            } else if (c == '/') {
                divButton.doClick();
            } else if (c == '.') {
                decButton.doClick();
            } else if (c == '\n') { // Enter key for equals
                equButton.doClick();
            } else if (c == 'c' || c == 'C') {
                clrButton.doClick();
            }
        } else {
            // Converter mode
            if (Character.isDigit(c)) {
                textField.setText(textField.getText() + c);
            } else if (c == '.') {
                if (!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + c);
                }
            } else if (c == 'c' || c == 'C') {
                clrButton.doClick();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
