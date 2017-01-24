package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Montclair Robotics on 1/24/2017.
 */


@Autonomous(name="Test Auto", group = "147")
public class TestAuto extends AutoMode {
    @Override
    public void init(){

    }

    @Override
    public void loop(){
        switch (state){
            case 0:
                nextState(drive(2000));
                break;
            case 1:
                nextState(shoot());
                break;
            case 2:
                telemetry.addData("INFO", "Last State Acheived");
                break;

        }
    }
}
