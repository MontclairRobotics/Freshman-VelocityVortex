package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by willc on 2/16/2017.
 */

//TODO: Test
@Autonomous(name="Auto 2 Beacon Shoot 2 Far Blue", group="147")
public class AutoBeacon2Shoot1BlueFar extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }
    int previousState = 0;

    @Override
    public void loop() {
        switch(state){
            case 0: //Intake Half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));

            case 1: // drive
                nextState(drive(Half_Block_Distance));
                break;

            case 2: // turn
                nextState(turn(Right90));
                break;

            case 3: //drive
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));
                break;

            case 4: //turn
                nextState(turn(BBTA1));
                break;

            case 6: //drive
                nextState(drive(DISTANCE_AFTER_TURN3));
                break;

            case 7: //turn
                nextState(turn(BBTA2));
                break;

            case 8: //beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 10;
                }else{
                    state = 26;
                    previousState = 10;
                }
                break;

            case 9: //Drive to 2nd beacon
                nextState(drive(-2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 10: //Push Beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 10;
                }else{
                    state = 26;
                    previousState = 10;
                }
                break;

            case 11: //turn
                nextState(turn(Left90));
                break;

            case 12: //shoot
                nextState(shoot());
                break;

            case 13: // drive
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance)); ;
                break;


            case 15: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

            //beacon pusher cases
            case 22:
                nextState(drive(rightBeaconDistance));
                break;
            case 23:
                nextState(beacon());
                break;
            case 24:
                nextState(drive(-rightBeaconDistance));
                break;
            case 25:
                state = previousState + 1;
                break;

            case 26:
                nextState(drive(leftBeaconDistance));
                break;
            case 27:
                nextState(beacon());
                break;
            case 28:
                nextState(drive(-leftBeaconDistance));
                break;
            case 29:
                state = previousState + 1;
                break;
        }
    }
}
