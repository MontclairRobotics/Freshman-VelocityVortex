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
    Controller controller;
    @Override
    public void init() {
        telemetry.addData("INFO","Initialized");
        driveTrain = new DriveTrain();
        controller = new Controller();
        Controller.init(gamepad1, gamepad2);
    }

    @Override
    public void loop() {
        driveTrain.setDriveTank(controller.getRightPower(), controller.getLeftPower());
    }
}
