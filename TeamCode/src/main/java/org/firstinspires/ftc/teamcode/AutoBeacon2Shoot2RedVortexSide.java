package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by willc on 2/16/2017.
 */

//TODO: Test New
@Autonomous(name="Auto 2 Beacon Shoot 2 Red Vortex Side", group="147")
public class AutoBeacon2Shoot2RedVortexSide extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }
    int previousState = 0;
    @Override
    public void loop() {
        switch(state){

            case 0: //Intake Down and Beacon pusher
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos) && beacon());
                break;

            case 1:// shoot
                nextState(shoot());
                break;

            case 2://intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3://intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4://drive forward 1 block
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 5:// turn 45 deg left
                nextState(turn(Left45));
                break;

            case 6:// drive forward 2.5 root 2 blocks
                nextState(drive(DISTANCE_AFTER_TURN3));
                break;

            case 7:// turn 45 deg left
                nextState(turn(Left45));
                break;

            case 8:// drive forward single block distance
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 9: // drive backwards single block distance
                nextState(drive(-SINGLE_BLOCK_DISTANCE));
                break;

            case 10: //turn left 60 deg
                nextState(turn(Left60));
                break;

            case 11:// beacon drive 1 root 2 blocks
                nextState(beaconDrive(DISTANCE_AFTER_TURN2) && driveUntilLine());
                break;

            case 12: // get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 12;
                }else{
                    state = 26;
                    previousState = 12;
                }
                break;

            case 13: //beacon drive backwards
                nextState(beaconDrive(-SINGLE_BLOCK_DISTANCE) && driveUntilLine());
                break;

            case 14: //get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 12;
                }else{
                    state = 26;
                    previousState = 12;
                }
                break;

            case 15: //drive to corner vortex
                nextState(drive(5 * SINGLE_BLOCK_DISTANCE));
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
        updateTelemetry(telemetry);
    }
}
