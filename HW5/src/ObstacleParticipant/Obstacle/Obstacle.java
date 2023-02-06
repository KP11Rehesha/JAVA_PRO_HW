package ObstacleParticipant.Obstacle;

import ObstacleParticipant.Participant.Participant;

public abstract class Obstacle {
    protected int number;
    protected int parameters;

    public Obstacle(int number, int parameters) {
        this.number = number;
        this.parameters = parameters;
    }


    public abstract void overcome(Participant participant);
}
