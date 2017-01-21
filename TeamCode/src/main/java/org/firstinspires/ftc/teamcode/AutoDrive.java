package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

<<<<<<< HEAD
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
=======

/**
 * Created by Will on 1/20/2017.
 */

@Autonomous(name="Auto Drive NO TURN RED/Blue", group="147")
public class AutoDrive extends AutoMode {
        DriveTrain driveTrain;

    @Override
    public void init() {
        setState(0);
>>>>>>> 1ea27b4a014f2748421da3e4f6c9060fed999292
    }

    @Override
    public void loop() {
        switch (state){
            case 0:
<<<<<<< HEAD
                driveTrain.setDrivePosition(INCHES_TO_CORNER_VORTEX*DEGREES_PER_INCH);
=======
                driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Far_Start * DEGREES_PER_INCH);
>>>>>>> 1ea27b4a014f2748421da3e4f6c9060fed999292
                break;

        }
    }
}
