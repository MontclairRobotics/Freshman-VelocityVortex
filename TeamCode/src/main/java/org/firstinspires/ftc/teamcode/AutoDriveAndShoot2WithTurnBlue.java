package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */


//TODO: Test
@Autonomous(name="Auto Drive With TURN And Shoot 2 Blue", group="147")
public class AutoDriveAndShoot2WithTurnBlue extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
        intake.intakeHalf();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: //intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 2: //turn 45 deg right
                nextState(turn(Right45));
                break;

            case 3: //shoot
                nextState(shoot());
                break;

            case 4: //intake
                nextState(intake());
                break;

            case 5: //shoot
                nextState(shoot());
                break;

            case 6: // Park on center vortex
                nextState(drive(DISTANCE_AFTER_TURN2));
                break;

            case 7: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
