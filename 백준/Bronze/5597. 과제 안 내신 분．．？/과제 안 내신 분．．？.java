import java.util.*;
import java.io.*;

/*
교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            boolean[] check = new boolean[31];
            check[0] = true;

            for (int i = 0; i < 28; i++) {
                int a = Integer.parseInt(br.readLine());
                check[a] = true;
            }

            for (int i = 0; i < check.length; i++) {
                if (check[i]) continue;
                sb.append(i).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}