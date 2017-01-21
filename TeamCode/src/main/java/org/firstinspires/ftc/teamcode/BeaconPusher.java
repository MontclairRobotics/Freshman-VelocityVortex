package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by sarab on 1/14/2017.
 */

public class BeaconPusher {
    DcMotor beacon_pusher;
    froshHardwareMap hardware;

    int pusherInPos;
    int pusherOutPos;

    public void init(froshHardwareMap hwMap){
        hardware = hwMap;
        beacon_pusher = hardware.beaconMotor;
    }
    public void pusherIn(){
        beacon_pusher.setPower(0.3);
        beacon_pusher.setTargetPosition(pusherInPos);
    }
    public void pusherOut(){
        beacon_pusher.setPower(0.3);
        beacon_pusher.setTargetPosition(pusherOutPos);
    }
    
}
