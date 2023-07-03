package Factory;

// Конкретний клас столу
public class Table implements Furniture {
    @Override
    public void use() {
        System.out.println("Використовуємо стіл");
    }
}
