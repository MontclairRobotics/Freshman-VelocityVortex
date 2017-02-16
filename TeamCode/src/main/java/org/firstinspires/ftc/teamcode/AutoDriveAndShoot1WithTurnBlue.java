package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by WillC on 2/11/2017.
 */

// TODO: Test
@Autonomous(name = "Auto Drive With TURN And Shoot 1 Blue")
public class AutoDriveAndShoot1WithTurnBlue  extends AutoMode{
    @Override
    public void init(){
        autoInit();
        setState(0);
    }

    @Override
    public void loop(){
        switch (state){

            case 0: //intake Half
                intake.setPos(intake.intakeHalfPos);
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 1: // Drive Forward
                nextState(drive(Half_Block_Distance));
                break;

            case 2: // Turn Right 45 Deg
                nextState(turn(Right45));
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
    }
}
