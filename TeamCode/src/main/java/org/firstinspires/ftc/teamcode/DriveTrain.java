package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by garrett on 12/8/16.
 */

public class DriveTrain {
    HardwareMap hwMap;
    public DcMotor[][] motors=new DcMotor[2][2];
    public void DriveTrain(HardwareMap hwMap){
        this.hwMap = hwMap;
        motors[0][0]  = hwMap.dcMotor.get("left_driveA");
        motors[0][1]  = hwMap.dcMotor.get("left_driveB");
        motors[1][0]  = hwMap.dcMotor.get("right_driveA");
        motors[1][1]  = hwMap.dcMotor.get("right_driveB");
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

}
