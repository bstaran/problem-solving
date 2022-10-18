package 위장;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);

        for (String s : map.keySet())
            answer*=map.get(s)+1;

        return --answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] str = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(s.solution(str));
    }
}
