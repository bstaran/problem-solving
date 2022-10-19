package 베스트앨범;

import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        ArrayList<String> order = new ArrayList<>(map.keySet());
        order.sort((o1, o2) -> map.get(o2)-map.get(o1));

        ArrayList<Integer> result = new ArrayList<>();
        for (String g : order) {

            for (int j = 0; j < 2; j++) {

                int max = Integer.MIN_VALUE;
                for (int k = 0; k < genres.length; k++) {
                    if (genres[k].equals(g)) {
                        if (max == Integer.MIN_VALUE) max = k;
                        else if (plays[k] > plays[max]) max = k;
                    }
                }
                if (plays[max]==Integer.MIN_VALUE) continue;
                result.add(max);
                plays[max] = Integer.MIN_VALUE;
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]= result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] g = {"classic", "classic", "classic", "pop"};
        int[] p = {2500, 800, 800, 2500};

        System.out.println(Arrays.toString(s.solution(g, p)));
    }
}