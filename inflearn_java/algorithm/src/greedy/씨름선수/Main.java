package greedy.씨름선수;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Person(sc.nextInt(), sc.nextInt()));
        }


        list.sort((o1, o2) -> o2.height - o1.height);

        // height 정렬 확인
//        for (Person person : list)
//            System.out.print(person.height+ " " + person.weight+"\n");

        int answer=0, max=0;
        for (int i = 0; i < n; i++) {
            Person p = list.get(i);

            if (max < p.weight) {
                answer++;
                max=p.weight;
            }
        }
        System.out.println(answer);
    }
}

class Person{
    int height;
    int weight;

    public Person(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }
}