package q4_reverseWord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String reversedWord = "";
            String word = br.readLine();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord += String.valueOf(word.charAt(j));
            }
            System.out.println(reversedWord);
        }
    }
}
