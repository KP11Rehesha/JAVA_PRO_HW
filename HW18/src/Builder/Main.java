package Builder;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new ConcreteCarBuilder();
        CarDirector carDirector = new CarDirector();

        Car car = carDirector.buildCar(carBuilder);
        car.showInfo();
    }
}

