import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
        
            int N = Integer.parseInt(br.readLine());
    
            int[][] cost = new int[N+1][3];
            int[][] dp = new int[N+1][3];
            
            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                cost[i][0] = Integer.parseInt(st.nextToken());
                cost[i][1] = Integer.parseInt(st.nextToken());
                cost[i][2] = Integer.parseInt(st.nextToken());
            }
            
            dp[1][0] = cost[1][0];
            dp[1][1] = cost[1][1];
            dp[1][2] = cost[1][2];
            
            for (int i = 2; i <= N; i++) {
                dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
            }
            
            int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
            bw.write(String.valueOf(result));
        }
    }
}
