package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
public class DriveBaseIMU {
    public LinearOpMode opMode;
    IMU imu;


    public DriveBaseIMU(LinearOpMode opmode) {
        this.opMode = opmode;


        // Retrieve the IMU from the hardware map
        imu = opmode.hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        opMode.telemetry.addData("Orientation Value", getIMU());


    }

    public double getIMU(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

}