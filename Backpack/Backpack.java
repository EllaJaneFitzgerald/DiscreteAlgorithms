import java.util.Scanner;

public class Backpack {
    /*
    Первая строка входа содержит целые числа W и n — вместимость рюкзака и число золотых
    слитков. Следующая строка содержит n целых чисел w1,…,wn, задающих веса слитков.
    Найдите максимальный вес золота, который можно унести в рюкзаке.
     */

    public static void main(String[] args) {
        new Backpack().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();
        int[] sub = new int[n];

        for (int i=0; i<n; i++) {
            sub[i] = sc.nextInt();
        }
        int[][] d = new int[w+1][n+1];

        for (int i=0; i<n+1; i++) {
            d[0][i] = 0;
        }
        for (int i=0; i<w+1; i++) {
            d[i][0] = 0;
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<w+1; j++) {
                d[j][i] = d[j][i-1];
                if (sub[i-1] <=j) {
                    d[j][i] = Math.max(d[j][i], d[j-sub[i-1]][i-1] + sub[i-1]);
                }
            }
        }
        System.out.println(d[w][n]);
    }
}
