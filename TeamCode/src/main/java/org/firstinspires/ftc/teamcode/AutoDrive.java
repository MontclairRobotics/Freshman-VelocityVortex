package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 01/19/17.
 */
@Autonomous(name="AutoDrive", group="147")
public class AutoDrive extends AutoMode {
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
                driveTrain.setDrivePosition(INCHES_TO_CORNER_VORTEX*DEGREES_PER_INCH);
                break;

        }
    }
}
