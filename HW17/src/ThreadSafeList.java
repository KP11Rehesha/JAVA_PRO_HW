import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {
    private List<T> list;
    private Lock lock;

    public ThreadSafeList() {
        list = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void add(T element) {
        lock.lock();
        try {
            list.add(element);
        } finally {
            lock.unlock();
        }
    }

    public void remove(T element) {
        lock.lock();
        try {
            list.remove(element);
        } finally {
            lock.unlock();
        }
    }

    public T get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return list.size();
        } finally {
            lock.unlock();
        }
    }
}
