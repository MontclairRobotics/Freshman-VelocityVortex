package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/25/2017.
 */

@Autonomous(name = "Auto Shoot 2 Red", group = "147")
public class AutoTurnAndShoot2Red extends AutoMode {
    @Override
    public void init(){
        autoInit();
        setState(0);
    }

    @Override
    public void loop(){
        switch (state){
            case 0: //intake down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;
            case 1: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;
            case 2: //drive forward
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;
            case 3: //turn
                nextState(turn(-45));
                break;
            case 4: //shoot
                nextState(shoot());
                break;
            case 5: //intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;
            case 6: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;
            case 7: // shoot
                nextState(shoot());
                break;
            case 8: // donee
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
    }
}
