package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will on 1/20/2017
 */
@Disabled
public class AutoMode extends OpMode{

    //AutoMode Variables
    public static final double AUTO_DRIVE_1 = 100;
    public static final int DEGREES_PER_INCH = 10000/85; //RAFI & JACK MEASUREMENT (WE HAVE TO  DO IT AGAIN)
    public static final int Corner_Vortex_Distance_From_Far_Start = DEGREES_PER_INCH*144;
    public static final int SINGLE_BLOCK_DISTANCE = 24;
    public static final int PART_BLOCK_DISTANCE = 15;


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
