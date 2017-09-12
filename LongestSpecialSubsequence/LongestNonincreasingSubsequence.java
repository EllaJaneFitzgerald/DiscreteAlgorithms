import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestNonincreasingSubsequence {
    /*
    Дано целое число n и массив A[1…n], содержащий неотрицательные целые числа.
    Найдите наибольшую невозрастающую подпоследовательность в A. В первой строке
    выведите её длину k, во второй — её индексы  1≤i1<i2<…<ik≤n.
     */
    int n;
    int[] ar;
    int[][] d;
    int[] prev;

    public static void main(String[] args) throws IOException {
        new LongestNonincreasingSubsequence().run();
    }

    private int upperBound(int l, int r, int key) {
        int m;

        while (l < r) {
            m = (l+r) / 2;
            if (d[m][0] >= key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (d[l][0] < key) {
            return l;
        }
        return l+1;
    }

    private void run() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        ar = new int[n];
        d = new int[n+1][2];
        prev = new int[n];

        String[] ar2 = input.readLine().split(" ");

        for (int i=0; i<n; i++) {
            ar[i] = Integer.parseInt(ar2[i]);
            d[i][0] = -2000000000;
            d[i][1] = -1;
        }
        d[0][0] = 2000000000;
        d[0][1] = -1;
        d[n][0] = -2000000000;
        d[n][1] = -1;

        //заполнение массива d
        for (int i=0; i<n; i++) {
            int j = upperBound(0, n-1, ar[i]);

            if (d[j-1][0] >= ar[i] && ar[i] > d[j][0]) {
                prev[i] = d[j-1][1];
                d[j][0] = ar[i];
                d[j][1] = i;
            }
        }

        //восстановление ответа
        int res = -2000000000;
        int arg = n;
        for (int i=n; i>=0; i--) {
            if (d[i][0] > res) {
                res = d[i][1];
                arg = i;
                break;
            }
        }
        System.out.println(arg);
        int[] ans = new int[arg];

        while (arg>0) {
            arg--;
            ans[arg] = res;
            res = prev[res];
        }

        for (int i=0; i<ans.length; i++) {
            System.out.print(ans[i]+1 + " ");
        }
    }
}
