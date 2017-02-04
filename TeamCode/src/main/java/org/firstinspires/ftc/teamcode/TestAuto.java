package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by Montclair Robotics on 1/24/2017.
 */


@Autonomous(name="Test Auto", group = "147")
public class TestAuto extends AutoMode {
    @Override
    public void init(){
        autoInit();
        setState(0);
    }



    private int driveDistance1 = 12 * DEGREES_PER_INCH;
    private int driveDistance2 = -12 * DEGREES_PER_INCH;
    private int turnDistance1 = 360;


    @Override
    public void loop(){
        switch (state){
            case 0:
                nextState(drive(driveDistance1));
                break;
            case 1:
                nextState(shoot());
                break;
            case 2:
                nextState(intake());
                break;
            case 3:
                nextState(turn(turnDistance1));
                break;
            case 4:
                nextState(drive(driveDistance2));
        }
        updateTelemetry(telemetry);
    }
}
