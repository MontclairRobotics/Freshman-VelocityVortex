package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/25/2017.
 */

@Autonomous(name = "Auto Shoot Red", group = "147")
public class AutoTurnAndShootRed extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
    }

    @Override
    public void loop(){
        switch (state){
            case 0: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;
            case 1: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;
            case 2: //turn
                nextState(turn(-45));
                break;
            case 3: //shoot
                nextState(shoot());
                break;
            case 4: //done
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
    }
}
