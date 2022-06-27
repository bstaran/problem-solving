package q9_숫자만추출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String s) {

        s = String.valueOf(Integer.parseInt(s.replaceAll("[^0-9]", "")));

        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();
        System.out.println(main.solution(br.readLine()));
    }
}
