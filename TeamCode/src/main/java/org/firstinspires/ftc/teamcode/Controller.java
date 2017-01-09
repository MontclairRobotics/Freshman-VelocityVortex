package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by garrett on 12/8/16.
 */

public class Controller {
    public Gamepad drive = null;

    public void init(Gamepad a, Gamepad b){
        this.drive = a;
    }
    public float getRigthPower(){
        return drive.right_stick_y - drive.right_stick_x;
    }
    public float getLeftPower(){
        return drive.left_stick_x - drive.left_stick_y;
    }


}