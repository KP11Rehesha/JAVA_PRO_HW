package ObstacleParticipant.Participant;

public abstract class Participant {

    private String name;
    private int runlength;
    private int jumpheight;

    public Participant(String name, int runlength, int jumpheight) {
        this.name = name;
        this.runlength = runlength;
        this.jumpheight = jumpheight;
    }

    public abstract void run();
    public abstract void jump();

    public String getName() {
        return name;
    }
    public int getRunlength() {
        return runlength;
    }

    public int getJumpheight() {
        return jumpheight;
    }
}
