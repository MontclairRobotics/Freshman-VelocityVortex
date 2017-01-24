package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot 2 Blue", group="147")
public class AutoDriveAndShoot2WithTurnBlue extends AutoMode {

    @Override
    public void init() {
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: // Driving So the Center of the robot is lined up with 24 inch from wall
                driveTrain.setDrivePosition(PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(PART_BLOCK_DISTANCE));
                break;

            case 1: // Turning 90 Deg right in place
                driveTrain.setRightTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90) && driveTrain.isCloseToRight(-TURN_DEGREE_90));
                break;

            case 2: // Driving Foward 2 Blocks(48 in)
                driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 3: // Turning 90 Deg Left in Place
                driveTrain.setLeftTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_90) && driveTrain.isCloseToRight(TURN_DEGREE_90));
                break;

            case 4: // Driving Backwards so robot is backed against wall
                driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(-PART_BLOCK_DISTANCE));
                break;

            case 5: // Shooting Ball and Intake 2nd Ball
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 6: // Shooter Reset and Intake Up Position
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));
                break;

            case 7: // Intake Lowered To Half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 8: // Shooting 2nd Ball
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 9: // Shooter Reset and Move to Center Vortex
                shooter.shooterDown();
                driveTrain.setDrivePosition(CORNER_VORTEX_DISTANCE_FROM_FAR_START * DEGREES_PER_INCH);
                break;
        }
    }
}
