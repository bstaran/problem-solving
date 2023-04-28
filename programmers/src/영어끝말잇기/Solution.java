package 영어끝말잇기;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> wordSetUsed = new HashSet<>();
        wordSetUsed.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            if (
                    wordSetUsed.contains(words[i]) ||
                            words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {

                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            wordSetUsed.add(words[i]);

            if (i == words.length - 1) {
                answer[0] = 0;
                answer[1] = 0;
            }
        }

        return answer;
    }
}