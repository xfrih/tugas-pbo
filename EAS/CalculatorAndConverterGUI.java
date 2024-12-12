import javax.swing.*;
import java.awt.*;

public class CalculatorAndConverterGUI extends JFrame {
    private CalculatorPanel calculatorPanel;
    private ConverterPanel converterPanel;
    private boolean isDarkMode = true; // Default to dark mode

    public CalculatorAndConverterGUI() {
        setTitle("Kalkulator dan Konverter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600); // Larger initial size for better scaling
        setLayout(new GridBagLayout()); // Dynamic layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components
        gbc.fill = GridBagConstraints.BOTH; // Ensure components expand

        // Panels for Calculator and Converter
        calculatorPanel = new CalculatorPanel();
        converterPanel = new ConverterPanel();

        // Panel for Switching Modes
        JPanel contentPanel = new JPanel(new CardLayout());
        contentPanel.add(calculatorPanel, "Calculator");
        contentPanel.add(converterPanel, "Converter");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(contentPanel, gbc); // Dynamic content panel

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Mode Menu
        JMenu modeMenu = new JMenu("Mode");
        JMenuItem calculatorMode = new JMenuItem("Calculator");
        JMenuItem converterMode = new JMenuItem("Converter");

        calculatorMode.addActionListener(e -> showPanel("Calculator", contentPanel));
        converterMode.addActionListener(e -> showPanel("Converter", contentPanel));

        modeMenu.add(calculatorMode);
        modeMenu.add(converterMode);

        // View Menu (Dark/Light Mode)
        JMenu viewMenu = new JMenu("View");
        JMenuItem darkModeItem = new JMenuItem("Enable Dark Mode");
        JMenuItem lightModeItem = new JMenuItem("Enable Light Mode");

        darkModeItem.addActionListener(e -> setDarkMode());
        lightModeItem.addActionListener(e -> setLightMode());

        viewMenu.add(darkModeItem);
        viewMenu.add(lightModeItem);

        // File Menu (Quit)
        JMenu fileMenu = new JMenu("Exit");
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(quitItem);
        
        // Info Menu
        JMenu infoMenu = new JMenu("Info");
        JMenuItem currencyInfoItem = new JMenuItem("Currency Info");

        currencyInfoItem.addActionListener(e -> showCurrencyInfo());

        infoMenu.add(currencyInfoItem);

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(modeMenu);
        //menuBar.add(infoMenu);

        setJMenuBar(menuBar);

        setLightMode(); // Default mode
    }
    
    private void showCurrencyInfo() {
        String info = "Currency Abbreviations:\n" +
                      "USD - United States Dollar\n" +
                      "EUR - Euro\n" +
                      "JPY - Japanese Yen\n" +
                      "GBP - British Pound\n" +
                      "IDR = Indonesian Rupiah\n";
        JOptionPane.showMessageDialog(this, info, "Currency Information", JOptionPane.INFORMATION_MESSAGE);
    }


    private void showPanel(String panelName, JPanel contentPanel) {
        CardLayout layout = (CardLayout) contentPanel.getLayout();
        layout.show(contentPanel, panelName);
    }

    private void setDarkMode() {
        isDarkMode = true;
        getContentPane().setBackground(Color.BLACK);
        calculatorPanel.setColors(Color.BLACK, Color.WHITE);
        converterPanel.setColors(Color.BLACK, Color.WHITE);
    }

    private void setLightMode() {
        isDarkMode = false;
        getContentPane().setBackground(Color.WHITE);
        calculatorPanel.setColors(Color.WHITE, Color.BLACK);
        converterPanel.setColors(Color.WHITE, Color.BLACK);
    }
}
