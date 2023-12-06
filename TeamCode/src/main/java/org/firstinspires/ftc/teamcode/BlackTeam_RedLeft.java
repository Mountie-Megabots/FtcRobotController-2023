package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;

@Autonomous(name="BlackTeam - Red Left Auto", group="Basic")
public class BlackTeam_RedLeft extends LinearOpMode{

    DcMotor m_intake;
    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        robot.driveWithIMU(0, -0.5, 0);
        sleep(100);
        robot.driveWithIMU(0.5,0,0);
        sleep(3750);
        robot.drive(-0.5,0,0);
        m_intake.setPower(-.5);
        sleep(900);
        m_intake.setPower(0);
        robot.driveWithIMU(0.5,0,1000);
        robot.drive(0,0,0);






        }



}
