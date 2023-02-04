package Carclass;

public class Car {
    public void start(){
        startElectricity();
        startCommand();
        startFuelSystem();
    }
    private void startElectricity(){
        System.out.println("Electricity started");
    }
    private void startCommand(){
        System.out.println("Command started");
    }
    private void startFuelSystem(){
        System.out.println("Fuel System started");
    }
}
