package 완주하지못한선수;

import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> p = new HashMap<>();

        for (String s : participant)
            p.put(s, p.getOrDefault(s, 0)+1);

        for (String s : completion)
            p.put(s, p.getOrDefault(s, 0)-1);

        for (String s : p.keySet())
            if (p.get(s)!=0) answer = s;

        return answer;
    }



    public static void main(String[] args) {

        Solution s = new Solution();

        String[] participant ={"mislav", "stanko", "mislav", "ana"};
        String[] completion ={"stanko", "ana", "mislav"};

        System.out.println(s.solution(participant, completion));
    }
}
