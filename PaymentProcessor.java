package Payment;
import javax.swing.JOptionPane;

public class PaymentProcessor {

    public static void main(String[] args) {
        // Shows the dialog to choose payment method
        String[] options = {"Credit Card", "Debit Card", "Digital Wallet"};
        int choice = JOptionPane.showOptionDialog(null, 
                "Select Payment Method", 
                "Payment Processor", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, options, options[0]);
        
        Payment payment = null;
        
        // Creates the payment object based on the users choice
        switch (choice) {
            case 0:
                payment = new CreditCardPayment();
                break;
            case 1:
                payment = new DebitCardPayment();
                break;
            case 2:
                payment = new DigitalWalletPayment();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Exiting...");
                System.exit(0);
        }
        
        // Process the payment
        if (payment != null) {
            payment.processPayment();
        }
    }
}