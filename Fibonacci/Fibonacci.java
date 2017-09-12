import java.util.Scanner;

public class Fibonacci {

    public static int getFibonacci (int n) {
        if (n==0) return 0;
        int prev = 0;
        int cur = 1;
        int next;

        for (int i=2; i<=n; i++) {
            next = prev + cur;
            prev = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibonacci.getFibonacci(n));
    }
}
