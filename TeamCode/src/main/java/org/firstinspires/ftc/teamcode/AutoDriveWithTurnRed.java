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
            case 0: driveTrain.setDrivePosition(SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseToLeft(SINGLE_BLOCK_DISTANCE) && driveTrain.isCloseToRight(SINGLE_BLOCK_DISTANCE));
                break;

            case 1: driveTrain.setLeftTurnPosition(45);
                nextState(driveTrain.isCloseToLeft(-45 * DEGREES_PER_INCH_CIRCLE) && driveTrain.isCloseToRight(45 * DEGREES_PER_INCH_CIRCLE));
                break;

            case 2: driveTrain.setDrivePosition( AFTER_TURN_DISTANCE * DEGREES_PER_INCH);

                break;

        }
    }
}
