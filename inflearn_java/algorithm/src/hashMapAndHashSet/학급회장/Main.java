package hashMapAndHashSet.학급회장;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0)+1);

        int max = 0;
        char answer = ' ';
        for (char c : hashMap.keySet()) {
            int value = hashMap.get(c);
            if (value>max) {
                max = value;
                answer = c;
            }
        }
        System.out.print(answer);
    }
}
