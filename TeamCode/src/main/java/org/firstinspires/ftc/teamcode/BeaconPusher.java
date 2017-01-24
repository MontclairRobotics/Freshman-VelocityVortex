package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by sarab on 1/14/2017.
 */

public class BeaconPusher {
    DcMotor pusher;
    froshHardwareMap hardware;

    int pusherInPos = 0;
    int pusherOutPos  = 1100;

    public void init(froshHardwareMap hwMap){
        hardware = hwMap;
        pusher = hardware.beaconMotor;
    }
    public void pusherIn(){
        pusher.setPower(0.2);
        pusher.setTargetPosition(pusherInPos);
    }
    public void pusherOut(){
        pusher.setPower(0.2);
        pusher.setTargetPosition(pusherOutPos);
    }
    public int getPos(){
        return pusher.getCurrentPosition();
    }
}
