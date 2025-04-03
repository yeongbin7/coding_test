// 정렬 - 생일

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class P5635 {

    static class Student {
        String name;
        int day, month, year;

        Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(students, (a, b) -> {
            if (a.year != b.year) {
                return b.year - a.year;
            } else if (a.month != b.month) {
                return b.month - a.month;
            } else if (a.day != b.day) {
                return b.day - a.day;
            }
            return a.name.compareTo(b.name);
        });

        System.out.println(students[0].name);
        System.out.println(students[n - 1].name);
    }
}