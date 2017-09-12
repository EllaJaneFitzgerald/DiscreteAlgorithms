
import java.util.Scanner;

public class Euclid {

    public static int algEuclid(int x, int y) {

        if (x == 0) {
            return y;
        } else if (y == 0) {
            return x;
        } else if (x >= y) {
            return algEuclid(Math.floorMod(x,y),y);
        } else {
            return algEuclid(Math.floorMod(y,x),x);
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(algEuclid(a,b));
    }
}
