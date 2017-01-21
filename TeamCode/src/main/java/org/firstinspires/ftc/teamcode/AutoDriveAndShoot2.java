package org.firstinspires.ftc.teamcode;

/**
 * Created by Will on 1/20/17.
 */

public class AutoDriveAndShoot2 extends AutoMode {

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

            case 0: shooter.shooterUp();
                intake.intakeDown();
                break;

            case 1:shooter.shooterDown();
                intake.intakeUp();
                break;

            case 2: shooter.shooterUp();
                intake.intakeHalf();
                break;

            case 3: shooter.shooterDown();
                break;

            case 4: drivetrain.setDrivePosition(Corner_Vortex_Distance_From_Start * DEGREES_PER_INCH);
                break;
        }
    }
}
