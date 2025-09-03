import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

             StringBuilder sb = new StringBuilder();
             
             int n = Integer.parseInt(br.readLine());
             int[] dp = new int[Math.max(n+1, 3)];
             
             if (n >= 1) {
                 dp[1] = 1;
             }
             if (n >= 2) {
                 dp[2] = 2;
             }
             for (int i = 3; i <= n; i++) {
                 dp[i] = (dp[i-1] + dp[i-2]) % 10007;
             }
             
             sb.append(dp[n]);
             bw.write(sb.toString());
         }       
    }
}