package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;


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
    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        robot.driveWithIMU(0,0.5,100);
        robot.driveWithIMU(0.2, 0, 6000);
        robot.intake_up();
        robot.driveWithIMU(-.5,0,300);
        robot.driveWithIMU(0,0,0);





    }


    }