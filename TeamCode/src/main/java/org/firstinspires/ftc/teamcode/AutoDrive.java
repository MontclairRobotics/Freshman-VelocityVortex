package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Created by Will on 1/20/2017.
 */

@Autonomous(name="Auto Drive NO TURN RED/Blue", group="147")
public class AutoDrive extends AutoMode {
        DriveTrain driveTrain;

    @Override
    public void init() {
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Start * DEGREES_PER_INCH);

                break;

        }
    }
}