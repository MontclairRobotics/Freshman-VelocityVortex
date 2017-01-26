package org.firstinspires.ftc.teamcode;

import android.graphics.YuvImage;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
/**
 * Created by Will Chu on 1/20/2017.
 */
@Autonomous(name="Auto Drive With TURN And Shoot Blue", group="147")
public class AutoDriveAndShootWithTurnBlue extends AutoMode {


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

            case 2: //intake half
                intake.intakeHalf();
                nextState(intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 3: // shoot
                shooter.shooterUp();
                nextState(shooter.isCloseTo(shooter.shooterUpPos));
                break;

            case 4: // shooter reset
                shooter.shooterDown();
                nextState(shooter.isCloseTo(shooter.shooterDownPos));
                break;

            case 5: // drive

            case 6: //telemetry
                telemetry.addData("INFO", "Last State Achieved");
                break;
        }
    }
}
