import Geometry.Circle;
import Geometry.Shape;
import Geometry.Square;
import Geometry.Triangle;
import ObstacleParticipant.Obstacle.Obstacle;
import ObstacleParticipant.Obstacle.Racetrack;
import ObstacleParticipant.Obstacle.Wall;
import ObstacleParticipant.Participant.Human;
import ObstacleParticipant.Participant.Participant;
import ObstacleParticipant.Participant.Robot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Shape circle = new Circle();
        Shape square = new Square();

        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(triangle);
        shapes.add(circle);
        shapes.add(square);

        for (Shape s : shapes) {
            System.out.println(s.getarea());
        }
        System.out.println("Sum = " + Summary(shapes));
        System.out.println("______________________________________________________\n");




        Participant sasha = new Human("Sasha", 10,10);
        Participant robot1 = new Robot("Robot1", 50,50);
        List<Participant> participants = new ArrayList<Participant>();
        participants.add(sasha);
        participants.add(robot1);

        sasha.run();
        sasha.jump();

        System.out.println("");

        Obstacle wall1 = new Wall(1,1);
        Obstacle racetrack1 = new Racetrack(1,11);
        Obstacle wall2 = new Wall(2,2);

        List<Obstacle> obstacles = new ArrayList<Obstacle>();
        obstacles.add(wall1);
        obstacles.add(racetrack1);
        obstacles.add(wall2);

        for (Obstacle O:obstacles ) {
            for (Participant P:participants) {
                O.overcome(P);
            }
        }

    }

    public static int Summary(List<Shape> shapes) {
        int total = 0;
        for (Shape s : shapes) {
            total += s.getarea();
        }
        return total;
    }
}