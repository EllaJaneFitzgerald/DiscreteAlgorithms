import java.util.ArrayList;
import java.util.Scanner;

class Decomposition {
    /*
    По данному числу n найдите максимальное число k, для которого n можно представить
    как сумму k различных натуральных слагаемых.
     */

    public static void main(String[] args) {
        new Decomposition().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> decomposition = new ArrayList<Integer>();
        if (n==2){
            decomposition.add(2);
        } else {
            decomposition.add(1);
        }
        int size = 1;
        n = n-decomposition.get(size-1);

        while (n>0) {
            if (n-decomposition.get(size-1) - 1 <= decomposition.get(size-1) + 1) {
                decomposition.add(n);
                n = 0;
            } else {
                decomposition.add(decomposition.get(size-1) + 1);
                n = n -(decomposition.get(size-1) + 1);
            }
            size++;
        }

        System.out.println(size);
        for (int i=0; i<size; i++) {
            System.out.print(decomposition.get(i) + " ");
        }
    }
}