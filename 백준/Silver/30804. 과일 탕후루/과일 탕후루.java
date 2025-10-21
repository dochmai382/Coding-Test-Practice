import java.io.*;
import java.util.*;

class Solution {
	private int N;
	private int[] fruitTypes;
	
	public void input(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		fruitTypes = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruitTypes[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private int solve(int[] fruits, int n) {
		int maxLength = 0;
		int left = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		
		for (int right = 0; right < N; right++) {
			int currentFruit = fruits[right];
			
			countMap.put(currentFruit, countMap.getOrDefault(currentFruit, 0) + 1);
			
			while (countMap.size() > 2) {
				int leftFruit = fruits[left];
				countMap.put(leftFruit, countMap.get(leftFruit) - 1);
				if (countMap.get(leftFruit) == 0) {
					countMap.remove(leftFruit);
				}
				left++;
			}
			
			int currentLength = right - left + 1;
			maxLength = Math.max(maxLength, currentLength);
		}
		
		return maxLength;
	}
	
	public String getResult() {
		return String.valueOf(solve(fruitTypes, N));
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