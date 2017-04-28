package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 4/27/2017.
 */

//TODO: Testing Required
@Autonomous(name="Auto Beacon (Red)", group="147")
public class AutoBeaconRed extends AutoMode {

    @Override
    public void init() {
        setState(0);
        autoInit();
    }
    int previousState = 0;
    @Override
    public void loop() {
        switch (state){

            case 0: // Drive Forward 2 in
                nextState(drive(2 * DEGREES_PER_INCH));
                break;

            case 1: //turn 45 left
                nextState(turn(Left45));
                break;

            case 2: //Drive until Line;
                telemetry.addData("Light Value", sensors.lightSensorC.getRawLightDetected());
                nextState(driveUntilLine());
                break;

            case 3: //turn 45 right
                nextState(turn(45));
                break;

            case 4: //beacon
                telemetry.addData("Beacon Color", "true");
                getColors();
                if (beaconRightColor.equals("BLUE")){
                    state = 22;
                    previousState = 0;
                }else{
                    state = 26;
                    previousState = 0;
                }
                telemetry.addData("Beacon Color", beaconRightColor);
                break;

            case 5:
                telemetry.addData("INFO", "Last State Achieved");



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
