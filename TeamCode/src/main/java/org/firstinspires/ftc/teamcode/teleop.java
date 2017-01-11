package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


/**
 * Created by garrett on 1/9/17.
 */
@TeleOp
public class teleop extends OpMode{
    DriveTrain driveTrain;
    Intake intake;
    Controller controller;
    @Override
    public void init() {
        telemetry.addData("INFO","Initialized");
        driveTrain = new DriveTrain();
        controller = new Controller();
        intake = new Intake();
        Controller.init(gamepad1, gamepad2);
    }

    @Override
    public void loop() {
        driveTrain.setDriveTank(controller.getRightPower(), controller.getLeftPower());
        boolean intaking = false;
        if (controller.getButtonPressed("Y")){
            intake.intakeDown();
        }else if(intaking){
            intaking = true;
            intake.intakeUp();
        }else{
            intake.intakeReg();
        }
        if (controller.dpad("UP")) {
            intake.incrUp(10);
            telemetry.addData("INFO", "Intake Position " + intake.getVals());
        }
        if (controller.dpad("Down")) {
            intake.incrDown(10);
            telemetry.addData("INFO", "Intake Position " + intake.getVals());
        }
    }
}
