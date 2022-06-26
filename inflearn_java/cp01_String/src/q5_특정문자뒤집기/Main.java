package q5_특정문자뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        int lt = 0, rt = s.length() - 1;
        while (lt < rt) {
            if (!(Character.isAlphabetic(chars[lt]))) lt++;
            else if (!(Character.isAlphabetic(chars[rt]))) rt--;
            else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }

        }
        String answer = String.valueOf(chars);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        System.out.println(main.solution(bufferedReader.readLine()));
    }
}
