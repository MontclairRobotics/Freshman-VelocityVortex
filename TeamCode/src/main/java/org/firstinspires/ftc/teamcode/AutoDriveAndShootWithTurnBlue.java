package org.firstinspires.ftc.teamcode;

import android.graphics.YuvImage;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot Blue", group="147")
public class AutoDriveAndShootWithTurnBlue extends AutoMode {

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){
            case 0:
                nextState(drive(PART_BLOCK_DISTANCE));
                break;

            case 1: driveTrain.setRightTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90) && driveTrain.isCloseToRight(-TURN_DEGREE_90));
                break;

            case 2: driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 3: driveTrain.setLeftTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_90) && driveTrain.isCloseToRight(TURN_DEGREE_90));
                break;

            case 4: driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(-PART_BLOCK_DISTANCE));

                break;

            case 5: shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 6: shooter.shooterDown();
                intake.intakeHalf();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 7: driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Far_Start * DEGREES_PER_INCH);
                break;
        }
    }
}
