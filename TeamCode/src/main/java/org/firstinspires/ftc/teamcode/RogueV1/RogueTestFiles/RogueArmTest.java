package org.firstinspires.ftc.teamcode.RogueV1.RogueTestFiles;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.RogueV1.RogueAutoMethods;

/**
 * Created by samue on 11/29/2016.
 */
@Autonomous(name="hola", group="hi")
@Disabled
public class RogueArmTest extends RogueAutoMethods {

    public void runOpMode() throws InterruptedException {
        setupAll();
        waitForStart();
        leftOut();
        rightOut();
        leftIn();
        rightIn();
    }
}
