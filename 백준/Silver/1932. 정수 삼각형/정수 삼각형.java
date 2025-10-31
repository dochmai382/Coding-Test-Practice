import java.io.*;
import java.util.*;

class Solution {
	private int n ;
	private int[][] dp;
	
	public void inputAndSolve(BufferedReader br) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n][n];
		
		for (int i = 0;i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j<= i; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (i == 0) {
					dp[i][j] = num;
				} else {
					if (j == 0) {
						dp[i][j] = num + dp[i-1][j];
					} else if (j == i) {
						dp[i][j] = num + dp[i-1][j-1];
					} else {
						dp[i][j] = num + Math.max(dp[i-1][j-1], dp[i-1][j]);
					}
				}
			}
		}
	}
	
	public String getResult() {
		int maxResult = 0;
		for (int i = 0; i < n; i++) {
			maxResult = Math.max(maxResult, dp[n-1][i]);
		}
		
		return String.valueOf(maxResult);
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Solution sol = new Solution();
			sol.inputAndSolve(br);
			bw.write(sol.getResult());
		}
	}
}