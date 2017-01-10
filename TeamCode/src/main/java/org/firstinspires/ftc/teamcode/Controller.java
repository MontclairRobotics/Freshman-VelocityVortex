package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Garrett on 12/8/16.
 */

public class Controller {
    public  static Gamepad drive = null;

    public static void init(Gamepad a, Gamepad b){
        drive = a;
    }
    public float getRightPower(){
        return drive.right_stick_y - drive.right_stick_x;
    }
    public float getLeftPower() {
        return drive.left_stick_x - drive.left_stick_y;
    }

}