package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="BlackTeam-Blue Left Auto", group="Basic")
public class BlackTeam_BlueLeft extends LinearOpMode{
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    DcMotor m_elevator;
    Servo m_pixelgrabber;
    Servo m_pixelspinner;
    DcMotor m_intake;

    @Override
    public void runOpMode() {
        m_frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        m_pixelgrabber = hardwareMap.get(Servo.class, "pixelgrabber");
        m_pixelspinner = hardwareMap.get(Servo.class, "pixelspinner");
        m_elevator = hardwareMap.get(DcMotor.class,"elevator");
        m_intake = hardwareMap.get(DcMotor.class,"intake");

        m_frontLeft.setDirection(DcMotor.Direction.REVERSE);
        m_rearLeft.setDirection(DcMotor.Direction.REVERSE);
        m_frontRight.setDirection(DcMotor.Direction.FORWARD);
        m_rearRight.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        drive(0.5, 0, 0);
        sleep(1600);
        drive(0,0 ,0);
        sleep(400);
        m_intake.setPower(-0.5);
        drive(-0.5,0,0);
        sleep(1600);
        m_intake.setPower(0);
        drive(0.5,0,0);
        sleep(1600);
        drive(0,0,0);





    }

        public void drive(double y, double x, double rotation){
            m_frontLeft.setPower(y + x + rotation); // Note: pushing stick forward gives negative value
            m_rearLeft.setPower(y - x + rotation);
            m_frontRight.setPower(y - x - rotation);
            m_rearRight.setPower(y + x - rotation);
        }
    }