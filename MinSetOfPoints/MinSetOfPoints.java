import java.util.*;

class MinSetOfPoints {
    /*
    По данным n отрезкам необходимо найти множество точек,
    для которого каждый из отрезков содержит хотя бы одну из точек.
     */

    public static void main(String[] args) {
        new MinSetOfPoints().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] cuts = new int[n][2];
        for (int i=0; i<n; i++){
            cuts[i][0] = sc.nextInt();
            cuts[i][1] = sc.nextInt();
        }

        Arrays.sort(cuts, new Comparator<int[]>() {
            @Override
            public int compare(int[] cut1, int[] cut2) {
                return Integer.compare(cut1[1], cut2[1]);
            }
        });

        int sum = 1;
        ArrayList<Integer> points = new ArrayList<Integer>();
        points.add(cuts[0][1]);
        for (int i=1; i<n; i++) {
            if (points.get(sum-1) < cuts[i][0]) {
                sum++;
                points.add(cuts[i][1]);
            }
        }

        System.out.println(sum);
        for (int i=0; i<points.size(); i++) {
            System.out.print(points.get(i) + " ");
        }
    }
}
