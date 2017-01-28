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
    public int[][] motorPos;

    public void autoInit() {
        hardware = new froshHardwareMap();
        hardware.init(hardwareMap);
        telemetry.addData("INFO", "Hardware Map Init");
        intake = new Intake();
        intake.init(hardware);
        telemetry.addData("INFO", "Intake Init");
        driveTrain = new DriveTrain();
        driveTrain.autoInit(hardware);
        telemetry.addData("INFO", "Drive Train Init");
        beaconPusher = new BeaconPusher();
        beaconPusher.init(hardware);
        telemetry.addData("INFO", "Pusher Init");
        shooter = new Shooter();
        shooter.init(hardware);
        telemetry.addData("INFO", "Shooter Init");
        motorPos = driveTrain.getMotorPos();
    }


    //AutoMode Variables
    //TODO: Review whether distances / conversions are okay as ints instead of doubles

    //Positions
    public static int totalPos = 0;
    public static int currentPos = 0;
    public static int targetPos = 0;

    // Distances
    public static final int DEGREES_PER_INCH = 10000 / 85; //10000 Degrees over how many inches that is
    public static final int SINGLE_BLOCK_DISTANCE = 24; // Full Tile distance
    public static final int PART_BLOCK_DISTANCE = 15; // From back of wall to have center of robot at 24 in
    public static final double FourRoot2 = 5.656; //What the name implies
    public static final int DISTANCE_AFTER_SHOOTING = (int) (FourRoot2 * DEGREES_PER_INCH); //distance to move after turning on side specific autos
    public static final int DISTANCE_BEFORE_SHOOTING = (int) (FourRoot2 / 2 * DEGREES_PER_INCH); //distance to move before turning on side specific autos

    //Robot Turning
    public static final double INCH_PER_DEGREE_CIRCUMFERENCE = 0.16; //inch per deg on 18 diameter circle
    public static final double INCH_FOR_90_DEGREE_TURN = 14.13; // inch per deg on a 18 diameter circle
    public static final int TURN_DEGREE_90 = (int) (INCH_PER_DEGREE_CIRCUMFERENCE * INCH_FOR_90_DEGREE_TURN); //Motor drive distance for 18 Diameter circle
    public static final int TURN_DEGREE_45 = (int) ((INCH_PER_DEGREE_CIRCUMFERENCE * INCH_FOR_90_DEGREE_TURN) / 2); // Motor Distances for 18 Diameter circle
    public static final int TURN_DEGREE = (int) ((INCH_PER_DEGREE_CIRCUMFERENCE * INCH_FOR_90_DEGREE_TURN) / 90);

    //control variables
    public boolean driving = false;
    public boolean shooting = false;
    public boolean turning = false;
    public boolean intaking = false;
    public boolean doneIntaking = false;

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
        telemetry.addData("INFO", "State " + state + " acheived");
    }

    //AUTO DRIVING
    int distanceTraveled = 0;
    int startingPos = 0;

    public boolean drive(int distance) {
        if (!(driving)) {
            for (int i = 0; i < driveTrain.motors[0].length; i++) {
                startingPos = driveTrain.motors[0][i].getCurrentPosition();
                driveTrain.motors[0][i].setTargetPosition(startingPos + distance);
            }
            for (int i = 0; i < driveTrain.motors[1].length; i++) {
                startingPos = driveTrain.motors[1][i].getCurrentPosition();
                driveTrain.motors[1][i].setTargetPosition(0-(startingPos + distance));
            }

            driving = true;
        }
        int avgPos = 0;
        for (int i = 0; i < driveTrain.motors.length; i++) {
            for (int j = 0; j < driveTrain.motors[i].length; j++) {
                avgPos = avgPos + Math.abs(driveTrain.motors[i][j].getCurrentPosition());
            }
        }
        avgPos = avgPos / 4;

        distanceTraveled = avgPos - startingPos;
        if (Math.abs(distanceTraveled - distance) < 20) {
            driving = false;
            distanceTraveled = 0;
            startingPos = 0;
        }
        return !(driving);
    }


    //AUTO SHOOTING
    public boolean shoot() {
        if (!(shooting)) {
            shooter.shooterUp();
            shooting = true;
        }
        if (Math.abs(shooter.shooterUpPos - shooter.getPos()) < 20) {
            shooter.shooterDown();
        }
        if (shooting && shooter.shooterDownPos - shooter.getPos() < 20) {
            shooting = false;
        }
        return !(shooting);
    }


    //AUTO TURNING
    public boolean turn(int degrees) {
        //calculate how much each motor has to move
        int distance = (int)((degrees/360)*18*Math.PI);
        //Get and set original positions
        if (!turning) {
            for (int i = 0; i < driveTrain.motors.length; i++) {
                for (int j = 0; j < driveTrain.motors[i].length; j++) {
                    startingPos = driveTrain.motors[i][j].getCurrentPosition();
                    driveTrain.motors[i][j].setTargetPosition(startingPos + distance);
                }
            }
        }

        //calculate the average all of the motor positions
        int avgPos = 0;
        for (int i = 0; i < driveTrain.motors.length; i++) {
            for (int j = 0; j < driveTrain.motors[i].length; j++) {
                avgPos = avgPos + Math.abs(driveTrain.motors[i][j].getCurrentPosition());
            }
        }
        avgPos = avgPos / 4;

        //Test if the motors have gotten to the right position
        distanceTraveled = avgPos - startingPos;
        if (Math.abs(distanceTraveled - distance) < 20) {
            turning = false;
            distanceTraveled = 0;
            startingPos = 0;
        }
        return turning;
    }

    //Mototor Down
    //If MotorDown then Motor Up
    //else Motor half

    //AUTO INTAKE
    public boolean intake(){
        if (!intaking){
            intake.intakeDown();
            doneIntaking = false;
            intaking = true;
        }else if(intake.isCloseTo(intake.intakeDownPos)){
            intake.intakeUp();
        }else{
            intake.intakeHalf();
            doneIntaking = true;
        }
        return doneIntaking;
    }




    @Override
    public void init() {
    }

    @Override
    public void loop() {
    }
}
