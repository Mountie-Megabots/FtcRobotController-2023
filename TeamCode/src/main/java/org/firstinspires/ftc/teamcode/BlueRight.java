package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="BlueRight", group="Basic")
public class BlueRight extends LinearOpMode{
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    Servo m_Servo;

    @Override
    public void runOpMode() {
        m_frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        m_Servo = hardwareMap.get(Servo.class,"Servo");

        m_frontLeft.setDirection(DcMotor.Direction.REVERSE);
        m_rearLeft.setDirection(DcMotor.Direction.REVERSE);
        m_frontRight.setDirection(DcMotor.Direction.FORWARD);
        m_rearRight.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //drive sideways
        drive(0, 0.7, 0,0.3);
        sleep(1700);
        drive(0,0,0,0.3);

        //drive forward
        drive(0.7, 0, 0,0.3);
        sleep(1800);
        drive(0,0,0,0.3);

        sleep(1100);

        //drive backwards
        drive(-0.7, 0, 0,1);
        sleep(500);
        drive(0,0,0,0.3);

        //drive forward
        drive(0.7, 0, 0,0.3);
        sleep(480);
        drive(0,0,0,0.3);
    }




    public void drive(double y, double x, double rotation, double gate){
        m_frontLeft.setPower(y + x + rotation); // Note: pushing stick forward gives negative value
        m_rearLeft.setPower(y - x + rotation);
        m_frontRight.setPower(y - x - rotation);
        m_rearRight.setPower(y + x - rotation);
        m_Servo.setPosition(gate);
    }

}
