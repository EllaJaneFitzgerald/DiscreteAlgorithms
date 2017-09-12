import java.util.*;

class PriorityQueue {
    int[] queue;
    int queueSize = 0;

    void siftUp(int i) {
        int ch;
        int parIndex = (i-1)/2;
        while (queue[i] > queue[parIndex]) {
            ch = queue[i];
            queue[i] = queue[parIndex];
            queue[parIndex] = ch;
            i = parIndex;
            parIndex = (i-1)/2;
        }
    }

    void siftDown(int i) {
        int chL, chR, max, a;

        while (2*(i+1)-1 < queueSize) {
            chL = 2*(i+1)-1;
            chR = 2*(i+1);
            max = chL;

            if ((chR < queueSize) && (queue[chR] > queue[chL])) {
                max = chR;
            }
            if (queue[i] < queue[max]) {
                a = queue[i];
                queue[i] = queue[max];
                queue[max] = a;
                i = max;
            } else {
                break;
            }
        }
    }

    void insert(int x) {
        queue[queueSize] = x;
        queueSize++;
        siftUp(queueSize-1);
    }

    int extractMax() {
        int max = queue[0];
        queue[0] = queue[queueSize-1];
        queueSize--;
        siftDown(0);
        return max;
    }

    public static void main(String[] args) {
        new PriorityQueue().run();
    }

    public void run(){
        /* Формат вводимых данных:
            6
            Insert 200
            Insert 10
            ExtractMax
            Insert 5
            Insert 500
            ExtractMax
         */

        ArrayList<Integer> response = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        queue = new int[n];
        sc.nextLine();
        int x = 0;

        StringBuilder sb = new StringBuilder("");
        for (int j=0; j<n; j++) {

            sb.append(sc.nextLine());
            if (sb.charAt(0) == 'I') {
                sb.delete(0,7);
                x = Integer.parseInt(sb.toString());
                insert(x);
            }
            if (sb.charAt(0) == 'E') {
                response.add(extractMax());
            }
            sb.delete(0,sb.length());
        }
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i));
        }
    }
}
