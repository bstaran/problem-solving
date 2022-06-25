package q_로또의최고순위와최저순위;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        // List로 변환
        List<Integer> winLottoList = new ArrayList<>();
        List<Integer> loseLottoList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            if (lottos[i] != 0) winLottoList.add(lottos[i]); // 0번을 제외하고 1등 로또에 추가

            loseLottoList.add(lottos[i]);
        }

        // 당첨 숫자 채워넣기
        for (int i = 0; i < 6; i++) {
            if (winLottoList.size() == 6) break;
            if (!(winLottoList.contains(win_nums[i]))) winLottoList.add(win_nums[i]);
        }

        int[] answer = {0, 0};
        int[] count = {0, 0};

        // 맞춘 수 카운트
        for (int n : win_nums) {
            if (winLottoList.contains(n)) count[0]++;
            if (loseLottoList.contains(n)) count[1]++;
        }

//        System.out.println("count = " + Arrays.toString(count));

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 6) {
                answer[i] = 1;
            } else if (count[i] == 5) {
                answer[i] = 2;
            } else if (count[i] == 4) {
                answer[i] = 3;
            } else if (count[i] == 3) {
                answer[i] = 4;
            } else if (count[i] == 2) {
                answer[i] = 5;
            } else {
                answer[i] = 6;
            }
        }

//        for (int i = 0; i < 6; i++) {
//            System.out.println("win number: " + winLottoList.get(i) + "    lose number: " + loseLottoList.get(i));
//        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] answer = solution.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}
