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
        driveTrain.autoInit(hardware);
        intake = new Intake();
        intake.init(hardware);
        beaconPusher = new BeaconPusher();
        beaconPusher.init(hardware);
        shooter = new Shooter();
        shooter.init(hardware);
    }


    //AutoMode Variables
    //TODO: Review whether distances / conversions are okay as ints instead of doubles
    public static int totalPos = 0;
    public static int currentPos = 0;
    public static int targetPos = 0;
    public static final int DEGREES_PER_INCH = 10000 / 85; //RAFI & JACK MEASUREMENT (WE HAVE TO  DO IT AGAIN)
    public static final int Corner_Vortex_Distance_From_Far_Start = DEGREES_PER_INCH * 144;
    public static final int SINGLE_BLOCK_DISTANCE = 24;
    public static final int PART_BLOCK_DISTANCE = 15;
    public int[][] motorPos = driveTrain.getMotorPos();
    public static final double INCH_PER_DEGREE_CIRCUMFERENCE = 0.16;
    public static final double INCH_FOR_90_DEGREE_TURN = 14.13;
    public static final int TURN_DEGREE_90 = (int)(INCH_PER_DEGREE_CIRCUMFERENCE * INCH_FOR_90_DEGREE_TURN);
    public boolean driving = false;
    public boolean shooting;

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
    public boolean drive(int distance){
        if(!(driving)) {
            for (int i = 0; i < driveTrain.motors.length; i++) {
                for (int j = 0; i < driveTrain.motors[i].length; j++) {
                    startingPos = driveTrain.motors[i][j].getCurrentPosition();
                    driveTrain.motors[i][j].setTargetPosition(startingPos + distance);
                }
            }
            driving = true;
        }
        int avgPos = 0;
        for (int i = 0; i < driveTrain.motors.length; i++) {
            for (int j = 0; i < driveTrain.motors[i].length; j++) {
                avgPos = avgPos + driveTrain.motors[i][j].getCurrentPosition();
            }
        }
        avgPos = avgPos/4;

        distanceTraveled = avgPos - startingPos;
        if(Math.abs(distanceTraveled - distance) < 20){
            driving = false;
        }
        return !(driving);
    }
    


    @Override
    public void init() {}
    @Override
    public void loop() {}
}
