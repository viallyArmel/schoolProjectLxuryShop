package com.example.henallux.luxuryshopProject;

import java.text.DecimalFormat;

public class DecimalFormater {

    public static double format(double value, int nbDecimals) {
        if (nbDecimals < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, nbDecimals);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static double format(double value) {
        return format(value, 2);
    }

    public static String fromDoubleToString(double value, int nbDecimals) {
        String format = "0.";
        for(int i = 0; i < nbDecimals; i++)
            format += "0";
        DecimalFormat df = new DecimalFormat(format);
        return df.format(value);
    }

    public static String fromDoubleToString(double value) {
        return fromDoubleToString(value, 2);
    }
}
