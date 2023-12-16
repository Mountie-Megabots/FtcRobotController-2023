/*
@TeleOp(name="Encoder Test", group="Demo")
public class EncoderTest extends LinearOpMode{
    // Definitions
    DcMotorEx yLeftEncoder;
    DcMotorEx yRightEncoder;
    DcMotorEx xEncoder;

    @Override
    public void runOpMode() {
        //Initialization code
        xEncoder = hardwareMap.get(DcMotorEx.class,"rearLeft");
        yLeftEncoder = hardwareMap.get(DcMotorEx.class,"frontRight");
        yRightEncoder = hardwareMap.get(DcMotorEx.class,"rearRight");
        waitForStart();


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("X Encoder", xEncoder.getCurrentPosition());
            telemetry.addData("yLeft Encoder", yLeftEncoder.getCurrentPosition());
            telemetry.addData("yRight Encoder", yRightEncoder.getCurrentPosition());
            telemetry.update();

        }
    }
}
*/