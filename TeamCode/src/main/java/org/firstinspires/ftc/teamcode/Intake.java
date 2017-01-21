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

    public int intakeTolerance = 50;
    int intakeUpPos = 200;
    int intakeDownPos = 1300;
    int intakeHalfPos = 400;

    public void init(froshHardwareMap hwMap){
        this.hwMap = hwMap;
        intake = this.hwMap.intakeMotor;
    }

    public void intakeUp(){
        intake.setPower(.5);
        intake.setTargetPosition(intakeUpPos);
    }

    public void intakeDown(){
        intake.setPower(.5);
        intake.setTargetPosition(intakeDownPos);
    }

    public void intakeReg() {
        intake.setPower(.5);
        intake.setTargetPosition(intakeHalfPos);
    }

    public void setPos(int pos){ intake.setTargetPosition(pos);}
    public double getVals(){
        return intake.getCurrentPosition();
    }
    public void incrUp(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() + incr);
    }
    public void incrDown(int incr){
        intake.setTargetPosition(intake.getCurrentPosition() - incr);
    }
    public boolean isCloseTo(double val) {
        return Math.abs(val - intake.getCurrentPosition()) < 5;
    }
    
}
