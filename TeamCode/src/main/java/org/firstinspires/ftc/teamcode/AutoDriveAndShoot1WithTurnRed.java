package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/11/2017.
 */

@Autonomous(name = "Auto Drive With TURN And Shoot 1 Red")
public class AutoDriveAndShoot1WithTurnRed extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
    }
    @Override
    public void loop(){
        switch (state){
            case 0:
                nextState(drive(SINGLE_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;
            case 1:
                nextState(turn(-45));
                break;
            case 2:
                nextState(shoot());
                break;
            case 4:
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;
            case 5:
                telemetry.addData("INFO", "Last State Acheived");
                break;
        }
    }
}
