package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot 2 Red", group="147")
public class AutoDriveAndShoot2WithTurnRed extends AutoMode {

    //TODO: We need to calculate distances

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0: //drive
                nextState(drive(PART_BLOCK_DISTANCE * DEGREES_PER_INCH));

            case 1: //turn

            case 2: //intake down
                intake.intakeDown();
                nextState(intake.isCloseTo(intake.intakeDownPos));

            case 3: //shoot
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));

            case 4: //shooter reset and intake up
                shooter.shooterDown();
                intake.intakeUp();
                nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeUpPos));

            case 5: // intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));

            case 6: //shoot
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));

            case 7: // shooter reset
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));

            case 8: // Park on center vorter

            case 9: // telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
