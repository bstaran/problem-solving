package hashMapAndHashSet.아나그램;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public String solution(String s, String s2) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        // 강의에서는 비교하면서 같은 값을 -시키는 방식을 사용
        for (char c : s.toCharArray()) hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        for (char c : s2.toCharArray()) hashMap2.put(c, hashMap2.getOrDefault(c, 0) + 1);

        for (char c : s.toCharArray()) if (!Objects.equals(hashMap.get(c), hashMap2.get(c))) return "NO";

        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s2 = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(s, s2));

    }
}
