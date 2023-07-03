package Factory;

// Конкретний клас стільця
public class Chair implements Furniture {
    @Override
    public void use() {
        System.out.println("Використовуємо стілець");
    }
}
