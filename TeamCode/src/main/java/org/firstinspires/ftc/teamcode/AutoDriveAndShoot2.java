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

            case 0: // Lower intake
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1: // Shoot Ball
                telemetry.addData("INFO","Completed 0 State");
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 2: //Raise intake
                telemetry.addData("INFO","Completed 1 State");
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3: // Shooter Reset and intake reset
                telemetry.addData("INFO","Completed 2 State");
                shooter.shooterDown();
                intake.intakeHalf();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // Shoot ball
                telemetry.addData("INFO","Completed 3 State");
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 5: // reset shooter
                telemetry.addData("INFO","Completed 4 State");
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 6: //drive forward
                telemetry.addData("INFO","Completed 5 State");
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;

            case 7: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
