import java.util.*;
import java.io.*;

/*
검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                sum += num * num;
            }

            int result = sum % 10;
            bw.write(String.valueOf(result));
                 
        }
    }
}