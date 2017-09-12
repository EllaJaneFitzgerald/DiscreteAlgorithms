import java.util.Scanner;

public class LongestDividerSubsequence {
    /*
    Дано целое число n и массив A[1…n] натуральных чисел. Выведите максимальное k,
    для которого найдётся подпоследовательность 1≤i1<i2<…<ik≤n длины k, в которой
    каждый элемент делится на предыдущий.
     */

    int n;
    int[] ar;
    int[] d;

    public static void main(String[] args) {
        new LongestDividerSubsequence().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ar = new int[n];
        d = new int[n];

        for (int i=0; i<n; i++) {
            ar[i] = sc.nextInt();
            d[i] = 1;
            for (int j=0; j<i; j++) {
                if (Math.floorMod(ar[i],ar[j]) == 0 && d[j] + 1 > d[i]) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            if (d[i] > res) {
                res = d[i];
            }
        }
        System.out.print(res);
    }
}
