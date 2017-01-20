package org.firstinspires.ftc.teamcode;

/**
 * Created by Will on 1/20/2017.
 */

public class AutoDrive extends AutoMode {
        DriveTrain driveTrain;
        froshHardwareMap hardware;

    @Override
    public void init() {
        setState(0);
        driveTrain = new DriveTrain();
        driveTrain.init(hardware);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Start * DEGREES_PER_INCH);

                break;
        }
    }
}