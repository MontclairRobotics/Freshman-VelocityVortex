package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

//Fixed
@Autonomous(name="Auto Drive NO TURN And Shoot 2 RED/Blue", group="147")
public class AutoDriveAndShoot2 extends AutoMode {


    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Intake Down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // Intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3: // intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 4: // Shoot particle
                nextState(shoot());
                break;

            case 5: //drive forward
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 6: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
