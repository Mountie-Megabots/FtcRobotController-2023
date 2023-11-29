package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import DriveBaseRed.DriveBase;


@Autonomous(name="Red Left Auto", group="Basic")
public class basicautonomous1 extends LinearOpMode{
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    Servo m_Servo;

    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);


        telemetry.addData("Status", "Initialized");
        telemetry.addData("IMU", robot.getIMU() );
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        //drive sideways

        robot.driveWithIMU(0, -0.7, 1700);
        robot.driveWithIMU(0,0,0);

        //drive forward
        robot.driveWithIMU(0.7, 0, 1800);
        robot.driveWithIMU(0,0,1100);


        //drive backwards
        robot.driveWithIMU(-0.7, 0, 470);

        robot.drive(0,0,0);
        //drive forward
        robot.driveWithIMU(0.7, 0,480);

        robot.drive(0,0,0);
        }



}
