import java.io.*;
import java.util.*;

class Solution {
	private int N;
	private String input;
	
	public void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		input = br.readLine();
	}
	
	private int solve(String str, int n) {
		int maxLength = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for (int right = 0; right < str.length(); right++) {
			char ch = str.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			
			while (map.size() > n) {
				char leftCh = str.charAt(left);
				map.put(leftCh, map.get(leftCh) - 1);
				if (map.get(leftCh) == 0) {
					map.remove(leftCh);
				}
				left++;
			}
			
			int currentLength = right - left + 1;
			maxLength = Math.max(maxLength, currentLength);
		}
		
		return maxLength;
	}
	
	public String getResult() {
		return String.valueOf(solve(input, N));
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