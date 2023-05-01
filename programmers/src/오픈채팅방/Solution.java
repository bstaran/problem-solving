package 오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> notification = new ArrayList<>();
        Map<String, String> nicknameInfo = new HashMap<>();

        for (String msg : record) {
            String[] info = msg.split(" ");
            if (info[0].charAt(0) == ('L')) {
                continue;
            }
            nicknameInfo.put(info[1], info[2]);
        }

        for (String msg : record) {
            String[] info = msg.split(" ");

            if (info[0].charAt(0) == ('E')) {
                notification.add(nicknameInfo.get(info[1]) + "님이 들어왔습니다.");
            } else if (info[0].charAt(0) == ('L')) {
                notification.add(nicknameInfo.get(info[1]) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[notification.size()];
        notification.toArray(answer);

        return answer;
    }
}