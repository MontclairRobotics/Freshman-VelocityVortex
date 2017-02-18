package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.vuforia.Type;

/**
 * Created by thegb on 2/11/2017.
 */


//TODO: Test
@Autonomous(name = "Auto Drive With TURN And Shoot 2 RED")
public class AutoDriveAndShoot2WithTurnRed extends AutoMode{

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch (state){

            case 0: //intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: //drive
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 2: //turn 45 deg left
                nextState(turn(Left45));
                break;

            case 3: //shoot
                nextState(shoot());
                break;

            case 4: //intake
                nextState(intake());
                break;

            case 5: //shoot
                nextState(shoot());
                break;

            case 6: // Park on center vortex
                nextState(drive(DISTANCE_AFTER_TURN2));
                break;

            case 7: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
