package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by thegb on 2/11/2017.
 */

// TODO: Test
@Autonomous(name = "Auto Drive With TURN And Shoot 1 Red")
public class AutoDriveAndShoot1WithTurnRed extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
        intake.intakeHalf();
    }
    @Override
    public void loop(){
        switch (state){

            case 0: //intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Drive Forward
                nextState(drive(SINGLE_BLOCK_DISTANCE));
                break;

            case 2: // Turn Left 45 Deg
                nextState(turn(Left45));
                break;

            case 3: //shoot
                nextState(shoot());
                break;

            case 4: // Drive to Center Vortex
                nextState(drive(DISTANCE_AFTER_TURN2));
                break;

            case 5: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
        updateTelemetry(telemetry);
    }
}
