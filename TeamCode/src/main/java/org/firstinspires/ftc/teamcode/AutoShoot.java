package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/25/2017.
 */

@Autonomous(name = "Auto Shoot Red/Blue")
public class AutoShoot extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
    }

    @Override
    public void loop(){
        switch (state){
            case 0: //intake half
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));
                break;
            case 1: //shoot
                nextState(shoot());
                break;
            case 2: //done
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
    }
}
