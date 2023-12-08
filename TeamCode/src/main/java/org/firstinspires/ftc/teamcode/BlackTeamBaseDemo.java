package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.DriveBase;

@Disabled
@Autonomous(name="BlackTeam-Red Right Aut", group="Basic")
public class BlackTeamBaseDemo extends LinearOpMode{
    DriveBase robot;

    @Override
    public void runOpMode() {
        robot = new DriveBase(this);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        
        robot.drive(1, 0, 0);
        sleep(500);
        robot.drive(0,-1,0);
        sleep(200);
        //m_elevator.setPower(1);
        sleep(1000);
        //m_pixelspinner.setPosition(1);
        sleep(500);
        //robot.pixgrabber_setSpot(1);

    }


}
