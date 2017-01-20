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
    public DcMotor intake;
    froshHardwareMap hwMap;
    int intakeUpPos = -100;
    int intakeDownPos = 1100;
    int intakeHalfPos = 0;
    public void init(froshHardwareMap hwMap){
        this.hwMap = hwMap;
        intake = this.hwMap.intakeMotor;
    }
    public void intakeUp(){
        intake.setTargetPosition(intakeUpPos);
    }
    public void intakeDown(){
        intake.setTargetPosition(intakeDownPos);
    }
    public void intakeHalf(){
        intake.setTargetPosition(intakeHalfPos);
    }
    public double getVals(){
        return intake.getCurrentPosition();
    }
    public void incrUp(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() + incr);
    }
    public void incrDown(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() - incr);
    }
}
