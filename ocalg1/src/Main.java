import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final double a = 1.5,b = 0.5;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите x=");
        double x = in.nextDouble();

        double y=Math.log(b * x + a * a) * (a * x * Math.atan(x) - Math.sqrt(x) + Math.log(Math.abs(b + x) + 1));
        double F=Math.sqrt((a * x * x + x + 4) + Math.exp(-a * x));
        System.out.printf(" При x=%.3f, y=%.2f, F=%.3f", x, y, F);
 }
}