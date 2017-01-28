package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Created by Will on 1/20/2017.
 */

@Autonomous(name="Auto Drive WITH TURN Red", group="147")
public class AutoDriveWithTurnRed extends AutoMode {
    int AFTER_TURN_DISTANCE = 68;

    @Override
    public void init() {
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: // Drive Forward a single Block Distance
                driveTrain.setDrivePosition(SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseToLeft(SINGLE_BLOCK_DISTANCE) && driveTrain.isCloseToRight(SINGLE_BLOCK_DISTANCE));
                break;

            case 1: // Turn Left 45 Deg in same place
                telemetry.addData("INFO","Completed 0 State");
                driveTrain.setLeftTurnPosition(45);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_45) && driveTrain.isCloseToRight(TURN_DEGREE_45));
                break;

            case 2: // Drive and Park in Center Vortex
                telemetry.addData("INFO","Completed 1 State");
                nextState(drive(AFTER_TURN_DISTANCE*DEGREES_PER_INCH));
                break;

            case 3: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}

