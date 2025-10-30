import java.io.*;
import java.util.*;

class Solution {
	private int N;
	private int[] maxPrev = new int[3];
	private int[] minPrev = new int[3];
	
	private int max = Integer.MIN_VALUE;
	private	int min = Integer.MAX_VALUE;
	
	public void inputAndSolve(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0;i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num0 = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int[] maxCurr = new int[3];
			int[] minCurr = new int[3];
			
			if (i == 0) {
				maxPrev[0] = num0; minPrev[0] = num0;
				maxPrev[1] = num1; minPrev[1] = num1;
				maxPrev[2] = num2; minPrev[2] = num2;
				continue;
			}
			
			maxCurr[0] = num0 + Math.max(maxPrev[0], maxPrev[1]);
			maxCurr[1] = num1 + Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
			maxCurr[2] = num2 + Math.max(maxPrev[1], maxPrev[2]);
			
			minCurr[0] = num0 + Math.min(minPrev[0], minPrev[1]);
			minCurr[1] = num1 + Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);
			minCurr[2] = num2 + Math.min(minPrev[1], minPrev[2]);
			
			System.arraycopy(maxCurr, 0, maxPrev, 0, 3);
			System.arraycopy(minCurr, 0, minPrev, 0, 3);
		}	
		
		max = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]);
		min = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]);
	}
	
	
	public String getResult() {
		return max + " " + min;
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