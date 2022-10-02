package greedy.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Meeting[] meetingTimeTables = new Meeting[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingTimeTables[i] = new Meeting(start, end);
        }

        // 끝나는 시간 기준 정렬
        Arrays.sort(meetingTimeTables, (o1, o2) -> {
            if (o1.end==o2.end) return o1.start-o2.start;

            return o1.end - o2.end;
        });

        // 출력
//        for (Meeting meeting : meetingTimeTables) {
//            System.out.println(meeting.start + " " + meeting.end);
//        }

        int endTime=0;
        int answer=0;
        for (Meeting meeting : meetingTimeTables) {
            if (meeting.start>=endTime){
                endTime= meeting.end;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

class Meeting{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}