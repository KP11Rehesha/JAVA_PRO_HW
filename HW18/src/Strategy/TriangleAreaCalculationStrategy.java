package Strategy;

// Конкретна стратегія для обчислення площі трикутника
public class TriangleAreaCalculationStrategy implements AreaCalculationStrategy {
    private double base;
    private double height;

    public TriangleAreaCalculationStrategy(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
