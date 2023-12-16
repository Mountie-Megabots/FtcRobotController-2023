package org.firstinspires.ftc.teamcode.Robot;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DriveBase {
    public LinearOpMode opMode;
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    DcMotor m_elevator;
    Servo m_intake;
    DistanceSensor S_Distance;
    boolean pixelspinnerval = true;
    boolean previousBumper = false;
    double DS_Value;
    boolean gamepad2apress;
    Voltage Sensor batteryVoltage;

    IMU imu;


    public DriveBase(LinearOpMode opmode) {
        this.opMode = opmode;
        m_frontLeft = opmode.hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = opmode.hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = opmode.hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = opmode.hardwareMap.get(DcMotor.class, "rearRight");
        m_intake = opmode.hardwareMap.get(Servo.class, "intake");
        m_elevator = opmode.hardwareMap.get(DcMotor.class, "elevator");
        //S_Distance = opmode.hardwareMap.get(DistanceSensor.class, "Distance Sensor");
        batteryVoltage = opmode.hardwareMap.get(VoltageSensor.class, "Voltage Sensor");


        m_frontLeft.setDirection(DcMotor.Direction.REVERSE);
        m_rearLeft.setDirection(DcMotor.Direction.REVERSE);
        m_frontRight.setDirection(DcMotor.Direction.FORWARD);
        m_rearRight.setDirection(DcMotor.Direction.FORWARD);

        IMU.Parameters myIMUParameters;

        // Retrieve the IMU from the hardware map
        imu = opmode.hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        myIMUParameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(myIMUParameters);
    }
    public void driveWithIMU(double y, double x, double delay){
        double startTime = opMode.getRuntime();
        double delayMS = delay/1000;
        double startAngle = this.getIMU();

        while(opMode.getRuntime() < (startTime+delayMS)){
            this.drive(y, x, (this.getIMU()-startAngle)/90);
        }
    }
    public double getIMU() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }
    public void drive(double y, double x, double rotation){
        m_frontLeft.setPower(y + x + rotation); // Note: pushing stick forward gives negative value
        m_rearLeft.setPower(y - x + rotation);
        m_frontRight.setPower(y - x - rotation);
        m_rearRight.setPower(y + x - rotation);
    }
    public void elevator_setPower(double x){
        m_elevator.setPower(x);
    }
   /* public  void pixspinner_setSpot(){
        m_pixelspinner.setPosition(1);
    }*/
    /*public void pixgrabber_setSpot(double x){
        m_pixelgrabber.setPosition(x);
    }*/
    public void intake_setPower(boolean variable){
        if (variable){
            m_intake.setPosition(1);
        }
        else {
            m_intake.setPosition(.3);
        }
    }
    public void intake_up(){
        m_intake.setPosition(1);
    }
    public void intake_down(){
        m_intake.setPosition(.3);
    }
    /*ublic void pixgrabberPosition_withDS(boolean gamepad2a){
        gamepad2apress = gamepad2a;
        if (gamepad2apress){
            m_pixelgrabber.setPosition(.4);
        }
        else if (!gamepad2apress){
            if (DS_Value < 2) {
                m_pixelgrabber.setPosition(.54);
            }
            else if (DS_Value > 2) {
                m_pixelgrabber.setPosition(.4);
            }
        }
    }
    public void pixgrabberPosition(boolean variable){
        if (variable){
            m_pixelgrabber.setPosition(.54);
        }
        else {
            m_pixelgrabber.setPosition(.3);
        }
    }

    public double getDistanceSensor(){
        return S_Distance.getDistance(DistanceUnit.INCH);
    }
    public void pixspinnerToggle(boolean G2LeftBumper){
        if(G2LeftBumper && !previousBumper){
            pixelspinnerval = !pixelspinnerval;
        }
        previousBumper = G2LeftBumper;

        if (pixelspinnerval){
            m_pixelspinner.setPosition(.94);
        }
        else{
            m_pixelspinner.setPosition(.5);
        }

    }*/


}
