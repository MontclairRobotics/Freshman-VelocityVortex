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

    @Override
    public void loop() {
        switch(state){
            case 1:
                dim.setLED(BLUE_LED,true);
                dim.setLED(RED_LED,true);
                telemetry.addData("INFO","Blue and Red LEDs");
                break;
        }
    }
}
