package org.firstinspires.ftc.teamcode.BlackTeamRed_Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;

@Autonomous(name="RedRight_RightCornerAuto", group="Basic")
public class RedRight_RightCorner extends LinearOpMode{

    DcMotor m_intake;
    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);



        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        robot.driveWithIMU(0,-0.5,100);
        robot.driveWithIMU(0.2, 0, 6000);
        robot.intake_up();
        robot.driveWithIMU(-.5,0,300);
        robot.driveWithIMU(0,0,0);

    }



}
