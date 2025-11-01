import java.util.*;
import java.io.*;

class Solution {
	private int N;
	private String answer;
	
	private final char[] adrianPattern = {'A', 'B', 'C'};
	private final char[] brunoPattern = {'B', 'A', 'B', 'C'};
	private final char[] goranPattern = {'C', 'C', 'A', 'A', 'B', 'B'};
	private StringBuilder sb = new StringBuilder();
	
	public void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		answer = br.readLine();
	}
	
	private void solve() {
		int adrianScore = 0;
		int brunoScore = 0;
		int goranScore = 0;
		
		for (int i = 0; i < N; i++) {
			char current = answer.charAt(i);
			
			if (current == adrianPattern[i % 3]) adrianScore++;
			if (current == brunoPattern[i % 4]) brunoScore++;
			if (current == goranPattern[i % 6]) goranScore++;
		}
		
		int maxScore = Math.max(adrianScore, Math.max(brunoScore, goranScore));
		sb.append(maxScore).append("\n");
		
		if (adrianScore == maxScore) sb.append("Adrian").append("\n");
		if (brunoScore == maxScore) sb.append("Bruno").append("\n");
		if (goranScore == maxScore) sb.append("Goran").append("\n");
	}
	
	public String getResult() {
		solve();
		return sb.toString().trim();
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		try (
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Solution sol = new Solution();
			sol.input(br);
			bw.write(sol.getResult());
		}
	}
}