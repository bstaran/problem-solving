package array.q5_에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int solution(int n) {

        int answer=0;
        int[] ch = new int[n+1];
        for (int i=2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j=i; j<=n ;j=j+i) ch[j]=1;
            }
        }
        return  answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        System.out.println(main.solution(n));
    }
}
