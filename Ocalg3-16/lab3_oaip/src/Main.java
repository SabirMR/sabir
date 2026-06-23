import java.util.Scanner;

import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты точки x и y:");
        System.out.print("x = ");
        double x = in.nextDouble();
        System.out.print("y = ");
        double y = in.nextDouble();
        String s = "";
        int i = 0;
        double pl = 0;
        if (x == 0 && y == 0) {
            s = "в начале координат";
        } else if (pow(x, 2) + pow(y - 1, 2) > 1 && pow(x + 1, 2) + pow(y, 2) > 1 && x > -2 && y < 2 && x < 0 && y > 0) {
            s = "в области М1";
            i = 1;
        } else if (pow(x, 2) + pow(y, 2) < 1 && pow(x, 2) + pow(y - 1, 2) < 1 && x < 0) {
            s = "в области М2";
            i = 2;
        } else if (pow(x, 2) + pow(y, 2) > 1 && pow(x - 1, 2) + pow(y, 2) < 1 && y < 0 && x < 1) {
            s = "в области М3";
            i = 3;
        } else if (pow(x, 2) + pow(y + 1, 2) < 1 && pow(x, 2) + pow(y, 2) > 1 && x < 0) {
            s = "в области М4";
            i = 4;
        } else if (pow(x, 2) + pow(y + 1, 2) > 1 && y < -1 && x > 0 && y > -2 && x < 2) {
            s = "в области М5";
            i = 5;
        } else {
            s = "вне всех обозначенных областей";
        }
        System.out.println("Положение точки: " + s);
        switch (i) {
            case 1:
                pl = 1 + (1 - PI / 4) * 2;
                break;
            case 2:
                pl = PI / 3 - sqrt(3) / 4;
                break;
            case 3:
                pl = sqrt(3) / 4 - PI / 12;
                break;
            case 4:
                pl = PI / 4 + sqrt(3) / 4 - PI / 12;
                break;
            case 5:
                pl = 1 + (1 - PI / 4);
                break;
        }
        if (i != 0) System.out.printf("Площадь М%d: %.3f", i, pl);
    }
}