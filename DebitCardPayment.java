package Payment;
import javax.swing.JOptionPane;

public class DebitCardPayment extends Payment {

    @Override
    public void processPayment() {
        String cardNumber = JOptionPane.showInputDialog("Enter Debit Card Number (without spaces):");

        // Check if the card number is empty or contains non-digit characters
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Card number cannot be empty.");
            return;
        }

        // Remove any non-digit characters and check if the card number has the correct length (16 digits)
        cardNumber = cardNumber.replaceAll("[^\\d]", "");
        if (cardNumber.length() != 16) {
            JOptionPane.showMessageDialog(null, "Error: Card number must be 16 digits long.");
            return;
        }

        String formattedCardNumber = formatCardNumberWithSpaces(cardNumber);

        String expiryDate = JOptionPane.showInputDialog("Enter Expiry Date (MMYY):");

        // Check if the expiry date is empty or not in the correct format
        if (expiryDate == null || expiryDate.trim().isEmpty() || expiryDate.length() != 4) {
            JOptionPane.showMessageDialog(null, "Error: Expiry date must be 4 digits (MMYY).");
            return;
        }

        // Automatically add a '/' between MM and YY
        expiryDate = expiryDate.substring(0, 2) + "/" + expiryDate.substring(2);

        String pin = JOptionPane.showInputDialog("Enter PIN:");

        // Check if PIN is empty or not a valid 4-digit number
        if (pin == null || pin.trim().isEmpty() || pin.length() != 4 || !pin.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: PIN must be a 4-digit number.");
            return;
        }

        // For simplicity, we'll just print the information
        JOptionPane.showMessageDialog(null, "Processing Debit Card Payment...\n" +
                "Card Number: " + formattedCardNumber + "\nExpiry Date: " + expiryDate + "\nPIN: " + pin);
    }

    // Helper method to format the card number with spaces
    private String formatCardNumberWithSpaces(String cardNumber) {
        StringBuilder formattedCardNumber = new StringBuilder();
        for (int i = 0; i < cardNumber.length(); i++) {
            if (i > 0 && i % 4 == 0) {
                formattedCardNumber.append(" "); // Add a space after every 4 digits
            }
            formattedCardNumber.append(cardNumber.charAt(i));
        }
        return formattedCardNumber.toString();
    }
}