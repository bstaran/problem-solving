package q3_wordInSentence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    String solution(String[] words) {
        String answer = "";

        for (String w : words) {
            if (w.length() > answer.length()) {
                answer = w;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Main main = new Main();

        String[] words = s.split(" ");
        String answer = main.solution(words);


        System.out.println(answer);

        br.close();

        int m = Integer.MIN_VALUE, pos;
    }
}
