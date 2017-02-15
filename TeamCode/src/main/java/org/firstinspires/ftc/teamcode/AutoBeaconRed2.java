package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 1/28/2017.
 */

//TODO: test
@Autonomous(name="Auto Beacon 2 Red", group="147")
public class AutoBeaconRed2 extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){
            case 0: //Intake Half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));

            case 1: //Shoot
                nextState(shoot());
                break;

            case 2: // Intake and Deploy Wheels
                nextState(intake() && beacon());
                break;

            case 3: //Shoot
                nextState(shoot());
                break;

            case 4: //Drive Forward One Block
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 6: //Turn 45 deg right
                nextState(turn(Left45));
                break;

            case 7: //drive to beacon
                nextState(drive(DistanceToFarBeacon));
                break;

            case 8:
                nextState(getColors());
                break;

            case 10: //drive to 2nd beacon
                nextState(drive(-BeaconDistance));
                break;

            case 11: //turn 90 deg left
                nextState(turn(2 * Right45));
                break;

            case 12: //drive to Center Vortex
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));

            case 13: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}