package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


/**
 * Created by Will on 1/20/2017.
 */

@Autonomous(name="Auto Drive WITH TURN Blue", group="147")
public class AutoDriveWithTurnBlue extends AutoMode {
    int AFTER_TURN_DISTANCE = 68;

    @Override
    public void init() {
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Drive Single Block Distance
                driveTrain.setDrivePosition(SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(SINGLE_BLOCK_DISTANCE));
                break;

            case 1: // Turn Right 45 Degree in place
                driveTrain.setRightTurnPosition(45);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90/2) && driveTrain.isCloseToRight(-TURN_DEGREE_90/2));
                break;

            case 2: // Drive and Park on Corner Vortex
                driveTrain.setDrivePosition( AFTER_TURN_DISTANCE * DEGREES_PER_INCH);
                break;

        }
    }
}
