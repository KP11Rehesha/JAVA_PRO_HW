package ObstacleParticipant.Obstacle;

import ObstacleParticipant.Participant.Participant;

public class Wall extends Obstacle{


    public Wall(int number, int parameters) {
        super(number, parameters);
    }

    @Override
    public void overcome(Participant participant) {
        if(participant.getJumpheight()>parameters){
            System.out.println(participant.getName()+" overcame the wall №"+number);

        }
        else {
            System.out.println(participant.getName()+ " can`t overcame the wall №"+number);
        }
    }

}
