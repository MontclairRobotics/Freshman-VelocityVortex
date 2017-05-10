package org.firstinspires.ftc.teamcode;

import com.kauailabs.navx.ftc.navXPIDController;

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
    public void start(){
            navx_device.zeroYaw();
        yawPIDResult = new navXPIDController.PIDResult();
    }
    @Override
    public void loop() {
        //Parameters (Speed, Distance, Angle)
        gyroDrive(1,SINGLE_BLOCK_DISTANCE,0);
        telemetry.addData("Moving",navx_device.isMoving());
    }
}
