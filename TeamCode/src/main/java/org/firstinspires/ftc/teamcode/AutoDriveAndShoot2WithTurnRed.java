package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot 2 Red", group="147")
public class AutoDriveAndShoot2WithTurnRed extends AutoMode {

    //TODO: We need to calculate distances

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){
            case 0: //drive
                nextState(drive((PART_BLOCK_DISTANCE * DEGREES_PER_INCH)+ SINGLE_BLOCK_DISTANCE));
                break;

            case 1: //turn 45 deg left
                telemetry.addData("INFO","Completed 0 State");
                driveTrain.setRightTurnPosition(TURN_DEGREE_45);
                driveTrain.setLeftTurnPosition(-TURN_DEGREE_45);
                nextState(driveTrain.isCloseToLeft(-TURN_DEGREE_45) && driveTrain.isCloseToRight(TURN_DEGREE_45));
                break;

            case 2: //drive
                telemetry.addData("INFO","Completed 1 State");
                nextState(drive(DISTANCE_BEFORE_SHOOTING * DEGREES_PER_INCH));
                break;

            case 3: //intake down
                telemetry.addData("INFO","Completed 2 State");
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 4: //shoot
                telemetry.addData("INFO","Completed 3 State");
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 5: //shooter reset and intake up
                telemetry.addData("INFO","Completed 4 State");
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));
                break;

            case 6: // intake half\
                telemetry.addData("INFO","Completed 5 State");
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 7: //shoot
                telemetry.addData("INFO","Completed 6 State");
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 8: // shooter reset
                telemetry.addData("INFO","Completed 7 State");
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 9: // Park on center vortex
                telemetry.addData("INFO","Completed 8 State");
                nextState(drive(DISTANCE_AFTER_SHOOTING));
                break;

            case 10: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;        }
    }
}
