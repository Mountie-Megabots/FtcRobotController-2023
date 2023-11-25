package DriveBaseRed;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class DriveBase {
    public LinearOpMode opMode;
    DcMotor m_frontLeft;
    DcMotor m_frontRight;
    DcMotor m_rearLeft;
    DcMotor m_rearRight;
    Servo m_Servo;
    Servo m_airServo;
    DcMotor m_climber;


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
    }


    public void drive(double y, double x, double rotation){
        m_frontLeft.setPower(y + x + rotation); // Note: pushing stick forward gives negative value
        m_rearLeft.setPower(y - x + rotation);
        m_frontRight.setPower(y - x - rotation);
        m_rearRight.setPower(y + x - rotation);

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



