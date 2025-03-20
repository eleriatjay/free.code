package Payment;
import javax.swing.JOptionPane;

public class CreditCardPayment extends Payment {

    @Override
    public void processPayment() {
        String cardNumber = JOptionPane.showInputDialog("Enter Credit Card Number (without spaces):");
        
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

        String cvv = JOptionPane.showInputDialog("Enter CVV:");

        // Check if CVV is empty or not a valid 3-digit number
        if (cvv == null || cvv.trim().isEmpty() || cvv.length() != 3 || !cvv.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: CVV must be a 3-digit number.");
            return;
        }

        // For simplicity, we'll just print the information
        JOptionPane.showMessageDialog(null, "Processing Credit Card Payment...\n" +
                "Card Number: " + formattedCardNumber + "\nExpiry Date: " + expiryDate + "\nCVV: " + cvv);
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