package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/18/2017.
 */

//works red only
@Autonomous(name = "Red Beacon Test", group = "147")
public class AutoTestBeaconRed extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(3);
    }
    int previousState = 0;
    @Override
    public void loop(){
        switch (state){
            /*case 0: //drive to wall
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            */case 1: // drive backwards
                nextState(drive(-2 * DEGREES_PER_INCH));
                break;
            case 2:
                nextState(pause(.2));
                break;
            case 3: //turn 60 deg left
                telemetry.addData("INFO", "Starting Turn");
                nextState(turn(Left90));
                break;

            case 4: //drive to line
                nextState(driveUntilLine());
                break;
            case 5:
                nextState(driveBackUntilLine());
                break;
            case 6: //beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 5;
                }else{
                    state = 26;
                    previousState = 5;
                }
                break;

            case 7: // drive backwards
                nextState(drive(-SINGLE_BLOCK_DISTANCE));
                break;

            case 8: //beacon
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 7;
                }else{
                    state = 26;
                    previousState = 7;
                }
                break;


            /* case 0: //beacon
                telemetry.addData("Beacon Color", "true");
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 1;
                }else{
                    state = 26;
                    previousState = 1;
                }
                telemetry.addData("Beacon Color", beaconRightColor);
                break;
            case 1:
                telemetry.addData("INFO", "Last State Achieved");
            //beacon pusher cases
            */
            case 22:
                telemetry.addData("State", state);
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
                telemetry.addData("State", state);
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
