package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

@Autonomous(name="Auto Drive NO TURN And Shoot 2 RED/Blue", group="147")
public class AutoDriveAndShoot2 extends AutoMode {

    DriveTrain drivetrain;
    Intake intake;
    Shooter shooter;

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0:
                shooter.shooterUp();
                intake.intakeDown();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1:
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));
                break;

            case 2:
                shooter.shooterUp();
                intake.intakeHalf();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 3:
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4:
                drivetrain.setDrivePosition(Corner_Vortex_Distance_From_Start * DEGREES_PER_INCH);
                break;
        }
    }
}
