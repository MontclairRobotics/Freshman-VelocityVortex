package org.firstinspires.ftc.teamcode;

/**
 * Created by garrett on 1/10/17.
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by Garrett on 1/10/17.
 */

public class Intake {
    DcMotor intake;
    HardwareMap hwMap;
    int intakeUpPos;
    int intakeDownPos;
    int intakeRegPos;
    public void init(HardwareMap hwMap){
        this.hwMap = hwMap;
        intake = this.hwMap.dcMotor.get("intake");
    }
    public void intakeUp(){
        intake.setTargetPosition(intakeUpPos);
    }
    public void intakeDown(){
        intake.setTargetPosition(intakeDownPos);
    }
    public void intakeReg(){
        intake.setTargetPosition(intakeRegPos);
    }
    public double getVals(){
        return intake.getCurrentPosition();
    }
    public void incrUp(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() + incr);
    }
    public void incrDown(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() + incr);
    }
    updateTelemetry(telemetry);
}
