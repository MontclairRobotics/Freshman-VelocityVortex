package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/25/2017.
 */
@Autonomous(name = "Auto Shoot 2 RED/BLUE")
public class AutoShoot2 extends AutoMode{
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
            case 1: //shoot
                nextState(shoot());
                break;
            case 2: //intake up
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;
            case 3: //intake down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeUpPos));
                break;
            case 4: //wait
                nextState(pause(.3));
                break;
            case 6: //shoot
                nextState(shoot());
                break;
            case 7: //done
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
    }
}
