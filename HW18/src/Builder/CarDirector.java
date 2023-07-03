package Builder;

// Директор будівельника автомобіля
public class CarDirector {
    public Car buildCar(CarBuilder carBuilder) {
        carBuilder.buildEngine();
        carBuilder.buildBody();
        carBuilder.buildWheels();
        return carBuilder.getCar();
    }
}
