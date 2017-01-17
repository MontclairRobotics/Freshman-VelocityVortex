package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Garrett on 1/16/2017.
 */
@Disabled
public class AutoMode extends OpMode{

    //AutoMode Variables
    public static final double AUTO_DRIVE_1 = 100;






    //State Machine
    public int state = 0;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void nextState(boolean nextState){
        if (nextState){
            state++;
        }
    }
    //Drive Controls






    @Override
    public void init() {}
    @Override
    public void loop() {}
}
