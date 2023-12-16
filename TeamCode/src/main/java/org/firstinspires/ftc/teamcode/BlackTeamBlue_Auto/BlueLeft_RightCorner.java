package org.firstinspires.ftc.teamcode.BlackTeamBlue_Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;

@Autonomous(name="BlueLeft_RightCornerAuto", group="Basic")
public class BlueLeft_RightCorner extends LinearOpMode{
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

        robot.intake_down();
        robot.driveWithIMU(0,0.5,100);
        robot.driveWithIMU(0.4,0,1900);
        robot.driveWithIMU(0,0.3,5200);
        robot.driveWithIMU(0.2,0,1500);
        robot.intake_up();
        robot.driveWithIMU(-0.2,0,600);






    }


}