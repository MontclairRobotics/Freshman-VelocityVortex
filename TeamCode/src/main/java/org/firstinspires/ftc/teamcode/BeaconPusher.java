package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by sarab on 1/14/2017.
 */

public class BeaconPusher {
    DcMotor pusher;
    froshHardwareMap hardware;

    int pusherInPos;
    int pusherOutPos;

    public void init(froshHardwareMap hwMap){
        hardware = hwMap;
        pusher = hardware.beaconMotor;
    }
    public void pusherIn(){
        pusher.setPower(0.1);
        pusher.setTargetPosition(pusherInPos);
    }
    public void pusherOut(){
        pusher.setPower(0.1);
        pusher.setTargetPosition(pusherOutPos);
    }
    
}
