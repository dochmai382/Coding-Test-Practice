import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            long high = 0L;
            long low = 1L;
            
            int[] input = new int[K];
            for (int i = 0; i < K; i++) {
                input[i] = Integer.parseInt(br.readLine());
                if (high < input[i]) {
                    high = input[i];
                }
            }

            long result = 0L;
            while (low <= high) {
                long mid = (high + low) / 2;
                long count = 0L;
                for (int k : input) {
                    count += (k / mid);
                }

                if (count >= N) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            bw.write(String.valueOf(result));
        }
    }
}