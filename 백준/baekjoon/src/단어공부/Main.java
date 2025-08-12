package 단어공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toUpperCase();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        char answer = 0;
        for (Character character : hashMap.keySet()) {
            int getCnt = hashMap.get(character);
            if (max == getCnt) {
                answer = '?';
                continue;
            }

            if (max < getCnt) {
                max = getCnt;
                answer = character;
            }
        }

        System.out.println(answer);
    }
}
