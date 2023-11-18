package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class DriveBase {
    public LinearOpMode opMode;
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    DcMotor m_elevator;
    Servo m_pixelgrabber;
    Servo m_pixelspinner;


    public DriveBase(LinearOpMode opmode) {
        this.opMode = opmode;
        m_frontLeft = opmode.hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = opmode.hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = opmode.hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = opmode.hardwareMap.get(DcMotor.class, "rearRight");
        m_pixelgrabber = opmode.hardwareMap.get(Servo.class, "pixelgrabber");
        m_pixelspinner = opmode.hardwareMap.get(Servo.class, "pixelspinner");
        m_elevator = opmode.hardwareMap.get(DcMotor.class,"elevator");

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

}
