package dataStructure.응급실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public int solution(int N, int M, Queue<Person> q) {
        int answer = 1;
        while (!q.isEmpty()) {
            Person tmp=q.poll();
            for (Person person : q) {
                if (person.value > tmp.value) {
                    q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if (tmp!=null) {
                if (tmp.id == M) return answer;
                else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.offer(new Person(i,val));
        }

        Main main = new Main();
        System.out.println(main.solution(N,M,q));
    }
}

class Person{
    int id;
    int value;

    public Person(int id, int value) {
        this.id = id;
        this.value = value;
    }
}