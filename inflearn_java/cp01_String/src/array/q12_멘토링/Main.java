package array.q12_멘토링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(int[][] arr, int n) {

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < arr.length; k++) {
                    int rankI = 0;
                    int rankJ = 0;
                    for (int l = 0; l < arr[k].length; l++) {
                        if (arr[k][l] == i) rankI = l;
                        if (arr[k][l] == j) rankJ = l;
                    }
                    if (rankI < rankJ) cnt++;
                }
                if (cnt == arr.length) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] length = br.readLine().split(" ");
        int m = Integer.parseInt(length[0]);
        int n = Integer.parseInt(length[1]);

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        Main main = new Main();
        System.out.println(main.solution(arr, m));
    }
}
