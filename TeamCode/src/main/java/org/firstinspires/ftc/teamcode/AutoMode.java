package org.firstinspires.ftc.teamcode;

import com.kauailabs.navx.ftc.AHRS;
import com.kauailabs.navx.ftc.navXPIDController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import java.text.DecimalFormat;

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
    Sensors sensors;
    ElapsedTime timer;
    DeviceInterfaceModule dim;



    public void autoInit() {
        hardware = new froshHardwareMap();
        hardware.init(hardwareMap);
        telemetry.addData("INFO", "Hardware Map Init");
        intake = new Intake();
        intake.init(hardware);
        intake.setPos(0);
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
        sensors = new Sensors();
        sensors.init(hardware);
        timer = new ElapsedTime();
        startTime = timer.milliseconds();

        dim.setLED(BLUE_LED,true);
        dim.setLED(RED_LED,true);

        navx_device = AHRS.getInstance(hardwareMap.deviceInterfaceModule.get("dim"),
                NAVX_DIM_I2C_PORT,
                AHRS.DeviceDataType.kProcessedData,
                NAVX_DEVICE_UPDATE_RATE_HZ);
        yawPIDController = new navXPIDController( navx_device,
                navXPIDController.navXTimestampedDataSource.YAW);
        yawPIDController.setSetpoint(TARGET_ANGLE_DEGREES);
        yawPIDController.setContinuous(true);
        yawPIDController.setOutputRange(MIN_MOTOR_OUTPUT_VALUE, MAX_MOTOR_OUTPUT_VALUE);
        yawPIDController.setTolerance(navXPIDController.ToleranceType.ABSOLUTE, TOLERANCE_DEGREES);
        yawPIDController.setPID(YAW_PID_P, YAW_PID_I, YAW_PID_D);
        yawPIDController.enable(true);
        df = new DecimalFormat("#.##");
    }

    //Auto Start
    public void autoStart(){
        navx_device.zeroYaw();
        yawPIDResult = new navXPIDController.PIDResult();
        intake.intakeHalf();
        beacon();
        if(navx_device.isCalibrating()){
            telemetry.addData("NavX","Calibrating");
        }else{
            telemetry.addData("NavX","Done Calibrating");
        }
    }

    //AutoMode Variables

    //DIM setup
    public static final int    BLUE_LED    = 0;     // Blue LED channel on DIM
    public static final int    RED_LED     = 1;     // Red LED Channel on DIM

    //Navx Variables
    public final int NAVX_DIM_I2C_PORT = 0;
    public AHRS navx_device;
    public navXPIDController yawPIDController;
    public ElapsedTime runtime = new ElapsedTime();
    public final byte NAVX_DEVICE_UPDATE_RATE_HZ = 50;
    public final double TARGET_ANGLE_DEGREES = 0.0;
    public final double TOLERANCE_DEGREES = 2.0;
    public final double MIN_MOTOR_OUTPUT_VALUE = -1.0;
    public final double MAX_MOTOR_OUTPUT_VALUE = 1.0;
    public final double YAW_PID_P = 0.005;
    public final double YAW_PID_I = 0.0;
    public final double YAW_PID_D = 0.0;
    public boolean calibration_complete = false;
    navXPIDController.PIDResult yawPIDResult;
    DecimalFormat df;

    //Positions
    public static int totalPos = 0;
    public static int currentPos = 0;
    public static int targetPos = 0;

    // Distances(Basic)
    public static final int DEGREES_PER_INCH = 10000 / 85; //10000 Degrees over how many inches
    public static final int SINGLE_BLOCK_DISTANCE = 24 * DEGREES_PER_INCH; //length of block converted int degrees
    public static final int HALF_BLOCK_DISTANCE = 12 * DEGREES_PER_INCH; // distance for half a block
    public static final int ONE_AND_HALF_BLOCK_DISTANCE = SINGLE_BLOCK_DISTANCE + HALF_BLOCK_DISTANCE;

    //Distances after turns or between things
    public static final int DISTANCE_AFTER_TURN = (int)(Math.sqrt(2) * 2 * SINGLE_BLOCK_DISTANCE); //distance to cover after turning in non-beacon timer side autos

    //beacon color distances
    public static final int rightBeaconDistance = (int)(4 * DEGREES_PER_INCH);
    public static final int leftBeaconDistance = (int)(9 * DEGREES_PER_INCH);

    //Turning
    public static final int Left45 = -45; // used for 45 deg turns left
    public static final int Right45 = 45; // used for 45 deg turns right
    public static final int Left90 = 2 * Left45; // used for 90 deg turns left
    public static final int Right90 = 2 * Right45; // used for 90 turns right

    //Math for turning logic
    public static final double circumference = 14 * Math.sqrt(2) * Math.PI;
    public static final double degree = circumference / 360;

    // Math for Gyro turning logic
    public static float currentAngle; // for taking angle currently
    public static int currentIntAngle; // int version of current angle
    public static int gyroA; // X quaternion value for calculating distance
    public static int gyroB; // Y quaternion value for calculating distance
    public static int gyroC; // for drive distance without error and PIDs

    //control variables
    public boolean driving = false;
    public boolean turning = false;
    public boolean beaconDriving;

    //Time and pauses
    private double startTime;
    public double pauseTime = 0.5;


    //Other Variables
    public String beaconLeftColor;
    public String beaconRightColor;

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
            telemetry.addData("INFO", "State " + state + " achieved");
            startTime = timer.milliseconds();
        }
    }

    //AUTO DRIVING
    int distanceTraveled = 0;
    int driveStartingPos = 0;

    public boolean drive(int distance) {
        if (!(driving)) {
            for (int i = 0; i < driveTrain.motors[0].length; i++) {
                driveStartingPos = driveTrain.motors[0][i].getCurrentPosition();
                driveTrain.motors[0][i].setTargetPosition(driveStartingPos + distance);
            }
            for (int i = 0; i < driveTrain.motors[1].length; i++) {
                driveStartingPos = driveTrain.motors[1][i].getCurrentPosition();
                driveTrain.motors[1][i].setTargetPosition((driveStartingPos - distance));
            }
            driving = true;
        }

        distanceTraveled = driveTrain.motors[0][0].getCurrentPosition() + driveStartingPos;

        if (Math.abs(distanceTraveled - distance) < 20) {
            driving = false;
            distanceTraveled = 0;
            driveStartingPos = 0;
        }
        return !(driving);
    }


    //LIGHT DRIVING
    //TODO: MAke sure light values work
    public boolean driveUntilLine(){
        driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][0].setPower(0.6);
        driveTrain.motors[0][1].setPower(0.6);
        driveTrain.motors[1][0].setPower(-0.5);
        driveTrain.motors[1][1].setPower(-0.5);
        if(sensors.lightSensorC.getRawLightDetected() > .57){
            driveTrain.motors[0][0].setPower(0);
            driveTrain.motors[0][1].setPower(0);
            driveTrain.motors[1][0].setPower(0);
            driveTrain.motors[1][1].setPower(0);
            driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            return true;
        }
        return false;
    }
    public boolean driveBackUntilLine(){
        driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][0].setPower(-0.6);
        driveTrain.motors[0][1].setPower(-0.6);
        driveTrain.motors[1][0].setPower(0.5);
        driveTrain.motors[1][1].setPower(0.5);
        if(sensors.lightSensorC.getRawLightDetected() > 1.4){
            driveTrain.motors[0][0].setPower(0);
            driveTrain.motors[0][1].setPower(0);
            driveTrain.motors[1][0].setPower(0);
            driveTrain.motors[1][1].setPower(0);
            driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            return true;
        }
        return false;
    }


    //BEACON DRIVING (DRIVING USING THE WALL WHEELS)
    int beaconStart = 0;
    int beaconDistanceTraveled = 0;
    public boolean beaconDrive(int distance){
        if(!(beaconDriving)){
            beaconStart = driveTrain.motors[0][0].getCurrentPosition();
            beaconDriving = true;
        }
        driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        driveTrain.motors[0][0].setPower(0.6);
        driveTrain.motors[0][1].setPower(0.6);
        driveTrain.motors[1][0].setPower(-0.5);
        driveTrain.motors[1][1].setPower(-0.5);
        beaconDistanceTraveled = driveTrain.motors[0][0].getCurrentPosition() - beaconStart;
        if(Math.abs(driveTrain.motors[0][0].getCurrentPosition() - distance) < 20){
            driveTrain.motors[0][0].setPower(0);
            driveTrain.motors[0][1].setPower(0);
            driveTrain.motors[1][0].setPower(0);
            driveTrain.motors[1][1].setPower(0);
            driveTrain.motors[0][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[0][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            driveTrain.motors[1][1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
            beaconDriving = false;
        }
        return beaconDriving;
    }

    //AUTO SHOOTING
    int shootingState = 0;
    public boolean shoot() {
        switch (shootingState){
            case 0:
                shooter.shooterUp();
                if(shooter.isCloseTo(shooter.shooterUpPos)) shootingState = 1;
                break;
            case 1:
                shooter.shooterDown();
                if(shooter.isCloseTo(shooter.shooterDownPos)){
                    shootingState = 0;
                    return true;
                }
                break;
        }
        return false;
    }

    // AUTO BEACON PUSHER
    private int beaconState = 0;
    public boolean beacon() {
       switch(beaconState) {
           case 0:
               beaconPusher.pusherOutHalf();
               if(beaconPusher.isCloseTo(beaconPusher.pusherOutHalfPos)) beaconState = 1;
               break;
           case 1:
               beaconPusher.pusherIn();
               if(beaconPusher.isCloseTo(beaconPusher.pusherInPos)) {
                   beaconState = 0;
                   return true;
               }
               break;
       }
       return false;
    }

    //Auto turning (Garrett)
    int turnStartingPos = 0;
    public boolean turn2(int degrees){
        //calculate how much each motor has to move
        int distance = (int) (degrees * degree * DEGREES_PER_INCH);
        //Get and set original positions
        if (!turning) {
            for (int i = 0; i < driveTrain.motors.length; i++) {
                for (int j = 0; j < driveTrain.motors[i].length; j++) {
                    turnStartingPos = driveTrain.motors[i][j].getCurrentPosition();
                    driveTrain.motors[i][j].setTargetPosition(turnStartingPos + distance);
                }
            }
            turning = true;
        }
        telemetry.addData("Target Position", distance);

        //calculate the average all of the motor positions
        int avgPos = 0;
        for (int i = 0; i < driveTrain.motors.length; i++) {
            for (int j = 0; j < driveTrain.motors[i].length; j++) {
                avgPos = avgPos + driveTrain.motors[i][j].getCurrentPosition();
            }
        }
        avgPos = avgPos / 4;
        telemetry.addData("AvgPos", avgPos);

        //Test if the motors have gotten to the right position
        distanceTraveled = driveTrain.motors[0][0].getCurrentPosition() + turnStartingPos;
        telemetry.addData("Distance Traveled", distanceTraveled);
        telemetry.addData("Diff", Math.abs(distanceTraveled - distance));
        if (Math.abs(distanceTraveled - distance) < 300) {
            turning = false;
            distanceTraveled = 0;
            turnStartingPos = 0;
        }
        return turning;
    }

    //AUTO TURNING (RAFI)
    private int motor1end = 0;
    public boolean turn(int degrees) {
        if(!turning) {
            int distance = (int)(degrees * degree * DEGREES_PER_INCH);
            motor1end = driveTrain.motors[0][0].getCurrentPosition() + distance;
            for(DcMotor[] row : driveTrain.motors) {
                for(DcMotor m : row) {
                    m.setTargetPosition(m.getCurrentPosition() + distance);
                }
            }
            turning = true;
        }
        if(Math.abs(driveTrain.motors[0][0].getCurrentPosition() - motor1end) < 20) {
            turning = false;
            return true;
        }
        return false;
    }

    //AUTO INTAKE
    public int intakeState = 0;
    public boolean intake(){
        switch(intakeState) {
            case 0:
                intake.intakeDown();
                if(intake.isCloseTo(intake.intakeDownPos)) intakeState = 1;
                break;
            case 1:
                intake.intakeUp();
                if(intake.isCloseTo(intake.intakeUpPos)) intakeState = 2;
                break;
            case 2:
                intake.intakeHalf();
                if(intake.isCloseTo(intake.intakeHalfPos)) {
                    intakeState = 0;
                    return true;
                }

        }
        return false;
    }

    //BEACON COLORS METHOD
    public boolean getColors() {
        if (sensors.lightSensorA.getRawLightDetected() > sensors.lightSensorB.getRawLightDetected()) {
            beaconRightColor = "RED";
            beaconLeftColor = "BLUE";
        } else {
            beaconRightColor = "BLUE";
            beaconLeftColor = "RED";
        }
        return true;
    }

    //WAIT METHOD
    public boolean pause(double seconds){
        telemetry.addData("Seconds", getSec());
        telemetry.addData("Target Seconds",seconds);
        if(getSec() > seconds){
            return true;
        }
        return false;
    }

    public double getMillis() {
        return timer.milliseconds() - startTime;
    }

    public double getSec() {
        return getMillis() / 1000.0;
    }

    //double for PID
    public double limit(double a) {
        return Math.min(Math.max(a, MIN_MOTOR_OUTPUT_VALUE), MAX_MOTOR_OUTPUT_VALUE);
    }

    //TODO: Test and review
    //Gyro Drive(Will)
    public void gyroDrive (double speed, int distance, int targetAngle){
        navx_device.zeroYaw();
        currentAngle = navx_device.getYaw();
        if (targetAngle < 0){
            //turn left
            while(navx_device.getYaw() < targetAngle){
                driveTrain.motors[0][0].setPower(speed); //left motor A
                driveTrain.motors[0][1].setPower(speed); //left motor B
                driveTrain.motors[1][0].setPower(-speed); //right motor A
                driveTrain.motors[1][1].setPower(-speed); //right motor B
            }
            driveTrain.motors[0][0].setPower(0); //left motor A
            driveTrain.motors[0][1].setPower(0); //left motor B
            driveTrain.motors[1][0].setPower(0); //right motor A
            driveTrain.motors[1][1].setPower(0); //right motor B

        }else{
            //turn right
            while(navx_device.getYaw() > targetAngle){
                driveTrain.motors[0][0].setPower(-speed); //left motor A
                driveTrain.motors[0][1].setPower(-speed); //left motor B
                driveTrain.motors[1][0].setPower(speed); //right motor A
                driveTrain.motors[1][1].setPower(speed); //right motor B
            }
            driveTrain.motors[0][0].setPower(0); //left motor A
            driveTrain.motors[0][1].setPower(0); //left motor B
            driveTrain.motors[1][0].setPower(0); //right motor A
            driveTrain.motors[1][1].setPower(0); //right motor B
        }

        driveTrain.setDrivePosition(distance);
    }



    @Override
    public void init() {
    }

    @Override
    public void loop() {
    }
}
