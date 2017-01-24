package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

@Autonomous(name="Auto Drive NO TURN And Shoot 2 RED/Blue", group="147")
public class AutoDriveAndShoot2 extends AutoMode {


    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Shooting Ball and Intake 2nd Ball
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1: // Reset Shooter and Intake Up Position
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));
                break;

            case 2: // Shooting Ball and Intake half Position
                shooter.shooterUp();
                intake.intakeHalf();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 3: // Shooter Reset and Move to Center Vortex
                shooter.shooterDown();
                driveTrain.setDrivePosition(CORNER_VORTEX_DISTANCE_FROM_FAR_START * DEGREES_PER_INCH);
                break;

        }
    }
}
