package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Garrett on 1/16/2017.
 * Extended by Will on 1/20/2017
 */
@Disabled
public class AutoMode extends OpMode {

    //AutoMode Objects
    DriveTrain driveTrain;
    froshHardwareMap hardware;
    Intake intake;
    Shooter shooter;
    BeaconPusher beaconPusher;

    public void autoInit() {
        hardware = new froshHardwareMap();
        hardware.init(hardwareMap);
        driveTrain = new DriveTrain();
        driveTrain.init(hardware);
        intake = new Intake();
        intake.init(hardware);
        beaconPusher = new BeaconPusher();
        beaconPusher.init(hardware);
        shooter = new Shooter();
        shooter.init(hardware);
    }


    //AutoMode Variables
    public static final int INCHES_TO_CORNER_VORTEX = 144;
    public static int totalPos = 0;
    public static int currentPos = 0;
    public static int targetPos = 0;
    public static final double AUTO_DRIVE_1 = 100;
    public static final int DEGREES_PER_INCH = 10000 / 85; //RAFI & JACK MEASUREMENT (WE HAVE TO  DO IT AGAIN)
    public static final int Corner_Vortex_Distance_From_Far_Start = DEGREES_PER_INCH * 144;
    public static final int SINGLE_BLOCK_DISTANCE = 24;
    public static final int PART_BLOCK_DISTANCE = 15;
    public int[][] motorPos = driveTrain.getMotorPos();
    public static final int DEGREES_PER_INCH_CIRCLE = 255/360;
    public boolean driving = false;

    //State Machine
    public int state = 0;

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void nextState(boolean nextState) {
        if (nextState) {
            state++;
        }
    }


    //Drive Controls
    int distanceTraveled = 0;
    int startingPos = 0;
    public int drive(int distance){
        if(!(driving)) {
            for (int i = 0; i < driveTrain.motors.length; i++) {
                for (int j = 0; i < driveTrain.motors[i].length; j++) {
                    startingPos = driveTrain.motors[i][j].getCurrentPosition();
                    driveTrain.motors[i][j].setTargetPosition(startingPos + distance);
                }
            }
            driving = true;
        }
        distanceTraveled = driveTrain.motors[0][0].getCurrentPosition() - startingPos;
        if(Math.abs(distanceTraveled - distance) > 20){
            driving = false;
        }
        return distanceTraveled;
    }




    @Override
    public void init() {}
    @Override
    public void loop() {}
}
