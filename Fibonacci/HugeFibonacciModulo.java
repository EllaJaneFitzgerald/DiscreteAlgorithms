import java.util.ArrayList;
import java.util.Scanner;

public class HugeFibonacciModulo {
    /*
    Даны целые числа n и m, необходимо найти остаток от деления n-го числа Фибоначчи на m.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();

        ArrayList<Integer> l = new ArrayList<Integer>();

        int a = 0;
        l.add(a);
        int b = 1;
        l.add(b);
        int c;
        long period=0;
        boolean flag=false;
        for (int i=2; i<=n; i++) {
            c = b;
            b = Math.floorMod(a + b, m);
            a = c;
            period++;
            if ((l.get(0)==a)&&(l.get(1)==b)) {
                flag=true;
                break;
            }
        }

        long h;
        if (flag) {
            h=Math.floorMod(n,period);
        } else {
            h=n;
        }

        if (h==0) {
            System.out.println(0);
        }
        if (h==1) {
            System.out.println(1);
        }
        if ((h!=0)&&(h!=1)) {
            a=0;
            b=1;
            long j=2;
            while (j<=h){
                c = b;
                b = Math.floorMod(a + b, m);
                a = c;
                j++;
            }
            System.out.println(b);
        }
    }
}
