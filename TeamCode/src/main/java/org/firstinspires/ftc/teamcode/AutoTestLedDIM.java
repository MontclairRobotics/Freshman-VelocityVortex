package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;

/**
 * Created by willc on 5/5/2017.
 */

//DIM refers to Device Interface Module otherwise known as Core Interface Module

public class AutoTestLedDIM extends AutoMode{
    @Override
    public void init() {
        setState(0);
        autoInit();
    }

    //DIM setup
    private static final int    BLUE_LED    = 0;     // Blue LED channel on DIM
    private static final int    RED_LED     = 1;     // Red LED Channel on DIM

    @Override
    public void loop() {
        switch(state){
            case 1:
                dim.setLED(BLUE_LED,true);
                dim.setLED(RED_LED,true);
                telemetry.addData("INFO","Blue and Red LEDs true");
                break;
        }
    }
}
