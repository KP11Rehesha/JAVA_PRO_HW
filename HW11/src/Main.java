import coffee.order.CoffeeOrderBoard;
import coffee.order.Order;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("John");
        board.add("Jane");
        board.add("Jim");
        board.draw();
        System.out.println("Delivering order: " + board.deliver().getNumber());
        board.draw();
        System.out.println("Delivering order: " + board.deliver(3).getNumber());
        board.draw();
        System.out.println("Adding new order for Bob");
        board.add("Bob");
        board.draw();
    }
}