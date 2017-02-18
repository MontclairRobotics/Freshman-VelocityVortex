package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will Chu on 1/20/2017
 */

//TODO: Works
@Autonomous(name="Auto Drive NO TURN And Shoot RED/Blue", group="147")
public class AutoDriveAndShoot extends AutoMode {

    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // Drive to Center Vortex
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 3: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
