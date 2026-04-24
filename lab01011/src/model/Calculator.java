package model;

public class Calculator {

    public static String calc(double x){
        final double a = 1.5;
        final double b = 0.5;

        double y=Math.log(b * x + a * a) * (a * x * Math.atan(x) - Math.sqrt(x) + Math.log(Math.abs(b + x) + 1));
        double F=Math.sqrt((a * x * x + x + 4) + Math.exp(-a * x));
        return String.format("y=%.2f F=%.3f%n", y, F);
    }
}

