package ObstacleParticipant.Obstacle;

import ObstacleParticipant.Participant.Participant;

public class Racetrack extends Obstacle{


    public Racetrack(int number, int parameters) {
        super(number, parameters);
    }

    @Override
    public void overcome(Participant participant) {
        if(participant.getRunlength()>parameters){
            System.out.println(participant.getName()+" overcame the racetrack №"+number);

        }
        else {

            System.out.println(participant.getName()+ " can`t overcame the racetrack №"+number);

        }
    }


}
