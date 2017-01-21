package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Created by garrett on 1/9/17.
 */
@TeleOp(name="Teleop Competion", group="147")
public class teleop extends OpMode{
    DriveTrain driveTrain;
    froshHardwareMap hardware;
    Intake intake;
    Controller controller;
    BeaconPusher pusher;
    Shooter shooter;
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
        pusher = new BeaconPusher();
        pusher.init(hardware);
        intake.intakeHalf();
        shooter = new Shooter();
        shooter.init(hardware);
        telemetry.addData("INFO","Initialized");

    }

    @Override
    public void loop() {

        //Drive Controls
        float multiplier = 0.5f;
        if(controller.getRightBumper()){
            multiplier = 1;
        }else if(controller.getLeftBumper()){
            multiplier = 0.25f;
        }else {
            multiplier = 0.5f;
        }
        driveTrain.setDriveTank(controller.getRightPower(), controller.getLeftPower());



        //Beacon Pusher Controls
        if (controller.getButtonPressed("B")){
            pusher.pusherOut();
        }else{
            pusher.pusherIn();
        }



        //intake Controls
        boolean intaking = false;
        if (controller.getButtonPressed("Y")){
            intake.intakeDown();
            intaking = true;
        }else if(intaking){
            intake.intakeUp();
            if (intake.getVals() == intake.intakeUpPos){
                intaking = false;
            }
        }else{
            intake.intakeHalf();
        }



        //Shooter Controls
        if (controller.getButtonPressed("A")){
            shooter.shooterUp();
        }else if(shooter.isCloseTo(shooter.shooterUpPos)){
            shooter.shooterDown();
        }


        updateTelemetry(telemetry);
    }
}
