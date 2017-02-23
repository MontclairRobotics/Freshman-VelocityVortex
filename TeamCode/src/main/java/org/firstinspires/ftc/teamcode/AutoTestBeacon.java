package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/18/2017.
 */

//TODO: Test
@Autonomous(name = "Beacon Test", group = "147")
public class AutoTestBeacon extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
    }
    int previousState = 0;
    @Override
    public void loop(){
        switch (state){
            case 0: //beacon
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
