import model.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите x=");
        double x = in.nextDouble();
        System.out.println(Calculator.calc(x));
    }
}