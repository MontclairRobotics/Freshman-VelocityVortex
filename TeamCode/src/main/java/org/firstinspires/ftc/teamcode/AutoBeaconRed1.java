package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 1/28/2017.
 */


@Autonomous(name="Auto Beacon 1 Red", group="147")
public class AutoBeaconRed1 extends AutoMode {

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

            case 6: //TODO: Add Turning 135 Degrees
                nextState(turn(135));
                break;

            case 7: //Drive Forward robot is parallel to wall and wheels guide the path
                nextState(drive(4 *SINGLE_BLOCK_DISTANCE));
                break;
            
            case 8: //TODO: ADD DRIVE TO BEACON USING WHEELS
                break;

            case 9:
                nextState(getColors());
                break;

            case 10: //TODO: TURN TOWARDS CENTER VORTEX
                nextState(turn(-135));
                break;

            case 11: //TODO: DRIVE TOWARDS TO CENTER VORTEX
                nextState(drive(DISTANCE_AFTER_TURN));
                break;

            case 12: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
