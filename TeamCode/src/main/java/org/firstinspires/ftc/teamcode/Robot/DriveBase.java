package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class DriveBase {
    public LinearOpMode opMode;
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    DcMotor m_elevator;
    DcMotor m_intake;
    DistanceSensor S_Distance;
    Servo m_pixelgrabber;
    Servo m_pixelspinner;
    boolean pixelspinnerval = true;
    boolean previousBumper = false;
    double DS_Value = S_Distance.getDistance(DistanceUnit.INCH);


    public DriveBase(LinearOpMode opmode) {
        this.opMode = opmode;
        m_frontLeft = opmode.hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = opmode.hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = opmode.hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = opmode.hardwareMap.get(DcMotor.class, "rearRight");
        m_pixelgrabber = opmode.hardwareMap.get(Servo.class, "pixelgrabber");
        m_pixelspinner = opmode.hardwareMap.get(Servo.class, "pixelspinner");
        m_intake = opmode.hardwareMap.get(DcMotor.class,"intake");
        m_elevator = opmode.hardwareMap.get(DcMotor.class,"elevator");
        S_Distance = opmode.hardwareMap.get(DistanceSensor.class, "Distance Sensor");

        m_frontLeft.setDirection(DcMotor.Direction.REVERSE);
        m_rearLeft.setDirection(DcMotor.Direction.REVERSE);
        m_frontRight.setDirection(DcMotor.Direction.FORWARD);
        m_rearRight.setDirection(DcMotor.Direction.FORWARD);


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
    public  void pixspinner_setSpot(){
        m_pixelspinner.setPosition(1);
    }
    public void pixgrabber_setSpot(double x){
        m_pixelgrabber.setPosition(x);
    }
    public void intake_setPower(double x, double y){
        m_intake.setPower(x+y);
    }
    public void pixgrabberPosition_withDS(){

        if (DS_Value < 2) {
            m_pixelgrabber.setPosition(.54);
        }
        else {
            m_pixelgrabber.setPosition(.4);

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

    }

}
