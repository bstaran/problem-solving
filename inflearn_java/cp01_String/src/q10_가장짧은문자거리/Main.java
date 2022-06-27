package q10_가장짧은문자거리;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public int[] solution(String s, char t) {

        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                p = 0;
                answer[i] = 0;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String s = br.readLine();
//        char t = br.readLine().charAt(0);

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);

        for (int n : main.solution(s, t)) {
            System.out.print(n + " ");
        }
    }
}
