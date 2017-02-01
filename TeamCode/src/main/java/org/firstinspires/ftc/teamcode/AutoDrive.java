package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 01/19/17.
 */


@Autonomous(name="Auto Drive NO TURN RED/Blue", group="147")
public class AutoDrive extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){
            case 0:
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));
                break;
            case 1:
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
    }
}
