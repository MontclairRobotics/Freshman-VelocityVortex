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
        gyroTurn(Left45);
        driveTrain.setDrivePosition(SINGLE_BLOCK_DISTANCE);
        telemetry.addData("Moving",navx_device.isMoving());
    }
}
