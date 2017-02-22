package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/01/17.
 */


//TODO: Test
@Autonomous(name="Auto Drive Turn Blue", group="147")
public class AutoDriveTurnBlue extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){

            case 0: // Half Intake
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 2: //Turn Right 45 Deg
                nextState(turn(Right45));
                break;

            case 3: // Drive to Center Vortex
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 4: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
        updateTelemetry(telemetry);
    }
}