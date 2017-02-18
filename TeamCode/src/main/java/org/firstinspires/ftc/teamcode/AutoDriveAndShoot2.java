package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

@Autonomous(name="Auto Drive and shoot2 no turn RED/Blue", group="147")
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
                intake.setPos(intake.intakeDownPos);
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // Intake Particle
                intake.setPos(intake.intakeUpPos);
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;

            case 3:
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
            case 4: // Shoot Particle
                nextState(shoot());
                break;

            case 5: //drive forward
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));
                break;

            case 6: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
