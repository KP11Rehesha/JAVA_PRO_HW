package Factory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory = new FurnitureFactory();


        Furniture table = furnitureFactory.createFurniture("table");
        table.use();


        Furniture chair = furnitureFactory.createFurniture("chair");
        chair.use();
    }

}

