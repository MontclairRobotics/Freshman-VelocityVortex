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
            case 0: // Drive foward so center of robot is 24 in from wall
                nextState(drive(PART_BLOCK_DISTANCE));
                break;

            case 1: // Turn 90 Deg Right in The Same Place
                driveTrain.setRightTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90) && driveTrain.isCloseToRight(-TURN_DEGREE_90));
                break;

            case 2: // Drive Foward 2 blocks Distance (24 in)
                driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 3: // Turn 90 Deg Left in Same Place
                driveTrain.setLeftTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_90) && driveTrain.isCloseToRight(TURN_DEGREE_90));
                break;

            case 4: // Drive Backwards into Wall
                driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(-PART_BLOCK_DISTANCE));
                break;

            case 5: // Shoot and Intake 2nd Ball
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 6: // Shooter Reset and lower intake to half Position
                shooter.shooterDown();
                intake.intakeHalf();
                driveTrain.setDrivePosition(CORNER_VORTEX_DISTANCE_FROM_FAR_START * DEGREES_PER_INCH);
                break;
        }
    }
}
