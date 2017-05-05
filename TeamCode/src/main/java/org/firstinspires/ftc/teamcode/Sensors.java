package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.LightSensor;

/**
 * Created by thegb on 1/31/2017.
 */

public class Sensors {
    public LightSensor lightSensorA;
    public LightSensor lightSensorB;
    public LightSensor lightSensorC;
    public GyroSensor gyroSensorA;
    public void init(froshHardwareMap hwMap){
        lightSensorA = hwMap.sensorA;
        lightSensorB = hwMap.sensorB;
        lightSensorC = hwMap.sensorC;
        lightSensorC.enableLed(true);
    }
}
