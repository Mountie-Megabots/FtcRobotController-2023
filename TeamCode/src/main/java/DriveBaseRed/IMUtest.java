package DriveBaseRed;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.robotcore.external.navigation.Axis.Y;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

class DriveBaseRed {
    public LinearOpMode opMode;
    IMU imu;


    public DriveBaseRed(LinearOpMode opmode) {
        this.opMode = opmode;


        // Retrieve the IMU from the hardware map
        imu = opmode.hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot

        IMU.Parameters myIMUparameters;

        myIMUparameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        //init IMU using parameters
        imu.initialize(myIMUparameters);




    }

    public double getIMU(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);

        getIMU(y,x,(this.getIMU()-0)/90);


    }

    private void getIMU(Object y, Object x, Object o) {
    }

}