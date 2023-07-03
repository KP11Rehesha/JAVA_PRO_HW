package Strategy;

public class Main {
    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();


        areaCalculator.setStrategy(new RectangleAreaCalculationStrategy(5.0, 3.0));
        double rectangleArea = areaCalculator.calculateArea();
        System.out.println("Площа прямокутника: " + rectangleArea);


        areaCalculator.setStrategy(new TriangleAreaCalculationStrategy(4.0, 6.0));
        double triangleArea = areaCalculator.calculateArea();
        System.out.println("Площа трикутника: " + triangleArea);
    }
}

