package com.fitnesstracker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FitnessTrackerController {

    public static ArrayList<String> getIntensities() {
        ArrayList<String> intense = new ArrayList<>();
        for (int i = 50; i <= 85; i += 5) {
            intense.add(Integer.toString(i));
        }
        return intense;
    }

    private static double formatDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.CEILING);
        return Double.valueOf(df.format(value));
    }

    // estimate HRmax which is relative the one's age
    private static double getEstimatedHRmax(int age) {
        return (206.3 - (0.711 * age));
    }

    // Return value without estimating the value heart rate maximum
    private static double getTHRUnEstimatedHRmax(double HRmax, double HRrest, double intensity) {
        return ((HRmax - HRrest) * intensity / 100) + HRrest;
    }

    public static ResultModel calculateTHR(int age, double HRmax, double HRrest, int intensity) {
        double HRreserve = getEstimatedHRmax(age) - HRrest;
        double estimated = formatDecimal((HRreserve * ((double) intensity / 100)) + HRrest);
        double unEstimated = formatDecimal(getTHRUnEstimatedHRmax(HRmax, HRrest, intensity));
        return new ResultModel(unEstimated, estimated);
    }
}