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

            case 0: // Intake Down and wheels deployed
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos) && beacon());
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // intake Up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // Shoot
                nextState(shoot());
                break;

            case 5:// drive
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 6: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
