import java.util.*;
import java.io.*;

class Main {
    private static long[] dp = new long[101];
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            padoDP();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(br.readLine());
                sb.append(dp[n]).append("\n");
            }
            bw.write(sb.toString());
        }
    }

    private static void padoDP() {
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i-3] + dp[i-2];
        }
    }
}