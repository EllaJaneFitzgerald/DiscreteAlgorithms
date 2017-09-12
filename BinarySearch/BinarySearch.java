import java.util.*;

class BinarySearch {
    int n;
    int[] array;

    public static void main(String[] args) {
        new BinarySearch().run();
    }

    private int binarySearch(int key) {
        int l = 0;
        int r = n-1;
        int m;

        while (l <= r) {
            m = (l+r) / 2;
            if (array[m] == key) {
                return m + 1;
            } else if (array[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    private void run() {
        /*
        В первой строке даны целое число n и массив A[1…n] из n различных натуральных
        чисел в порядке возрастания, во второй — целое число k и k натуральных чисел
        b1,…,bk. Для каждого i от 1 до k необходимо вывести индекс j, для которого
        A[j]=bi, или −1, если такого j нет.
         */

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int[] response = new int[k];
        for (int i=0; i<k; i++) {
            response[i] = binarySearch(sc.nextInt());
        }

        for (int i=0; i<k; i++) {
            System.out.print(response[i] + " ");
        }
    }
}
