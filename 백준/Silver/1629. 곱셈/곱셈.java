import java.io.*;
import java.util.*;

// 첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
		
    		StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            long result = power(A, B, C);
            bw.write(String.valueOf(result));
        }
	}

    private static long power(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }
        long temp = power(A, B/2, C);
        long result = (temp * temp) % C;

        if (B % 2 != 0) {
            result = (result * A) % C;
        }

        return result;
    }
}