package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will Chu on 1/20/2017
 */

@Autonomous(name="Auto Drive NO TURN And Shoot RED/Blue", group="147")
public class AutoDriveAndShoot extends AutoMode {

    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    @Override
    public void loop() {
        switch (state){

            case 0: // Bring Intake to Half Position
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Shooting ball
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 2: // Shooter Reset and Half Position For Intake and Moving to Center Vortex
                shooter.shooterDown();
                nextState(drive(3 * Single_Block_Distance * DEGREES_PER_INCH));
                break;

        }
    }
}
