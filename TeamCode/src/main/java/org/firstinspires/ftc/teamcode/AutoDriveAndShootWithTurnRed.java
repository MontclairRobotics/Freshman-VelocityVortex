package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot RED", group="147")
public class AutoDriveAndShootWithTurnRed extends AutoMode {

    Intake intake;
    Shooter shooter;

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){


            case 0: // Drive foward so Center of the Robot is 24 in from Wall
                driveTrain.setDrivePosition(PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(PART_BLOCK_DISTANCE));
                break;

            case 1: // Turn Left 90 Deg in Place
                driveTrain.setLeftTurnPosition(90);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_90) && driveTrain.isCloseToRight(TURN_DEGREE_90));
                break;

            case 2: // Drive Foward 2 Blocks Distance (24 in)
                driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 3: // Turn Right 90 Deg in Same Place
                driveTrain.setRightTurnPosition(90);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_90) && driveTrain.isCloseToRight(-TURN_DEGREE_90));
                break;

            case 4: // Drive Back Against the Wall
                driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
                nextState(driveTrain.isCloseTo(-PART_BLOCK_DISTANCE));

                break;

            case 5: // Shoot Ball and Lower Intake
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 6: // Shooter Reset and intake Half Position
                shooter.shooterDown();
                intake.intakeHalf();
                driveTrain.setDrivePosition(Corner_Vortex_Distance_From_Far_Start * DEGREES_PER_INCH);
                break;

        }
    }
}
