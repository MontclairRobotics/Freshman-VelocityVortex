package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Garrett on 1/16/2017.
 */

@Autonomous(name="AutoDriveAndShoot", group="147")
public class AutoDriveAndShoot extends AutoMode {
    @Override
    public void init() {
        setState(0);
        autoInit();
        driveTrain.autoInit(hardware);
    }

    @Override
    public void loop() {
        switch (state){
            case 0:
                driveTrain.setDrivePosition(AUTO_DRIVE_1);
                nextState(driveTrain.getPos() == AUTO_DRIVE_1);
                break;
            case 1:

                break;
        }
    }
}
