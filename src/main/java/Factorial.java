public class Factorial {

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(fact(3));
    }

    public static int fact(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * fact(x - 1);
        }

    }
}
