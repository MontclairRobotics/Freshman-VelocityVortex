package org.firstinspires.ftc.teamcode;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will Chu on 1/20/2017
 */

public class AutoDriveAndShoot extends AutoMode {

    DriveTrain drivetrain;
    Intake intake;
    Shooter shooter;

    @Override
    public void init() {
        setState(0);

    }

    @Override
    public void loop() {
        switch (state){

            case 0:
                shooter.shooterUp();
                intake.intakeDown();
                break;

            case 1:
                shooter.shooterDown();
                intake.intakeHalf();
                break;

            case 2:
                drivetrain.setDrivePosition(Corner_Vortex_Distance_From_Start * DEGREES_PER_INCH);
                break;
        }
    }
}
