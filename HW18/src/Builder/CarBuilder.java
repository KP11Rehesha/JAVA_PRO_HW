package Builder;

// Будівельник автомобіля
public interface CarBuilder {
    void buildEngine();

    void buildBody();

    void buildWheels();

    Car getCar();
}
