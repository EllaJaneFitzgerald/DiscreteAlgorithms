import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EditDistance {
    /*
    Вычислите расстояние редактирования двух данных непустых строк,
    содержащих строчные буквы латинского алфавита.
     */

    public static void main(String[] args) throws IOException {
        System.out.println(new EditDistance().run());
    }

    private int diff(char a, char b) {
        if (a == b) {
            return 0;
        }
        return 1;
    }

    private int run() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();

        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }

        int m = s1.length();
        int n = s2.length();
        int[] cur = new int[m+1];
        int[] prev = new int[m+1];
        for (int j=0; j<m+1; j++) {
            prev[j] = j;
        }

        for (int i=1; i<n+1; i++) {
            for (int j=0; j<m+1; j++) {
                if (j == 0) {
                    cur[j] = i;
                } else {
                    cur[j] = Math.min(cur[j-1]+1, Math.min(prev[j]+1, prev[j-1] + diff(s1.charAt(j-1), s2.charAt(i-1))));
                }
            }
            for (int j=0; j<m+1; j++) {
                prev[j] = cur[j];
            }
        }
        return cur[m];
    }
}
