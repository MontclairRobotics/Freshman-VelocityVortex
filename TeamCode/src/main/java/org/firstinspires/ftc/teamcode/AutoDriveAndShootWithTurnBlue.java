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
                driveTrain.setRightTurnPosition(-TURN_DEGREE_45);
                driveTrain.setLeftTurnPosition(TURN_DEGREE_45);
                nextState(driveTrain.isCloseToLeft(TURN_DEGREE_45) && driveTrain.isCloseToRight(-TURN_DEGREE_45));
                break;

            case 2: //drive
                nextState(drive(DISTANCE_BEFORE_SHOOTING));
                break;

            case 3: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // shoot
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 5: // shooter reset
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 6: // drive
                nextState(drive(DISTANCE_AFTER_SHOOTING));
                break;

            case 7: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
