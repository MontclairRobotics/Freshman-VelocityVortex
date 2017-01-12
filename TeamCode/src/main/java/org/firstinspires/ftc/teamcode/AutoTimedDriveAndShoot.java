package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by Will on 1/11/17.
 */



@Autonomous(name="Auto Timed drive and Shoot", group="147")
@Disabled
public class AutoTimedDriveAndShoot extends LinearOpMode {

    /* Declare OpMode members. */
    froshHardwareMap robot   = new froshHardwareMap();   // Use a frosh Hardware map
    private ElapsedTime runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.75;
    int                     shooterStartPosition = 0  //start value for shooter
    int                     shootPosition = 1 //shoot value for shooter
    int                     intakeStartPosition =  0 //start value for intake
    int                     intakeIntakePosition= -500 //end value for intake

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Awaiting Command");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // intake ball and shoot
        robot.shooterMotor.setTargetPosition(shootPosition);
        wait(1);
        robot.shooterMotor.setTargetPosition(shooterStartPosition);
        robot.intakeMotor.setTargetPosition(intakeIntakePosition);
        wait(1);
        robot.shooterMotor.setTargetPosition(shootPosition);
        wait(1);
        robot.shooterMotor.setTargetPosition(shooterStartPosition);
        robot.intakeMotor.setTargetPosition(intakeStartPosition);

        //Driving to center vortex to park
        robot.leftMotorA.setPower(FORWARD_SPEED);
        robot.leftMotorB.setPower(FORWARD_SPEED);
        robot.rightMotorA.setPower(FORWARD_SPEED);
        robot.rightMotorB.setPower(FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 5.0)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }



        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
