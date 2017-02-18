package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 1/28/2017.
 */

//TODO: Test
@Autonomous(name="Auto 2 Beacon Shoot 1 Blue", group="147")
public class AutoBeacon2Shoot2Blue extends AutoMode {

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

            case 1: //Shoot
                nextState(shoot());
                break;

            case 2: // Intake and Deploy Wheels
                nextState(intake() && beacon());
                break;

            case 3: //Shoot
                nextState(shoot());
                break;

            case 4: //Drive Forward One Block
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 6: //Turn Right 45 deg
                nextState(turn(Right45));
                break;

            case 7: //Drive Foward robot is parallel to wall and wheels guide the path
                nextState(drive(DistanceBeforeBeacon));
                break;

            case 8: //Turn 45 deg left
                nextState(turn(Left45));
                break;

            case 9: //Drive Forward to Beacon
                nextState(drive(SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
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

            case 11: //Drive Backwards to beacon
                nextState(drive(SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 12: //push Beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 10;
                }else{
                    state = 26;
                    previousState = 10;
                }
                break;

            case 13: // turn Left 90 Deg
                nextState(turn(2 * Left45));
                break;

            case 14: // Drive to Center vortex
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));

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
