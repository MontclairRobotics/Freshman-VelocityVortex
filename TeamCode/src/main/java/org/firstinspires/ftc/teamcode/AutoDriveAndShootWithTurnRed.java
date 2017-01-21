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

            case 0: driveTrain.setDrivePosition(PART_BLOCK_DISTANCE);
                break;

            case 1: driveTrain.setLeftTurnPosition(90);
                break;

            case 2: driveTrain.setDrivePosition(2 * SINGLE_BLOCK_DISTANCE);
                break;

            case 3: driveTrain.setRightTurnPosition(90);
                break;

            case 4: driveTrain.setDrivePosition(-PART_BLOCK_DISTANCE);
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
