import java.util.Scanner;

public class LastDigitFibonacci {
    public static int getLastDigitFibonacci(int n) {
        if (n==0) return 0;
        int a = 0;
        int b = 1;
        int c;
        for (int i=2; i<=n; i++) {
            c = b;
            b = Math.floorMod(a + b, 10);
            a = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(LastDigitFibonacci.getLastDigitFibonacci(n));
    }
}
