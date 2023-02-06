package ObstacleParticipant.Participant;

public class Cat extends Participant {


    public Cat(String name, int runlength, int jumpheight) {
        super(name, runlength, jumpheight);
    }

    @Override
    public void run() {
        System.out.println( getName()+" runs");
    }

    @Override
    public void jump() {
        System.out.println( getName()+" jumps");

    }
}
