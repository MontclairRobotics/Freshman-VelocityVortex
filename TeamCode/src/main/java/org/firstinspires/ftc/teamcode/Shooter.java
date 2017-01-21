package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by garrett on 1/10/17.
 */

public class Shooter {
    DcMotor shooter;
    froshHardwareMap hwMap;

    int shooterUpPos = 200;
    int shooterDownPos = -950;

    public void init(froshHardwareMap hwMap){
        this.hwMap = hwMap;
        shooter = hwMap.shooterMotor;
    }

    public void shooterUp(){
        shooter.setTargetPosition(shooterUpPos);
    }

    public void shooterDown(){
        shooter.setTargetPosition(shooterDownPos);
    }

    public void incrUp(int incr){
        shooter.setTargetPosition(shooter.getCurrentPosition() + incr);
    }

    public void incrDown(int incr){
        shooter.setTargetPosition(shooter.getCurrentPosition() - incr);
    }
    
    public boolean isCloseTo(double val) {
        return Math.abs(val - shooter.getCurrentPosition()) < 5;
    }

}
