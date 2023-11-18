package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import DriveBaseRed.DriveBase;

@TeleOp(name="RedTeleOp", group="Basic")
public class RedTeleOp extends LinearOpMode{
    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;// Note: pushing stick forward gives negative value
            double x = gamepad1.left_stick_x;
            double rotation = Math.pow(gamepad1.right_stick_x,3)/1.5;

            robot.drive(x,y,rotation);
            robot.setClimberPower(gamepad2.right_stick_y);

            if (gamepad2.a){
                robot.gatepos(1);
            }
            else {
                robot.gatepos(0.3);
            }

            //change this to allow airplane launch
            if (gamepad2.y){
                robot.airstate(0.3);
            }
            else {
                robot.airstate(0);
            }




        }

    }

}