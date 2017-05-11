package org.firstinspires.ftc.teamcode;

import com.kauailabs.navx.ftc.AHRS;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 5/10/2017.
 */

@Autonomous(name = "Test: Gyro", group = "147")
public class AutoTestGyro extends AutoMode{
    @Override
    public void init(){
        autoInit();
    }

    public void start(){
        autoStart();
    }

    @Override
    public void loop() {
        telemetry.addData("Yaw", navx_device.getYaw());
        telemetry.addData("Pitch", navx_device.getPitch());
        telemetry.addData("Roll", navx_device.getRoll());
        telemetry.addData("Temp", navx_device.getTempC()+273 + "k");

    }
}
