package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by willc on 1/28/2017.
 */


@Autonomous(name="Auto Beacon 1 Blue", group="147")
public class AutoBeaconBlue1 extends AutoMode {

    @Override
    public void init() {
        autoInit();
        setState(0);
    }

    @Override
    public void loop() {
        switch(state){
            case 0: //lower intake and push out beacon pusher
                intake.intakeDown();
                beaconPusher.pusherOut();
                nextState(intake.isCloseTo(intake.intakeDownPos) && beaconPusher.isCloseTo(beaconPusher.pusherOutPos));
                break;

            case 1: //shoot and retract beacon pusher
                shooter.shooterUp();
                beaconPusher.pusherIn();
                nextState(shooter.isCloseTo(shooter.shooterUpPos) && beaconPusher.isCloseTo(beaconPusher.pusherInPos));
                break;

            case 2: // reset shooter and raise intake
                shooter.shooterDown();
                intake.intakeUp();
                nextState(intake.isCloseTo(intake.intakeUpPos) && shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 3: //shoot
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 4: //reset shooter and half intake
                shooter.shooterDown();
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos) && shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 5: //drive 1 block distance\
                nextState(drive(SINGLE_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;

            case 6: //Turn 135 degs right
                driveTrain.setRightTurnPosition(-3 * TURN_DEGREE_45);
                driveTrain.setLeftTurnPosition(3 * TURN_DEGREE_45);
                nextState(driveTrain.isCloseToLeft(3 * TURN_DEGREE_45) && driveTrain.isCloseToLeft(-3 * TURN_DEGREE_45));
                break;

            case 7: // drive forward 6 block distance
                nextState(drive(6 * SINGLE_BLOCK_DISTANCE * DEGREES_PER_INCH));
                break;

            case 8: //drive backwards to beacon
                break;

            case 9: // run beacon choosing program
                break;

            case 10: //turn 135 deg
                driveTrain.setRightTurnPosition(3 * TURN_DEGREE_45);
                driveTrain.setLeftTurnPosition(-3 * TURN_DEGREE_45);
                nextState(driveTrain.isCloseToLeft(-3 * TURN_DEGREE_45) && driveTrain.isCloseToLeft(3 * TURN_DEGREE_45));
                break;

            case 11: //drive to center vortex
                break;

            case 12: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}       
