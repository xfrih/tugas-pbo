import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterPanel extends JPanel {
    private JComboBox<String> currencyFrom, currencyTo;
    private JTextField amountField, resultField;
    private JButton convertButton, clrButton;
    private Converter converter;

    public ConverterPanel() {
        setLayout(new GridBagLayout()); // Dynamic layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Smaller padding for better proportions
        gbc.fill = GridBagConstraints.BOTH; // Ensure components fill their cells proportionally
        converter = new Converter();

        // Uniform border for all components
        Border uniformBorder = BorderFactory.createLineBorder(Color.GRAY, 2); // Thicker border for better visibility
        Font font = new Font("Arial", Font.BOLD, 18); // Larger font for all components

        // Labels
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fromLabel.setFont(font);

        JLabel toLabel = new JLabel("To:");
        toLabel.setHorizontalAlignment(SwingConstants.CENTER);
        toLabel.setFont(font);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        amountLabel.setFont(font);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(font);

        // ComboBoxes
        currencyFrom = new JComboBox<>(new String[]{"USD", "EUR", "IDR", "JPY", "GBP"});
        currencyFrom.setFont(font);
        currencyFrom.setBorder(uniformBorder);

        currencyTo = new JComboBox<>(new String[]{"USD", "EUR", "IDR", "JPY", "GBP"});
        currencyTo.setFont(font);
        currencyTo.setBorder(uniformBorder);

        // TextFields
        amountField = new JTextField();
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setFont(font);
        amountField.setBorder(uniformBorder);

        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.CENTER);
        resultField.setFont(font);
        resultField.setBorder(uniformBorder);

        // Buttons
        convertButton = new JButton("Convert");
        convertButton.setFont(font);

        clrButton = new JButton("C");
        clrButton.setFont(font);

        // Add components to panel with proportions
        gbc.weightx = 1.0;
        gbc.weighty = 0.1; // Adjust weight for labels and text fields
        gbc.gridwidth = 1; // Default grid width

        // Row 1: From
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(fromLabel, gbc);

        gbc.gridx = 1;
        add(currencyFrom, gbc);

        // Row 2: To
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(toLabel, gbc);

        gbc.gridx = 1;
        add(currencyTo, gbc);

        // Row 3: Amount
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(amountLabel, gbc);

        gbc.gridx = 1;
        add(amountField, gbc);

        // Row 4: Result
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(resultLabel, gbc);

        gbc.gridx = 1;
        add(resultField, gbc);

        // Row 5: Buttons
        gbc.weighty = 0.2; // Make buttons larger
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(clrButton, gbc);

        gbc.gridx = 1;
        add(convertButton, gbc);

        // Add action listeners
        convertButton.addActionListener(new ConvertButtonListener());
        clrButton.addActionListener(e -> {
            amountField.setText("");
            resultField.setText("");
        });
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = (String) currencyFrom.getSelectedItem();
                String to = (String) currencyTo.getSelectedItem();
                double result = converter.convert(amount, from, to);
                resultField.setText(String.format("%.2f", result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(ConverterPanel.this, "Invalid input. Please enter a valid number.");
            }
        }
    }

    public void setColors(Color background, Color foreground) {
        setBackground(background);
        for (Component component : getComponents()) {
            if (component instanceof JLabel || component instanceof JButton || component instanceof JComboBox || component instanceof JTextField) {
                component.setBackground(background);
                component.setForeground(foreground);
            }
        }
    }
}
