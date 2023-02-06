package ObstacleParticipant.Participant;

public class Human extends Participant {


    public Human(String name, int runlength, int jumpheight) {
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
