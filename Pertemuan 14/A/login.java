import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(null);
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 80, 25);
        frame.add(usernameLabel);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 90, 80, 25);
        frame.add(passwordLabel);
        
        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 50, 165, 25);
        frame.add(usernameField);
        
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 90, 165, 25);
        frame.add(passwordField);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 130, 80, 25);
        frame.add(loginButton);
        
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 170, 300, 25);
        frame.add(resultLabel);
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if ("admin".equals(username) && "password".equals(password)) {
                    resultLabel.setText("Login successful!");
                    resultLabel.setForeground(Color.GREEN);
                } else {
                    resultLabel.setText("Invalid username or password.");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });
        
        frame.setVisible(true);
    }
}