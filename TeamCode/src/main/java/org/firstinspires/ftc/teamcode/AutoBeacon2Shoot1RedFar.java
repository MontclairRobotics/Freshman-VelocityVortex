package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by willc on 2/16/2017.
 */

//TODO: Test
@Autonomous(name="Auto 2 Beacon Shoot 2 Far Red", group="147")
public class AutoBeacon2Shoot1RedFar extends AutoMode {

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

            case 1: // drive
                nextState(drive(Half_Block_Distance));
                break;

            case 2: // turn
                nextState(turn(Left90));
                break;

            case 3: //drive
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));
                break;

            case 4: //turn
                nextState(turn(RBTA1));
                break;

            case 6: //drive
                nextState(drive(DISTANCE_AFTER_TURN3));
                break;

            case 7: //turn
                nextState(turn(RBTA2));
                break;

            case 8: //beacon
                nextState(getColors());
                break;

            case 9: //Drive to 2nd beacon
                nextState(drive(-2 * SINGLE_BLOCK_DISTANCE));
                break;

            case 10: //Push Beacon
                nextState(getColors());
                break;

            case 11: //turn
                nextState(turn(Right90));
                break;

            case 12: //shoot
                nextState(shoot());
                break;

            case 13: // drive
                nextState(drive(2 * SINGLE_BLOCK_DISTANCE + Half_Block_Distance)); ;
                break;


            case 15: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
