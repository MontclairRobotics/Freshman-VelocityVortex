package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will Chu on 02/01/17.
 */

//TODO: fix name for auto
@Autonomous(name="Auto Drive NO TURN RED/Blue", group="147")
public class AutoDriveTurnLeft extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){

            case 0: //Drive Forward 1 Block Distance and Intake Half
                nextState(drive(SINGLE_BLOCK_DISTANCE) && intake());
                break;

            case 1: //Turn Right 45 Deg
                break;

            case 2: // Drive to Center Vortex
                break;


            case 3: // Telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;

        }
    }
}
