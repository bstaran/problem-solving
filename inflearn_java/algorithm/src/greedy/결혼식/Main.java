package greedy.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] t = br.readLine().split(" ");

            list.add(new Time(Integer.parseInt(t[0]), 'i'));
            list.add(new Time(Integer.parseInt(t[1]), 'o'));
        }

        list.sort((o1, o2) -> {
            if (o1.time == o2.time) return o2.state - o1.state;
            else return o1.time - o2.time;
        });

        int answer = 0, count = 0;
        for (Time time : list) {
            if (time.state == ('i')) count++;
            else count--;

            answer = Math.max(answer, count);

        }

        System.out.println(answer);
    }
}

class Time {
    int time;
    char state;

    public Time(int time, char status) {
        this.time = time;
        this.state = status;
    }
}