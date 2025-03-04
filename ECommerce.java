import java.text.DecimalFormat;  // Import the DecimalFormat class

// Base class representing a general product
class Product {
    // Common attributes
    protected String name;
    protected double price;
    protected int quantity;
    DecimalFormat df = new DecimalFormat("#,###.00");  // Corrected the typo and format

    // Constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display product info
    public void displayInfo() {
        // Format the price using DecimalFormat
        String formattedPrice = df.format(price);
        System.out.println("Product: " + name + ", Price: $" + formattedPrice + ", Quantity: " + quantity);
    }

    // Method to calculate the total price for the quantity
    public double calculateTotalPrice() {
        return price * quantity;
    }
}

// Derived class Electronics
class Electronics extends Product {
    private int warranty;  // Unique attribute for Electronics

    // Constructor
    public Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }

    // Override displayInfo to add warranty
    @Override
    public void displayInfo() {
        String formattedPrice = df.format(price);
        System.out.println("Electronics: " + name + ", Price: $" + formattedPrice + ", Quantity: " + quantity + ", Warranty: " + warranty + " months");
    }

    // Override calculateTotalPrice to display extended warranty info
    @Override
    public double calculateTotalPrice() {
        double total = super.calculateTotalPrice();
        String formattedTotal = df.format(total);
        System.out.println("Total Price: $" + formattedTotal);
        return total;
    }

    // Unique method for Electronics
    public void extendWarranty(int months) {
        this.warranty += months;
        System.out.println("Warranty extended by " + months + " months. New warranty period: " + this.warranty + " months");
    }
}

// Derived class Clothing
class Clothing extends Product {
    private String size;  // Unique attribute for Clothing

    // Constructor
    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    // Override displayInfo to add size
    @Override
    public void displayInfo() {
        String formattedPrice = df.format(price);
        System.out.println("Clothing: " + name + ", Price: $" + formattedPrice + ", Quantity: " + quantity + ", Size: " + size);
    }

    // Override calculateTotalPrice
    @Override
    public double calculateTotalPrice() {
        double total = super.calculateTotalPrice();
        String formattedTotal = df.format(total);
        System.out.println("Total Price: $" + formattedTotal);
        return total;
    }

    // Unique method for Clothing
    public void tryOn() {
        System.out.println("Trying on " + name + " in size " + size);
    }
}

// Derived class Book
class Book extends Product {
    private String author;  // Unique attribute for Book

    // Constructor
    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    // Override displayInfo to add author
    @Override
    public void displayInfo() {
        String formattedPrice = df.format(price);
        System.out.println("Book: " + name + ", Price: $" + formattedPrice + ", Quantity: " + quantity + ", Author: " + author);
    }

    // Override calculateTotalPrice
    @Override
    public double calculateTotalPrice() {
        double total = super.calculateTotalPrice();
        String formattedTotal = df.format(total);
        System.out.println("Total Price: $" + formattedTotal);
        return total;
    }

    // Unique method for Book
    public void readPreview() {
        System.out.println("Reading a preview of " + name + " by " + author);
    }
}

// Main class to test the functionality
public class ECommerce {
    public static void main(String[] args) {
        // Create instances of the different product types
        Product product1 = new Electronics("Laptop", 1200.00, 10, 24);
        Product product2 = new Clothing("T-Shirt", 25.00, 50, "L");
        Product product3 = new Book("1984", 15.00, 100, "George Orwell");

        // Display product information and calculate total price
        System.out.println("E-COMMERCE SYSTEM");
        product1.displayInfo();
        product1.calculateTotalPrice();
        ((Electronics) product1).extendWarranty(6);  // Extend warranty for Electronics
        System.out.println("------------------------------");

        product2.displayInfo();
        product2.calculateTotalPrice();
        ((Clothing) product2).tryOn();  // Try on the Clothing
        System.out.println("------------------------------");

        product3.displayInfo();
        product3.calculateTotalPrice();
        ((Book) product3).readPreview();  // Read preview of the Book
        System.out.println("------------------------------");
    }
}
