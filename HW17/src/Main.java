import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<Integer> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add(1);
        threadSafeList.add(2);
        threadSafeList.add(3);

        System.out.println("Elements in the list: " + threadSafeList.size());

        threadSafeList.remove(2);

        System.out.println("Elements in the list after removal: " + threadSafeList.size());

        Integer element = threadSafeList.get(0);
        System.out.println("First element in the list: " + element);

        PetrolStation petrolStation = new PetrolStation(100);
        Runnable refuelTask = () -> {
            int requestedAmount = (int) (Math.random() * 50 + 10);
            petrolStation.doRefuel(requestedAmount);
        };

        Thread thread1 = new Thread(refuelTask);
        Thread thread2 = new Thread(refuelTask);
        Thread thread3 = new Thread(refuelTask);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class PetrolStation {
    private int amount;
    private Lock lock;

    public PetrolStation(int initialAmount) {
        amount = initialAmount;
        lock = new ReentrantLock();
    }

    public void doRefuel(int requestedAmount) {
        lock.lock();
        try {
            if (requestedAmount <= amount) {
                System.out.println("Refueling " + requestedAmount + " liters");
                simulateRefueling();
                amount -= requestedAmount;
                System.out.println("Refueling completed");
            } else {
                System.out.println("Insufficient fuel");
            }
        } finally {
            lock.unlock();
        }
    }

    private void simulateRefueling() {
        try {
            Thread.sleep((long) (Math.random() * 8000 + 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
