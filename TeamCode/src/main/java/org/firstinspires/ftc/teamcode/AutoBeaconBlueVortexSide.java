package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/26/17.
 */


@Autonomous(name="Auto Beacon Blue Vortex Side", group="147")
public class AutoBeaconBlueVortexSide extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    int previousState = 0;
    @Override
    public void loop() {
        switch(state){

            case 0: // Intake Down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // intake Up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // Shoot
                nextState(shoot());
                break;

            case 5: // drive forward 3 in
                nextState(drive(3 * DEGREES_PER_INCH));
                break;

            case 6: //turn 45 deg right
                nextState(turn(Right45));
                break;

            case 7: // drive until line
                nextState(driveUntilLine());
                break;

            case 8: //drive back to line
                nextState(driveBackUntilLine());
                break;

            case 9: //get colors
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 26;
                    previousState = 9;
                }else{
                    state = 22;
                    previousState = 9;
                }
                break;

            case 10://drive 2 2nd beacon
                nextState(beaconDrive(SINGLE_BLOCK_DISTANCE));
                break;

            case 11: // get colors
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 26;
                    previousState = 11;
                }else{
                    state = 22;
                    previousState = 11;
                }
                break;

            case 12: // turn
                nextState(turn(Right45/3));
                break;

            case 13://drive to corner vortex
                nextState(drive(-3 * SINGLE_BLOCK_DISTANCE));
                break;

            case 14: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;



            //Beacon Pusher Cases
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
