package kakao_주차요금계산;

import java.util.*;

public class Solution {
    public int[] solution(int[] fees, String[] records) {

        Map<Integer, Integer> parkingList = new HashMap<>();
        Map<Integer, Integer> totalTime = new TreeMap<>();

        for (String record : records) {
            String[] option = record.split(" ");
            String[] time = option[0].split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            Integer carNumber = Integer.valueOf(option[1]);

            if (!parkingList.containsKey(carNumber)) {

                parkingList.put(carNumber, minute);
                if (!totalTime.containsKey(carNumber)) totalTime.put(carNumber, 0);
            } else {
                totalTime.put(carNumber, totalTime.get(carNumber) + minute - parkingList.get(carNumber));
                parkingList.remove(carNumber);
            }
        }

        for (Integer s : parkingList.keySet()) {
            int minute = 23 * 60 + 59;

            int parkingTime = minute - parkingList.get(s);
            totalTime.put(s, totalTime.get(s) + parkingTime);
        }

        int[] answer = new int[totalTime.size()];
        int idx = 0;
        for (Integer key : totalTime.keySet()) {

            int time = totalTime.get(key);

            int price;
            if (time <= fees[0]) {
                price = fees[1];
            } else {
                price = fees[1] + (int) Math.ceil((time - fees[0]) / (double)fees[2]) * fees[3];
            }
            answer[idx++] = price;
        }

        return answer;
    }


    public static void main(String[] args) {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT", "12:00 5961 IN", "15:00 5961 OUT"};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(fees, records)));
    }
}
