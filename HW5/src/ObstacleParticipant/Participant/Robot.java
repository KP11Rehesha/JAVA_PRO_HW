package ObstacleParticipant.Participant;

import ObstacleParticipant.Participant.Participant;

public class Robot extends Participant {


    public Robot(String name, int runlength, int jumpheight) {
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
