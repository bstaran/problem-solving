package 리모컨_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fail {

    private static Set<Integer> brokenBtn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String channel = br.readLine();
        int N = Integer.parseInt(br.readLine());

        brokenBtn = new HashSet<>();
        if (N != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                brokenBtn.add(Integer.valueOf(st.nextToken()));
            }
        }

        int goalChannel = Integer.parseInt(channel);
        int btnCount = 0;
        int currentChannel = 100;
        if (goalChannel != currentChannel) {
            int closeChannel = getCloseChannel(goalChannel);
            btnCount = channel.length() + (Math.abs(closeChannel - goalChannel));
        }
        System.out.println(btnCount);
    }

    private static int getCloseChannel(int goalChannel) {
        int i = 0;
        while (true) {
            int upChannel = goalChannel + i;
            if (isValidChannel(upChannel)) {
                return upChannel;
            }

            int downChannel = goalChannel - i;
            if (isValidChannel(downChannel)) {
                return downChannel;
            }

            i++;
        }
    }

    private static boolean isValidChannel(int channel) {
        String strChannel = String.valueOf(channel);
        for (char c : strChannel.toCharArray()) {
            if (brokenBtn.contains(c - '0')) {
                return false;
            }
        }

        return true;
    }
}
