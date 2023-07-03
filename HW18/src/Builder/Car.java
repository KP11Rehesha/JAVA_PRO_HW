package Builder;

public class Car {
    private String engine;
    private String body;
    private String wheels;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void showInfo() {
        System.out.println("Двигун: " + engine);
        System.out.println("Кузов: " + body);
        System.out.println("Колеса: " + wheels);
    }
}
