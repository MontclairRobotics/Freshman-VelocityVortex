package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */


//Fixed
@Autonomous(name="Auto Drive With TURN And Shoot 2 Blue", group="147")
public class AutoDriveAndShoot2WithTurnBlue extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){

            case 0: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 1: //turn 45 deg right
                nextState(turn(Right45));
                break;

            case 2: //intake Down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 3: //shoot
                nextState(shoot());
                break;

            case 4: //intake Up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 5: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));

            case 6: //shoot
                nextState(shoot());
                break;

            case 7: // Park on center vortex
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 8: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
