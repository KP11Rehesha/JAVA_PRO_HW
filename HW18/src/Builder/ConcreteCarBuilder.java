package Builder;

// Конкретний будівельник автомобіля
public class ConcreteCarBuilder implements CarBuilder {
    private Car car;

    public ConcreteCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Дизельний двигун");
    }

    @Override
    public void buildBody() {
        car.setBody("Седан");
    }

    @Override
    public void buildWheels() {
        car.setWheels("16-дюймові легкосплавні колеса");
    }

    @Override
    public Car getCar() {
        return car;
    }
}
