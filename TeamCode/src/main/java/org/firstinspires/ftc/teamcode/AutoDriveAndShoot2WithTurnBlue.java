package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive and shoot 2 with turn Blue", group="147")
public class AutoDriveAndShoot2WithTurnBlue extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: //intake down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;
            case 1: // intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;
            case 2: //drive //// TODO: get more exact measurments
                nextState(drive(SINGLE_BLOCK_DISTANCE + SINGLE_BLOCK_DISTANCE));
                break;
            case 3: //turn 45 deg right
                nextState(turn(45));
                break;
            case 4: //drive //// TODO: 2/4/2017 get more exact measurements
                nextState(drive(SINGLE_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;
            case 5: //shoot
                nextState(shoot());
                break;
            case 6: //intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;
            case 7: //shoot
                nextState(shoot());
                break;
            case 8: // Park on center vorter
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;
            case 9: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
