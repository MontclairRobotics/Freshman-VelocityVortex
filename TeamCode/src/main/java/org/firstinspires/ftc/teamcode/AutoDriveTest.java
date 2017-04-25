package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/25/2017.
 */
@Autonomous(name="Auto Drive Line Test", group="147")
public class AutoDriveTest extends AutoMode{
    @Override
    public void init() {
        autoInit();
        setState(0);
        intake.intakeHalf();
    }

    @Override
    public void loop(){
        switch(state){
            case 0:
                telemetry.addData("Light Value", sensors.lightSensorC.getRawLightDetected());
                nextState(driveUntilLine());
                break;
            case 1:
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
        updateTelemetry(telemetry);
    }
}
