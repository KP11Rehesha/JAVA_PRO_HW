package Strategy;

// Конкретна стратегія для обчислення площі прямокутника
public class RectangleAreaCalculationStrategy implements AreaCalculationStrategy {
    private double length;
    private double width;

    public RectangleAreaCalculationStrategy(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
