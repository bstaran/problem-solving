package 귤고르기;

import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        /*
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        });
        */

        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });

        int count = 0;
        // for (Map.Entry<Integer, Integer> entry : entryList) {
        for (Integer key : list) {
            answer++;
            //count += entry.getValue();
            count += map.get(key);

            if (k <= count) {
                break;
            }
        }

        return answer;
    }
}