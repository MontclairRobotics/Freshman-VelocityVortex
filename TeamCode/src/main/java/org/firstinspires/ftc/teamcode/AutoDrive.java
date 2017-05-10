package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/26/17.
 */


@Autonomous(name="Auto Drive", group="147")
public class AutoDrive extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
        navx_device.zeroYaw();
    }

    @Override
    public void start(){
        autoStart();
    }

    @Override
    public void loop() {
        switch(state){

            case 0: // Drive to center Vortex
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + HALF_BLOCK_DISTANCE));
                telemetry.addData("X", navx_device.getRawGyroX());
                telemetry.addData("Y", navx_device.getRawGyroY());
                telemetry.addData("Z", navx_device.getRawGyroZ());
                telemetry.addData("Moving",navx_device.isMoving());

                break;

            case 1: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
        updateTelemetry(telemetry);
    }
}
