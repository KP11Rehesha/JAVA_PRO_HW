package Strategy;

// Клас, який використовує стратегію обчислення площі
public class AreaCalculator {
    private AreaCalculationStrategy strategy;

    public void setStrategy(AreaCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateArea() {
        if (strategy != null) {
            return strategy.calculateArea();
        }
        return 0.0;
    }
}
