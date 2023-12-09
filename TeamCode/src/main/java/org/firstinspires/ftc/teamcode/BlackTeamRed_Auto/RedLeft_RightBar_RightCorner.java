package org.firstinspires.ftc.teamcode.BlackTeamRed_Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;

@Autonomous(name="RedLeft_RightBar_RightCornerAuto", group="Basic")
public class RedLeft_RightBar_RightCorner extends LinearOpMode{

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
        robot.driveWithIMU(0.5,0,1000);
        robot.drive(0,0,0);






        }



}
