package Payment;
import javax.swing.JOptionPane;

public class DigitalWalletPayment extends Payment {

    @Override
    public void processPayment() {
        String walletId = JOptionPane.showInputDialog("Enter Digital Wallet ID:");

        // Check if the wallet ID is empty
        if (walletId == null || walletId.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Wallet ID cannot be empty.");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter Wallet Password:");

        // Check if the password is empty
        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Password cannot be empty.");
            return;
        }

        // For simplicity, we'll just print the information
        JOptionPane.showMessageDialog(null, "Processing Digital Wallet Payment...\n" +
                "Wallet ID: " + walletId + "\nPassword: " + password);
    }
}