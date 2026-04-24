import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите a=");
        String aa = in.nextLine();
        System.out.print("Введите b=");
        String bb = in.nextLine();

        try{
            int a = Integer.parseInt(aa);
            int b = Integer.parseInt(bb);
            System.out.println(Calc.calc(a, b));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введено не целое число!");
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль!");
            System.out.println("Запустите программу заново!");
        }
    }
}
class Calc {
    static double calc(int a, int b) {
        if (a > b) {
            if (b == 0) {
            throw new ArithmeticException("zero");
        }
            return (double) a / b + 1.0;
        } else if ( a == b) {
            return a + 25.0;
        } else { // a < b
            if (a == 0) {
                throw new ArithmeticException("zero");
            }
            return (double) (a * b - 2.0) / a;
        }
    }
}