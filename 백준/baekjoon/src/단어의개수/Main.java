package 단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if (input.equals(" ")) {
            System.out.println(0);
            return;
        }
        String[] strings = input.trim().split(" ");

        System.out.println(strings.length);
    }
}
