package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

//TODO: Test
@Autonomous(name="Auto Drive NO TURN And Shoot 2 RED/Blue", group="147")
public class AutoDriveAndShoot2 extends AutoMode {


    @Override
    public void init() {
        setState(0);
        autoInit();
        intake.intakeHalf();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // Intake Particle
                nextState(intake());
                break;

            case 3: // Shoot Particle
                nextState(shoot());
                break;

            case 4: //drive forward
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance));
                break;

            case 6: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
