import java.util.Scanner;

public class SortingByCounting {
    /*
    Первая строка содержит число n, вторая — n натуральных чисел, не превышающих 10.
    Выведите упорядоченную по неубыванию последовательность этих чисел.
     */
    int n;
    int[] ar;
    static final int M = 11;
    int[] count = new int[M];

    public static void main(String[] args) {
        new SortingByCounting().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ar = new int[n];
        for (int i=0; i<n; i++) {
            ar[i] = sc.nextInt();
            count[ar[i]]++;
        }

        for (int i=0; i<M; i++) {
            for (int j=0; j<count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
