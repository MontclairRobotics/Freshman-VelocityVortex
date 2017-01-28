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
            case 0: //drive
                nextState(drive(PART_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;

            case 1: // turn 45 deg right
                telemetry.addData("INFO","Completed 0 State");
                driveTrain.setRightTurnPosition(-TURN_DEGREE_45);
                driveTrain.setLeftTurnPosition(TURN_DEGREE_45);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_45) && driveTrain.isCloseToRight(-TURN_DEGREE_45));
                break;

            case 2: //drive
                telemetry.addData("INFO","Completed 1 State");
                nextState(drive(DISTANCE_BEFORE_SHOOTING));
                break;

            case 3: //intake half
                telemetry.addData("INFO","Completed 2 State");
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // shoot
                telemetry.addData("INFO","Completed 3 State");
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 5: // shooter reset
                telemetry.addData("INFO","Completed 4 State");
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 6: // drive
                telemetry.addData("INFO","Completed 5 State");
                nextState(drive(DISTANCE_AFTER_SHOOTING));
                break;

            case 7: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
