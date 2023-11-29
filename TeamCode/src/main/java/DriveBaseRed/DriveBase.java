package DriveBaseRed;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class DriveBase {
    public LinearOpMode opMode;
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    Servo m_Servo;
    Servo m_airServo;
    DcMotor m_climber;
    IMU imu;



    public DriveBase(LinearOpMode opMode) {
        this.opMode = opMode;
        m_frontLeft = opMode.hardwareMap.get(DcMotor.class, "frontLeft");
        m_frontRight = opMode.hardwareMap.get(DcMotor.class, "frontRight");
        m_rearLeft = opMode.hardwareMap.get(DcMotor.class, "rearLeft");
        m_rearRight = opMode.hardwareMap.get(DcMotor.class, "rearRight");
        m_climber = opMode.hardwareMap.get(DcMotor.class, "Climber");
        m_Servo = opMode.hardwareMap.get(Servo.class, "Servo");
        m_airServo = opMode.hardwareMap.get(Servo.class, "airServo");

        m_frontLeft.setDirection(DcMotor.Direction.REVERSE);
        m_rearLeft.setDirection(DcMotor.Direction.REVERSE);
        m_frontRight.setDirection(DcMotor.Direction.FORWARD);
        m_rearRight.setDirection(DcMotor.Direction.FORWARD);

        // Retrieve the IMU from the hardware map
        imu = opMode.hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);


    }
    public double getIMU() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public void drive(double y, double x, double rotation){
        m_frontLeft.setPower(y + x + rotation); // Note: pushing stick forward gives negative value
        m_rearLeft.setPower(y - x + rotation);
        m_frontRight.setPower(y - x - rotation);
        m_rearRight.setPower(y + x - rotation);

    }

    public void driveWithIMU(double y, double x, double delay){
        double startTime = opMode.getRuntime();
        double delayMS = delay/1000;
        double startAngle = this.getIMU();

        while(opMode.getRuntime() < (startTime+delayMS)){
            this.drive(y, x, (this.getIMU()-startAngle)/90);
        }
    }

    public void setClimberPower(double power){
        m_climber.setPower(power);
    }

    public void gatepos(double pos){
        m_Servo.setPosition(pos);
    }

    public void airstate(double state){
        m_airServo.setPosition(state);
    }


}



