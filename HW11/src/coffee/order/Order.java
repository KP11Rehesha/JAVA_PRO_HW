package coffee.order;

public class Order implements Comparable<Order> {
    private static int counter = 0;
    private int number;
    private String customerName;

    public Order(String customerName) {
        this.number = ++counter;
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public int compareTo(Order otherOrder) {
        return Integer.compare(this.number, otherOrder.number);
    }
}