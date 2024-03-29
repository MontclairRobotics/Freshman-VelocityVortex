package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will Chu on 1/20/2017
 */

//Test
@Autonomous(name="Auto Drive Shoot 2", group="147")
public class AutoDriveShoot2 extends AutoMode {

    @Override
    public void init() {
        setState(0);
        autoInit();
    }


    @Override
    public void loop() {
        switch (state){

            case 0: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                pause(pauseTime);
                break;

            case 2: // intake Up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                pause(pauseTime);
                break;

            case 3: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                pause(pauseTime);
                break;

            case 4: // Shoot
                nextState(shoot());
                pause(pauseTime);
                break;

            case 5:// drive
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + HALF_BLOCK_DISTANCE));
                break;

            case 6: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
