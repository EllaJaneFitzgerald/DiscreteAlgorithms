import java.util.Random;
import java.util.Scanner;

public class QuickSort_CutsAndPoints {
    /*
    В первой строке задано два целых числа n и m — количество отрезков и точек на прямой,
    соответственно. Следующие n строк содержат по два целых числа ai и bi (ai≤bi) —
    координаты концов отрезков. Последняя строка содержит m целых чисел — координаты точек.
    Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
    Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
     */

    int n;
    int m;
    int[] cutL;
    int[] cutR;
    int[] points;
    Random random = new Random();

    public static void main(String[] args) {
        new QuickSort_CutsAndPoints().run();
    }

    private int[] partition(int[] ar, int l, int r) {
        int[] response = new int[2];
        int referenceElement;
        referenceElement = l + random.nextInt(r-l+1);

        int x = ar[referenceElement];
        ar[referenceElement] = ar[l];
        ar[l] = x;

        int a;
        int j = l;
        int numX = 1;
        for (int i=l+1; i<=r; i++) {
            if (ar[i] < x) {
                j++;
                a = ar[i];
                ar[i] = ar[j];
                ar[j] = a;
            }
            if (ar[i] == x) {
                numX++;
                j++;
                a = ar[j];
                ar[j] = ar[i];
                ar[i] = a;
                ar[j] = ar[l+numX-1];
                ar[l+numX-1] = x;
            }
        }

        response[0] = j-numX;
        response[1] = j+1;

        for (int i=l; i<l+numX; i++) {
            ar[i] = ar[j];
            ar[j] = x;
            j--;
        }
        return response;
    }

    private void sort(int[] ar, int l, int r) {
        int[] m;
        while (l<r) {
            m = partition(ar,l,r);
            if (m[0]-l<=r-m[1]) {
                sort(ar,l,m[0]);
                l = m[1];
            }
        }
    }

    private void quickSort(int[] ar) {
        int l = 0;
        int r = ar.length - 1;
        sort(ar,l,r);
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cutL = new int[n];
        cutR = new int[n];
        points = new int[m];

        for (int i=0; i<n; i++) {
            cutL[i] = sc.nextInt();
            cutR[i] = sc.nextInt();
        }
        quickSort(cutL);
        quickSort(cutR);
        int j;
        int sumL;
        int sumR;
        for (int i=0; i<m; i++) {
            points[i] = sc.nextInt();

            j = 0;
            sumL = 0;
            while ((j<n)&&(points[i]>=cutL[j])) {
                sumL++;
                j++;
            }
            j = 0;
            sumR = 0;
            while ((j<n)&&(points[i]>cutR[j])) {
                sumR++;
                j++;
            }
            System.out.print(sumL-sumR + " ");
        }


        /*System.out.println();
        for (int i=0; i<n; i++) {
            System.out.print(cutL[i] + " ");
        }
        System.out.println();
        for (int i=0; i<n; i++) {
            System.out.print(cutR[i] + " ");
        }     */
    }
}
