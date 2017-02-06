package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Will on 1/20/17.
 */

@Autonomous(name="Auto Drive NO TURN And Shoot 2 RED/Blue", group="147")
public class AutoDriveAndShoot2 extends AutoMode {


    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Intake Half
                nextState(intake());
                break;

            case 1: // Shoot Particle
                nextState(shoot());
                break;

            case 2: // Intake Particle
                nextState(intake());
                break;

            case 3: // Shoot Particle
                nextState(shoot());
                break;

            case 6: //Drive to Center Vortex
                nextState(drive(3 * SINGLE_BLOCK_DISTANCE));
                break;

            case 7: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
