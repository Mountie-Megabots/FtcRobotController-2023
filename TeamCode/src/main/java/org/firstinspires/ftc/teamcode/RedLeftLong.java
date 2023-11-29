package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import DriveBaseRed.DriveBase;


@Autonomous(name="Red Left Long Auto", group="Basic")
public class RedLeftLong extends LinearOpMode {

    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);


        telemetry.addData("Status", "Initialized");
        telemetry.addData("IMU", robot.getIMU());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        sleep(10000);
        //drive sideways
        robot.driveWithIMU(0,-.5,75);
        robot.driveWithIMU(0,0,0);

        //drive forward
        robot.driveWithIMU(.7, 0, 2000);
        robot.driveWithIMU(0,0,0);


        //drive backwards
        //drive(-0.7, 0, 0,1);
        robot.gatepos(1);
        robot.driveWithIMU(-0.7, 0, 470);
        //drive(0,0,0,0.3);
        robot.gatepos(.3);

        robot.drive(0,0,0);
        //drive forward
        robot.driveWithIMU(0.7, 0,600);

        robot.drive(0,0,0);
    }
}
