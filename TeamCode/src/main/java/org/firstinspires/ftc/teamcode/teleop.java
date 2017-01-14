package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;


/**
 * Created by garrett on 1/9/17.
 */
@TeleOp(name="Teleop", group="Freshman147")
public class teleop extends OpMode{
    DriveTrain driveTrain;
    froshHardwareMap hardware;
    Intake intake;
    Controller controller;
    @Override
    public void init() {
        hardware = new froshHardwareMap();
        hardware.init(hardwareMap);
        driveTrain = new DriveTrain();
        driveTrain.init(hardware);
        controller = new Controller();
        controller.init(gamepad1, gamepad2);
        intake = new Intake();
        intake.init(hardware);
        telemetry.addData("INFO","Initialized");
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
        updateTelemetry(telemetry);
    }
}
