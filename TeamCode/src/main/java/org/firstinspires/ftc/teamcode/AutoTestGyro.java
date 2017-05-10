package org.firstinspires.ftc.teamcode;

import com.kauailabs.navx.ftc.AHRS;

/**
 * Created by willc on 5/10/2017.
 */

public class AutoTestGyro extends AutoMode{
    @Override
    public void init(){
        autoInit();

        navx_device = AHRS.getInstance(hardwareMap.deviceInterfaceModule.get("dim"),
                NAVX_DIM_I2C_PORT,
                AHRS.DeviceDataType.kProcessedData);
    }

    @Override
    public void loop() {
        telemetry.addData("Raw x",navx_device.getRawGyroX());
        telemetry.addData("Raw y",navx_device.getRawGyroY());
        telemetry.addData("Raw z",navx_device.getRawGyroZ());
        telemetry.addData("Temp",navx_device.getTempC()+273 + "k");

    }
}
