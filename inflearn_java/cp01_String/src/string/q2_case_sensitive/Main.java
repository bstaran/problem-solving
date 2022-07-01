package string.q2_case_sensitive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String word = bufferedReader.readLine();

        char[] wordCharArr= new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                wordCharArr[i] = word.toLowerCase().charAt(i);
            } else {
                wordCharArr[i] = word.toUpperCase().charAt(i);
            }
        }

        String answer = String.valueOf(wordCharArr);

        bufferedReader.close();

        System.out.println(answer);
    }
}
