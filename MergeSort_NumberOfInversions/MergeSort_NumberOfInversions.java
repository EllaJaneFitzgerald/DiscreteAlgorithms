import java.util.Scanner;

class MergeSort_NumberOfInversions {
    /*
    Первая строка содержит число n, вторая — массив A[1…n], содержащий натуральные числа.
    Необходимо посчитать число пар индексов i<j, для которых A[i]>A[j].
     */

    int n;
    int[] array;
    int[] arraySorted;
    long counter = 0;

    public static void main(String[] args) {
        new MergeSort_NumberOfInversions().run();
    }

    private void merge(int l, int m, int r) {
        int localCounter = m + 1 - l;
        int pointerL = l;
        int pointerR = m + 1;
        for (int i=l; i<=r; i++) {
            if (pointerL>m) {
                for (int j=pointerR; j<=r; j++) {
                    arraySorted[i] = array[j];
                    i++;
                }
                break;
            }
            if (pointerR>r) {
                for (int j=pointerL; j<=m; j++) {
                    arraySorted[i] = array[j];
                    i++;
                }
                break;
            }
            if (array[pointerL] > array[pointerR]) {
                counter += localCounter;
                arraySorted[i] = array[pointerR];
                pointerR++;
            } else {
                arraySorted[i] = array[pointerL];
                localCounter--;
                pointerL++;
            }
        }
        for (int i=l; i<=r; i++) {
            array[i] = arraySorted[i];
        }
    }

    private void sort(int l, int r) {
        if (l!=r) {
            int m = l + (r - l) / 2;
            sort(l,m);
            sort(m+1,r);
            merge(l,m,r);
        }
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new int[n];
        arraySorted = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = sc.nextInt();
            arraySorted[i] = array[i];
        }

        sort(0,n-1);
        System.out.println(counter);
    }
}
