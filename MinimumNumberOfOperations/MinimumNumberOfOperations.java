import java.util.ArrayList;
import java.util.Scanner;

public class MinimumNumberOfOperations {
    /*
    У вас есть примитивный калькулятор, который умеет выполнять всего три операции
    с текущим числом x: заменить x на 2x, 3x или x+1. По данному целому числу n
    определите минимальное число операций k, необходимое, чтобы получить n из 1.
    Выведите k и последовательность промежуточных чисел.
     */

    public static void main(String[] args) {
        new MinimumNumberOfOperations().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prev = new int[n+1];
        int[] d = new int[n+1];

        d[1] = 0;
        int a,b,c,min;
        for (int i=2; i<n+1; i++){
            a = Math.floorMod(i,2)==0 ? d[i/2] : 100000000;
            b = Math.floorMod(i,3)==0 ? d[i/3] : 100000000;
            c = d[i-1];
            min = Math.min(Math.min(a,b),c);
            if (a==min) {
                prev[i] = i/2;
            } else if (b==min) {
                prev[i] = i/3;
            } else {
                prev[i] = i-1;
            }
            d[i] = min + 1;
        }

        System.out.println(d[n]);
        ArrayList<Integer> res = new ArrayList<Integer>();
        int k = n;
        while (k>=1) {
            res.add(k);
            k = prev[k];
        }
        for (int i=res.size()-1; i>=0; i--) {
            System.out.print(res.get(i) + " ");
        }
    }
}
