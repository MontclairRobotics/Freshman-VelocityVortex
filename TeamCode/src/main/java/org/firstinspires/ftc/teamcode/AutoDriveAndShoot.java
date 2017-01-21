package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will Chu on 1/20/2017
 */

@Autonomous(name="Auto Drive NO TURN And Shoot RED/Blue", group="147")
public class AutoDriveAndShoot extends AutoMode {

    DriveTrain drivetrain;
    Intake intake;
    Shooter shooter;

    @Override
    public void init() {
        setState(0);
        autoInit();
        driveTrain.autoInit(hardware);
    }

    @Override
    public void loop() {
        switch (state){
            case 0: shooter.shooterUp();
                    intake.intakeDown();
                    nextState(shooter.isCloseTo(shooter.shooterUpPos) && intake.isCloseTo(intake.intakeDownPos));
                break;
            case 1: shooter.shooterDown();
                    intake.intakeHalf();
                    nextState(shooter.isCloseTo(shooter.shooterDownPos) && intake.isCloseTo(intake.intakeHalfPos));
                break;

            case 2:
                drivetrain.setDrivePosition(Corner_Vortex_Distance_From_Far_Start * DEGREES_PER_INCH);
                break;
        }
    }
}
