package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 2/16/2017.
 */

//Ready for testing
@Autonomous(name="Auto 4 Beacon S Red", group="147")
public class Auto4BeaconShoot2RedVortexSide extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }
    int previousState = 0;
    @Override
    public void loop() {
        switch(state){
            case 0: //intake down and wheels deployed
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos) && beacon());
                break;

            case 1: //Shoot
                nextState(shoot());
                break;

            case 2: // intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: //Drive Forward 3 in
                nextState(drive(3 * DEGREES_PER_INCH));
                break;

            case 6: //Turn Left 45 deg
                nextState(turn(Left45));
                break;

            case 7: //Drive to forward tape
                nextState(driveUntilLine());
                break;

            case 8: //Turn 45 deg right
                nextState(drive(Right45));
                break;

            case 9: //get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 9;
                }else{
                    state = 26;
                    previousState = 9;
                }
                break;

            case 10: //drive forward to tape
                nextState(driveUntilLine());
                break;

            case 11: //get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 11;
                }else{
                    state = 26;
                    previousState = 11;
                }
                break;

            case 12: //drive forward Single Block distance + 9 in
                nextState(drive(SINGLE_BLOCK_DISTANCE + 9 * SINGLE_BLOCK_DISTANCE));
                break;

            case 13: // turn 90 Right
                nextState(turn(Right90));
                break;

            case 14: // drive forward to tape
                nextState(driveUntilLine());
                break;

            case 15: //get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 15;
                }else{
                    state = 26;
                    previousState = 15;
                }
                break;

            case 16: // drive to Forward tape
                nextState(driveUntilLine());
                break;

            case 17: //get beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 17;
                }else{
                    state = 26;
                    previousState = 17;
                }
                break;

            case 18: //turn 23 deg left
                nextState(turn(-23));
                break;

            case 19: //drive to corner vortex
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 20: // telemetry
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
