package 소수찾기_level2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    StringBuilder sb;
    boolean[] visit;
    Set<Integer> set;

    public int solution(String numbers) {

        sb = new StringBuilder();
        visit = new boolean[numbers.length()];
        set = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            sb.append(numbers.charAt(i));
        }

        dfs("", 0);

        return set.size();
    }

    private void dfs(String str, int idx) {

        if (str.length()>0) {
            int num = Integer.parseInt(str);

            if (isPrime(num)) {
                set.add(num);
            }
        }

        if (sb.length()!=str.length()) {
            for (int i = 0; i < sb.length(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(str + sb.charAt(i), idx++);
                    visit[i] = false;
                }
            }
        }
    }

    private boolean isPrime(int num) {

        if (num==0 || num==1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num%i == 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("011"));
    }
}
