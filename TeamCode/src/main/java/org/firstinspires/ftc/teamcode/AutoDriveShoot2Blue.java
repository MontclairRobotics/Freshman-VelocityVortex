package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/01/17.
 */


//Fixed
@Autonomous(name="Auto Drive Shoot 2 Blue", group="147")
public class AutoDriveShoot2Blue extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
        intake.intakeHalf();
    }

    @Override
    public void loop() {
        switch(state){

            case 0: // drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 1: //turn
                nextState(turn(Right45));
                break;

            case 2: //intake
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 3: //shoot
                nextState(shoot());
                break;

            case 4: // intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 5: // intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 6: //shoot
                nextState(shoot());
                break;

            case 7: //drive
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 8: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
        updateTelemetry(telemetry);
    }
}
