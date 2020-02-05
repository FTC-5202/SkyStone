package org.firstinspires.ftc.teamcode;


import android.graphics.Color;
import android.app.Activity;
import android.view.View;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import org.firstinspires.ftc.robotcore.external.JavaUtil;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

@TeleOp(name = "colorSensor (Blocks to Java)", group = "")


public class ColorSensorBlocks extends LinearOpMode {


    private ColorSensor sensorColorRangeAsREVColorRangeSensor;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        sensorColorRangeAsREVColorRangeSensor = hardwareMap.colorSensor.get("sensorColorRangeAsREVColorRangeSensor");

        // This op mode demonstrates the color and distance features of the REV sensor.
        telemetry.addData("Color Distance Example", "Press start to continue...");
        telemetry.update();
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Display distance info.
                telemetry.addData("Dist to tgt (cm)", ((DistanceSensor) sensorColorRangeAsREVColorRangeSensor).getDistance(DistanceUnit.CM));
                // Display reflected light.
                telemetry.addData("Light detected", ((OpticalDistanceSensor) sensorColorRangeAsREVColorRangeSensor).getLightDetected());
                // Convert RGB values to HSV color model.
                // See https://en.wikipedia.org/wiki/HSL_and_HSV for details on HSV color model.
                int colorHSV = Color.argb(sensorColorRangeAsREVColorRangeSensor.alpha(), sensorColorRangeAsREVColorRangeSensor.red(),
                        sensorColorRangeAsREVColorRangeSensor.green(), sensorColorRangeAsREVColorRangeSensor.blue());
                // Get hue.
                float hue = JavaUtil.colorToHue(colorHSV);
                telemetry.addData("Hue", hue);
                // Get saturation.
                float sat = JavaUtil.colorToSaturation(colorHSV);
                telemetry.addData("Saturation", sat);
                // Get value.
                float val = JavaUtil.colorToValue(colorHSV);
                telemetry.addData("Value", val);
                // Use hue to determine if it's red, green, blue, etc..
                if (hue < 30) {
                    telemetry.addData("Color", "Red");
                } else if (hue < 60) {
                    telemetry.addData("Color", "Orange");
                } else if (hue < 90) {
                    telemetry.addData("Color", "Yellow");
                } else if (hue < 150) {
                    telemetry.addData("Color", "Green");
                } else if (hue < 225) {
                    telemetry.addData("Color", "Blue");
                } else if (hue < 350) {
                    telemetry.addData("Color", "purple");
                } else {
                    telemetry.addData("Color", "Red");
                }
                // Check to see if it might be black or white.
                if (sat < 0.2) {
                    telemetry.addData("Check Sat", "Is surface white?");
                }
                telemetry.update();
                if (val < 0.16) {
                    telemetry.addData("Check Val", "Is surface black?");
                }
            }
        }
    }

}
