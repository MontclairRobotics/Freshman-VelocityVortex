package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot 2 Blue", group="147")
public class AutoDriveAndShoot2WithTurnRed extends AutoMode {

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Drive Foward so Center of Robot is at 24 inches from wall
                driveTrain.setDrivePosition(PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(PART_BLOCK_DISTANCE));
                break;

            case 1: // Turn 90 Deg Left in Place
                driveTrain.setLeftTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_90) && driveTrain.isCloseToRight(TURN_DEGREE_90));
                break;

            case 2: // Drive Foward 2 Block Distance(24 in)
                driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 3: // Turn 90 Deg Right in Place
                driveTrain.setRightTurnPosition(TURN_DEGREE_90);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90) && driveTrain.isCloseToRight(-TURN_DEGREE_90));
                break;

            case 4: //  Drive Backwards into wall
                driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(-PART_BLOCK_DISTANCE));
                break;

            case 5: //shooting Ball and Intake 2nd Ball
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 6: //Shooter Reset and Intake up
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));
                break;

            case 7: // Shooting 2nd Ball and Intake raised to half
                shooter.shooterUp();
                intake.intakeHalf();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 8:// Shooter reset and Drive to Corner Vortex
                shooter.shooterDown();
                driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Far_Start * DEGREES_PER_INCH);
                break;

        }
    }
}
