package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/26/17.
 */


@Autonomous(name="Auto Drive No Turn Red/Blue", group="147")
public class AutoDrive extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){

            case 0: // Half Intake and wheels deployed
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos) && beacon());
                break;

            case 1: // Drive to center Vortex
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 2: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
        updateTelemetry(telemetry);
    }
}
