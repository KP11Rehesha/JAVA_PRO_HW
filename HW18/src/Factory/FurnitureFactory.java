package Factory;

// Фабричний клас для створення меблів
public class FurnitureFactory {
    public Furniture createFurniture(String type) {
        if (type.equalsIgnoreCase("table")) {
            return new Table();
        } else if (type.equalsIgnoreCase("chair")) {
            return new Chair();
        }
        return null;
    }
}
