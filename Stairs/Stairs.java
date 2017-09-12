import java.util.Scanner;

class Stairs {
    /*
    Даны число n ступенек лестницы и целые числа a1,…,an, которыми помечены ступеньки.
    Найдите максимальную сумму, которую можно получить, идя по лестнице снизу вверх
    (от нулевой до n-й ступеньки), каждый раз поднимаясь на одну или две ступеньки.
     */

    public static void main(String[] args) {
        new Stairs().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] stairs = new int[n];
        for (int i=0; i<n; i++) {
            stairs[i] = sc.nextInt();
        }

        int[] d = new int[n];
        d[0] = stairs[0];
        if (n>1) {
            d[1] = Math.max(d[0] + stairs[1], stairs[1]);
            for (int i=2; i<n; i++) {
                d[i] = Math.max(d[i-1] + stairs[i], d[i-2] + stairs[i]);
            }
        }
        System.out.println(d[n-1]);
    }
}

