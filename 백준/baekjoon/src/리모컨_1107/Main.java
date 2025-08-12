package 리모컨_1107;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String channel = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Set<Integer> brokenBtn = new HashSet<>();
        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                brokenBtn.add(Integer.valueOf(st.nextToken()));
            }
        }

        int minPressCount = getMinPressCount(channel, brokenBtn);

        System.out.println(minPressCount);
    }

    private static int getMinPressCount(String channel, Set<Integer> brokenBtn) {
        int goalChannel = Integer.parseInt(channel);
        int currentChannel = 100;
        int minPressCount = Math.abs(goalChannel - currentChannel); // 초기값: +,- 버튼만 사용하는 경우

        // 가장 가까운 채널 찾기
        for (int i = 0; i < 1000000; i++) {
            String channelStr = String.valueOf(i);
            boolean isValid = true;
            for (char c : channelStr.toCharArray()) {
                if (brokenBtn.contains(c - '0')) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                int pressCount = channelStr.length() + Math.abs(i - goalChannel);
                minPressCount = Math.min(minPressCount, pressCount);
            }
        }
        return minPressCount;
    }
}