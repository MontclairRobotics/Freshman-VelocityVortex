package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 4/27/2017.
 */

//TODO: Testing Required
@Autonomous(name="Auto Drive Shoot 2 (Blue Timer Side)", group="147")
public class AutoDriveShoot2TimerSideBlue extends AutoMode {

    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Drive Forward 1.5 Tiles
                nextState(drive(SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 1: //turn 135 Right
                nextState(turn(Right135));
                break;

            case 2: // Intake Down and wheels deployed
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos) &&  beacon());
                break;

            case 3: // Shoot
                nextState(shoot());
                break;

            case 4: //Intake Up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 5: // Intake Half
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 6:// Shoot
                nextState(shoot());
                break;

            case 7: //drive
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 8: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
