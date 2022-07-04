package array.q10_봉우리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public int solution(int[][] arrays, int n) {
        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (arrays[i][j] > arrays[i][j - 1] && arrays[i][j] > arrays[i][j + 1] && arrays[i][j] > arrays[i + 1][j] && arrays[i][j] > arrays[i - 1][j])
                    answer++;
            }
        }
        return answer;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arrays = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                arrays[i + 1][j + 1] = Integer.parseInt(s[j]);
            }
        }

        Main main = new Main();
//        for (int i = 0; i < n + 2; i++) {
//            System.out.println(Arrays.toString(arrays[i]));
//        }
        System.out.println(main.solution(arrays, n));
    }
}
