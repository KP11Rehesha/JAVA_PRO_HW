import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    private String type;
    private double price;
    private boolean discountApplicable;
    private LocalDate dateAdded;


    public Product(String type, double price, boolean discountApplicable, LocalDate dateAdded) {
        this.type = type;
        this.price = price;
        this.discountApplicable = discountApplicable;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscountApplicable() {
        return discountApplicable;
    }

    public void setDiscountApplicable(boolean discountApplicable) {
        this.discountApplicable = discountApplicable;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 25, false, LocalDate.of(2023, 1, 1)));
        products.add(new Product("Book", 300, true, LocalDate.of(2023, 2, 1)));
        products.add(new Product("Book", 400, true, LocalDate.of(2023, 3, 1)));
        products.add(new Product("Pen", 100, true, LocalDate.of(2023, 4, 1)));

        // Завдання 1.2
        List<Product> expensiveBooks = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() > 250)
                .toList();
        System.out.println("Expensive Books: " + expensiveBooks);

        // Завдання 2.2
        List<Product> discountedBooks = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(Product::isDiscountApplicable)
                .peek(p -> p.setPrice(p.getPrice() * 0.9))
                .toList();
        System.out.println("Discounted Books: " + discountedBooks);

        // Завдання 3.2
        Product cheapestBook = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт [категорія: Book] не знайдено"));
        System.out.println("Cheapest Book: " + cheapestBook);

        // Завдання 4.2
        List<Product> lastThreeAddedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
        System.out.println("Last Three Added Products: " + lastThreeAddedProducts);

        // Завдання 5.2
        double totalCost = products.stream()
                .filter(p -> p.getDateAdded().getYear() == LocalDate.now().getYear())
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total Cost: " + totalCost);
    }
}