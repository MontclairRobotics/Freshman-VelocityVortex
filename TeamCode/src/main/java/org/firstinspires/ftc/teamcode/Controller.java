package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Garrett on 12/8/16.
 */

public class Controller {
    public  static Gamepad drive = null;
    public static Gamepad shoot = null;
    public static void init(Gamepad a, Gamepad b){
        drive = a;
        shoot = b;
    }
    public float getRightPower(){
        return drive.right_stick_y - drive.right_stick_x;
    }
    public float getLeftPower() {
        return drive.left_stick_x - drive.left_stick_y;
    }
    public boolean getButtonPressed(String button){
        if (button == "A"){
            return shoot.a;
        }else if (button == "B"){
            return shoot.b;
        }else if (button == "X"){
            return shoot.x;
        }else if (button == "Y"){
            return shoot.y;
        }else{
            return false;
        }

    }
    public boolean dpad(String direction){
        if (direction == "UP"){
            return shoot.dpad_up;
        }else if (direction == "DOWN"){
            return shoot.dpad_down;
        }else if (direction == "RIGHT"){
            return shoot.dpad_right;
        }else if (direction == "LEFT"){
            return shoot.dpad_left;
        }else{
            return false;
        }
    }
}