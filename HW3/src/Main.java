import Carclass.Car;
import employeeclass.Employee;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Sasha", "Rehesha","Mikolayovich","Developer","regeshao@gmail.com",18,"+380976253333");
        System.out.println(employee.getName());
        Car car = new Car();
        car.start();
    }
}