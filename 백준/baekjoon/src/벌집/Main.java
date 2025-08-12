package 벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int room = 1;
        int cnt = 1;
        while (true) {
            if (n > room) {
                room += cnt * 6;
                cnt++;
            } else {
                System.out.println(cnt);
                break;
            }
        }
    }
}

