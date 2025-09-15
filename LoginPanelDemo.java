import java.awt.*;
import javax.swing.*;

public class LoginPanelDemo extends JFrame {

    public LoginPanelDemo() {
        setTitle("Human Resorce Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Labels and Fields
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        // Action for Login button
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("123")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
            }
        });

        // Add components to panel
        panel.add(userLabel); panel.add(userField);
        panel.add(passLabel); panel.add(passField);
        panel.add(new JLabel()); panel.add(loginButton);

        add(panel); // Add panel to frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPanelDemo();
    }
}
