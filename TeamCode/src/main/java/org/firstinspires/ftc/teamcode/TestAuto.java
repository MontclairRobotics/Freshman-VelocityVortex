package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Montclair Robotics on 1/24/2017.
 */


@Autonomous(name="Test Auto", group = "147")
public class TestAuto extends AutoMode {
    @Override
    public void init(){
        autoInit();
        setState(0);
    }

    @Override
    public void loop(){
        switch (state){
            case 0:
                nextState(turn(360));
                break;

        }
        updateTelemetry(telemetry);
    }
}
