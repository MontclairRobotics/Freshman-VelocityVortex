package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 1/20/2017.
 */

//TODO: test
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
            case 0: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 2: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 3: //turn 45 deg right
                nextState(turn(Right45));
                break;

            case 5: //shoot
                nextState(shoot());
                break;

            case 6: //intake
                nextState(intake());
                break;

            case 7: //shoot
                nextState(shoot());
                break;
            case 8: // Park on center vortex
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 9: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
