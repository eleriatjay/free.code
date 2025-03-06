import java.text.DecimalFormat;

// Parent Class
class Product {
    protected String name;
    protected double price;
    protected int quantity;
    DecimalFormat df = new DecimalFormat("#,###.00");

//    constructor
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public void displayInfo() {
        System.out.println("[Product] " + name + " | Price: $" + df.format(price) + " | Stock: " + quantity);
    }
    public double calculateTotalPrice() {
        double total = price * quantity;
        System.out.println("Total Price " + name + ": $" + df.format(total));
        return total;
    }
}

// Electronics Child Class
class Electronics extends Product {
    private int warranty;

//    constructor 
    public Electronics(String name, double price, int quantity, int warranty) {
        super(name, price, quantity);
        this.warranty = warranty;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Electronics] " + name + " | Price: $" + df.format(price) + " | Quantity: " + quantity + " | Warranty: " + warranty + " months");
    }
    public void extendWarranty(int months) {
        warranty += months;
        System.out.println(name + " warranty extended! New warranty: " + warranty + " months.");
    }
}

// Clothing Child Class
class Clothing extends Product {
    private String size;
    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Clothing] " + name + " | Price: $" + df.format(price) + " | Quantity: " + quantity + " | Size: " + size);
    }
    public void tryOn() {
        System.out.println("Trying on: " + name + " (Size: " + size + ")");
    }
}

// Book Child Class
class Book extends Product {
    private String author;

    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Book] " + name + " | Price: $" + df.format(price) + " | Quantity: " + quantity + " | Author: " + author);
    }
    public void readPreview() {
        System.out.println("Reading a preview of " + name + " by " + author);
    }
}

// Main class
public class ECommerce {
    public static void main(String[] args) {
        System.out.println("=== Welcome to Our E-Commerce System ===");

        Electronics laptop = new Electronics("Gaming Laptop", 12000.00, 10, 24);
        Clothing jacket = new Clothing("Denim Jacket", 25.00, 50, "L");
        Book book = new Book("1984", 15.00, 100, "George Orwell");

        laptop.displayInfo();
        laptop.calculateTotalPrice();
        laptop.extendWarranty(12);
        System.out.println("-------------------------------------");

        jacket.displayInfo();
        jacket.calculateTotalPrice();
        jacket.tryOn();
        System.out.println("-------------------------------------");

        book.displayInfo();
        book.calculateTotalPrice();
        book.readPreview();
        System.out.println("=====================================");
    }
}
