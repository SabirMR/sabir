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
        }
        else if (x >= 0 && y >= 1 && (pow(x, 2) + pow(y - 1, 2) <= 1)) {
            s = "в области М1";
            i = 1;
        }
        else if (x >= -2 && x <= -1 && y >= 1 && y <= 2 && (pow(x + 1, 2) + pow(y - 1, 2) > 1)) {
            s = "в области М2";
            i = 2;
        }
        else if (pow(x + 1, 2) + pow(y, 2) < 1 && pow(x, 2) + pow(y - 1, 2) < 1) {
            s = "в области М3";
            i = 3;
        }
        else if (pow(x - 1, 2) + pow(y, 2) < 1 && pow(x, 2) + pow(y + 1, 2) < 1) {
            s = "в области М4";
            i = 4;
        }
        else if x >= -2 && x <= 0 && y >= -2 && y <= -1 && pow(x, 2) + pow(y + 1, 2) > 1 {
            s = "в области М5";
            i = 5;
        }
        else {
            s = "вне всех обозначенных областей";
        }

        System.out.println("Положение точки: " + s);

        switch (i) {
            case 1:
                pl = PI / 4.0;
                break;
            case 2:
                pl = 1.0 - (PI / 4.0);
                break;
            case 3:
                pl = (PI / 2.0) - 1.0;
                break;
            case 4:
                pl = (PI / 2.0) - 1.0;
                break;
          case 5:
    pl = 2.0 - (Math.PI / 4.0);
    break;
        }

        if (i != 0) {
            System.out.printf("Площадь М%d: %.3f%n", i, pl);
        }
    }
}

