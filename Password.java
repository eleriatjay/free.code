import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Password {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public Password() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setLocationRelativeTo(null);

        // Main background panel
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(255, 255, 255)); // Facebook blue
        backgroundPanel.setLayout(new BorderLayout());

        // Title label (Facebook-like)
        JLabel titleLabel = new JLabel("LOGIN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(java.awt.Color.GREEN);
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // White login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.WHITE);
        loginPanel.setPreferredSize(new Dimension(350, 250));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Email Field
        emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(200, 30));
        loginPanel.add(new JLabel("Email:"), gbc);
        gbc.gridy++;
        loginPanel.add(emailField, gbc);

        // Password Field
        gbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30));
        loginPanel.add(new JLabel("Password:"), gbc);
        gbc.gridy++;
        loginPanel.add(passwordField, gbc);

        // Login Button
        gbc.gridy++;
        JButton loginButton = new JButton("Log In");
        loginButton.setBackground(new Color(24, 119, 242)); // Facebook blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(200, 40));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validatePassword();
            }
        });
        loginPanel.add(loginButton, gbc);

        // Message Label
        gbc.gridy++;
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setForeground(Color.RED);
        loginPanel.add(messageLabel, gbc);

        // Add login panel to the center
        backgroundPanel.add(loginPanel, BorderLayout.CENTER);
        frame.add(backgroundPanel);
        frame.setVisible(true);
    }
    private void validatePassword() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Fields cannot be empty!");
        } else if (password.length() < 8) {
            messageLabel.setText("Password must be at least 8 characters!");
        } else {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Login Successful!");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Password::new);
    }
}
