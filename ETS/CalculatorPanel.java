import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private Calculator calculator;

    private double num1, num2, result;
    private char operator;
    private boolean isDecimalUsed = false; // Flag to track if a decimal is already added

    public CalculatorPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.BOTH;

        calculator = new Calculator();

        // Text field
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Text field spans 4 columns
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        add(textField, gbc);

        // Initialize buttons
        numberButtons = new JButton[10];
        functionButtons = new JButton[8];

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            functionButtons[i].addActionListener(new FunctionButtonListener());
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
            numberButtons[i].addActionListener(new NumberButtonListener());
        }

        // Add buttons to panel
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;

        // First row of buttons
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(numberButtons[1], gbc);
        gbc.gridx = 1;
        add(numberButtons[2], gbc);
        gbc.gridx = 2;
        add(numberButtons[3], gbc);
        gbc.gridx = 3;
        add(addButton, gbc);

        // Second row of buttons
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(numberButtons[4], gbc);
        gbc.gridx = 1;
        add(numberButtons[5], gbc);
        gbc.gridx = 2;
        add(numberButtons[6], gbc);
        gbc.gridx = 3;
        add(subButton, gbc);

        // Third row of buttons
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(numberButtons[7], gbc);
        gbc.gridx = 1;
        add(numberButtons[8], gbc);
        gbc.gridx = 2;
        add(numberButtons[9], gbc);
        gbc.gridx = 3;
        add(mulButton, gbc);

        // Fourth row of buttons
        gbc.gridy = 4;
        gbc.gridx = 0;
        add(decButton, gbc);
        gbc.gridx = 1;
        add(numberButtons[0], gbc);
        gbc.gridx = 2;
        add(equButton, gbc);
        gbc.gridx = 3;
        add(divButton, gbc);

        // Fifth row for Del and Clr buttons
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(delButton, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 2;
        add(clrButton, gbc);
        
        KeyboardInputHandler keyboardHandler = new KeyboardInputHandler(
            true, // isCalculatorMode
            textField,
            addButton,
            subButton,
            mulButton,
            divButton,
            decButton,
            equButton,
            clrButton
        );
        textField.addKeyListener(keyboardHandler);

    }

    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            textField.setText(textField.getText() + source.getText());
        }
    }

    private class FunctionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();

            if (source == decButton) {
                // Add decimal point if it hasn't been used
                if (!isDecimalUsed) {
                    textField.setText(textField.getText().concat("."));
                    isDecimalUsed = true; // Decimal point is now used
                }
            } else if (source == addButton || source == subButton || source == mulButton || source == divButton) {
                try {
                    num1 = Double.parseDouble(textField.getText());
                    operator = source.getText().charAt(0);
                    textField.setText("");
                    isDecimalUsed = false; // Reset decimal usage for the next number
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
            } else if (source == equButton) {
                try {
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+': result = num1 + num2; break;
                        case '-': result = num1 - num2; break;
                        case '*': result = num1 * num2; break;
                        case '/': result = num1 / num2; break;
                    }
                    textField.setText(String.valueOf(result));
                    num1 = result; // Allow chaining operations
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
                isDecimalUsed = false; // Reset decimal usage after calculation
            } else if (source == clrButton) {
                textField.setText("");
                isDecimalUsed = false; // Reset decimal usage
            } else if (source == delButton) {
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    // Remove last character
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                    // Update decimal flag
                    isDecimalUsed = currentText.contains(".");
                }
            }
        }
    }

    public void setColors(Color background, Color foreground) {
        setBackground(background);
        textField.setBackground(background);
        textField.setForeground(foreground);

        for (JButton button : numberButtons) {
            button.setBackground(background);
            button.setForeground(foreground);
        }

        for (JButton button : functionButtons) {
            button.setBackground(background);
            button.setForeground(foreground);
        }
    }


}
