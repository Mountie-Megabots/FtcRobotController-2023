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


        robot.driveWithIMU(0, -0.5, 100);
        robot.driveWithIMU(0.5,0,3750);
        robot.intake_up();
        robot.driveWithIMU(-0.5,0,900);
        robot.intake_down();
        robot.driveWithIMU(0.5,0,1000);
        robot.drive(0,0,0);






        }



}
