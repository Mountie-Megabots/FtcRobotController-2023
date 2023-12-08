package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Robot.DriveBase;
import org.firstinspires.ftc.teamcode.Robot.DriveBaseIMU;


@TeleOp(name="BlackTeleOp", group="Basic")
public class BlackTeleOp extends LinearOpMode{
    DriveBase robot;
    DriveBaseIMU robotIMU;
    boolean pixelspinnerval = true;
    boolean previousBumper = false;
    Servo m_DroneLauncher;

    DcMotorEx ElevatorEncoder;


    @Override
    public void runOpMode() {
        robot = new DriveBase(this);
        robotIMU = new  DriveBaseIMU(this);

        ElevatorEncoder = hardwareMap.get(DcMotorEx.class,"elevator" );
        m_DroneLauncher = hardwareMap.get(Servo.class,"Drone Launcher");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y;// Note: pushing stick forward gives negative value
            double x = gamepad1.left_stick_x;
            double rotation = gamepad1.right_stick_x;
            if (gamepad1.right_stick_x > 0){
                rotation += 0.5;
            }




            robot.drive(y,x,rotation);
            robot.intake_setPower(gamepad2.a);



            /*robot.pixgrabberPosition(gamepad2.right_bumper);

            robot.pixspinnerToggle(gamepad1.left_bumper);*/
            robot.elevator_setPower(-gamepad2.left_stick_y);

            if (gamepad2.right_bumper && gamepad2.a){
                m_DroneLauncher.setPosition(1);
            }
            else {
                m_DroneLauncher.setPosition(.7);
            }


          /*  if (ElevatorEncoder.getCurrentPosition() <= 0 ){
                    if (-gamepad2.right_stick_y == 1){
                        robot.elevator_setPower(-gamepad2.left_stick_y);
                    }
            }
            else if (ElevatorEncoder.getCurrentPosition() > 0){
                robot.elevator_setPower(-gamepad2.left_stick_y);
            }*/


        }

    }


}