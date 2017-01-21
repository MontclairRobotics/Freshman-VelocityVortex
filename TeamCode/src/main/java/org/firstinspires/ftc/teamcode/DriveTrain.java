package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by garrett on 12/8/16.
 */

public class DriveTrain {
    froshHardwareMap hwMap;
    public DcMotor[][] motors=new DcMotor[2][2];
    public void init(froshHardwareMap hwMap){
        this.hwMap = hwMap;
        motors[0][0]  = hwMap.leftMotorA;
        motors[0][1]  = hwMap.leftMotorB;
        motors[1][0]  = hwMap.rightMotorA;
        motors[1][1]  = hwMap.rightMotorB;
        for(int i = 0; i < motors.length; i++){
            for(int j = 0; j <motors[0].length; j++) {
                motors[i][j].setPower(0);
                motors[i][j].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                motors[i][j].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }
        }
    }
    public void setDriveTank(double right, double left){
        for(int i = 0; i < motors[0].length; i++){
            motors[0][i].setPower(left);
            motors[1][i].setPower(right);
        }
    }
    public void autoInit(froshHardwareMap hwMap){
        this.hwMap = hwMap;
        motors[0][0]  = hwMap.leftMotorA;
        motors[0][1]  = hwMap.leftMotorB;
        motors[1][0]  = hwMap.rightMotorA;
        motors[1][1]  = hwMap.rightMotorB;
        for(int i = 0; i < motors.length; i++){
            for(int j = 0; j <motors[0].length; j++) {
                motors[i][j].setPower(0);
                motors[i][j].setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motors[i][j].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }
        }
    }
<<<<<<< HEAD
=======

>>>>>>> 1ea27b4a014f2748421da3e4f6c9060fed999292
    public void setDrivePosition(int position){
        motors[0][0].setTargetPosition(position);
        motors[0][1].setTargetPosition(position);
        motors[1][0].setTargetPosition(position);
        motors[1][1].setTargetPosition(position);
    }

    public void setLeftTurnPosition(int position){
        motors[0][0].setTargetPosition(-1*position);
        motors[0][1].setTargetPosition(-1*position);
        motors[1][0].setTargetPosition(position);
        motors[1][1].setTargetPosition(position);
    }

    public void setRightTurnPosition(int position){
        motors[0][0].setTargetPosition(position);
        motors[0][1].setTargetPosition(position);
        motors[1][0].setTargetPosition(-1*position);
        motors[1][1].setTargetPosition(-1*position);
    }

    public int[][] getMotorPos(){
        int[][] motorPos = new int[2][2];
        for(int i = 0; i < motors.length; i++){
            for(int j = 0; i < motors[i].length; j++){
                motorPos[i][j] = motors[i][j].getCurrentPosition();
            }
        }
        return motorPos;
    }

    public boolean isCloseTo(int pos) {
        double avgPos = 0.0;
        for (DcMotor[] row : motors){
            for (DcMotor motor : row) {
                avgPos += motor.getCurrentPosition();
            }
        }

        return Math.abs(pos - avgPos) < 20;
    }

    public boolean isCloseToRight(int pos) {
        double avgPos = 0.0;
        DcMotor[] rightRow = motors[1];
        for (DcMotor motor : rightRow) {
            avgPos += motor.getCurrentPosition();
        }

        return Math.abs(pos - avgPos) < 20;
    }

    public boolean isCloseToLeft(int pos) {
        double avgPos = 0.0;
        DcMotor[] leftRow = motors[0];
        for (DcMotor motor : leftRow) {
           avgPos += motor.getCurrentPosition();
        }

        return Math.abs(pos - avgPos) < 20;
    }

}
