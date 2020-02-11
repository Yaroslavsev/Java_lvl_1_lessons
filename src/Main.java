public class Main {
    //Задание 1
    public static void main(String[] args) {
        byte a = 125;
        short b = 32750;
        int c = 2147483643;
        long d = 9223372036854775802L;
        float e = 2147483641.25f;
        double f = 2147483641.36;
        char g = '0';
        boolean h = false;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
    }

    //Задание 2
    public static void main(String[] args) {
        float a = 22.7f;
        float b = 33.1f;
        float c = 14.8f;
        float d = 89.5f;
        System.out.println(a * (b + (c / d)));
    }

    //Задание 3
    public static boolean sum10or20(int a, int b) {
        if (((a + b) > 10) && ((a + b) <= 20)) {
            return true;
        } else {
            return false;
        }
    }

    //Задание 4
    public static void oddOrEven(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //Задание 5
    public static boolean isNegative(int a) {
        if (a >= 0) {
            return false;
        } else {
            return true;
        }
    }

    //Задание 6
    public static void greetings(String a) {
        System.out.println("Привет, " + a + "!");
    }

    //Задание 7
    public static void leapYear(int a) {
        if (a % 4 != 0 || a % 100 == 0 & a % 400 != 0 ) {
            System.out.println("Год не высокосный");
        } else {
            System.out.println("Год высокосный");
        }
    }

}
