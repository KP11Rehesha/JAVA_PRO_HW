package coffee.order;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeOrderBoard {
    private Map<Integer, Order> orderMap;

    public CoffeeOrderBoard() {
        orderMap = new TreeMap<>();
    }

    public void add(String customerName) {
        Order order = new Order(customerName);
        orderMap.put(order.getNumber(), order);
    }

    public Order deliver() {
        Order nextOrder = orderMap.remove(orderMap.keySet().iterator().next());
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        Order targetOrder = orderMap.get(orderNumber);
        if (targetOrder == null) {
            return null;
        }
        Order nextOrder = orderMap.keySet().stream().filter(orderMapKey -> orderMapKey < orderNumber).map(orderMap::get).max(Order::compareTo).orElse(null);
        orderMap.remove(orderNumber);
        if (nextOrder != null) {
            orderMap.put(nextOrder.getNumber(), nextOrder);
        }
        return targetOrder;
    }

    public void draw() {
        System.out.println("Current Order Board:");
        orderMap.values().forEach(order -> System.out.println("Order " + order.getNumber() + " - " + order.getCustomerName()));
    }
}