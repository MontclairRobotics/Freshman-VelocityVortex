package org.firstinspires.ftc.teamcode;

/**
 * Created by Will on 5/5/2017.
 */

public class AutoDriveGyro extends AutoMode{
    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    @Override
    public void loop() {
        switch(state){
            case 1:
                gyroDrive(1,SINGLE_BLOCK_DISTANCE,0);
                telemetry.addData("Moving",navx_device.isMoving());
                break;
        }
    }
}
