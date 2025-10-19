import java.io.*;
import java.util.*;

class Solution {
	private int L;
	private int C;
	private char[] alphabets;
	private List<Character> selected = new ArrayList<>();

	private StringBuilder sb = new StringBuilder();
	
	public void input(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabets = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabets);
	}
	
	private void selectAlphabet(int startIdx, int count) {
		if (count == L) {
			checkValid();
			return;
		}
		
		for (int i = startIdx; i < C; i++) {
			selected.add(alphabets[i]);
			selectAlphabet(i + 1, count + 1);
			selected.remove(selected.size() - 1);
		}
	}
	
	private void checkValid() {
		int vowelCount = 0;
		for (char ch : selected) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				vowelCount++;
			}
		}
		
		int consonantCount = L - vowelCount;
		
		if (vowelCount >= 1 && consonantCount >= 2) {
			for (char ch : selected) {
				sb.append(ch);
			}
			sb.append("\n");
		}
	}
	
	public String getResult() {
		selectAlphabet(0, 0);
		return sb.toString().trim();
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		try(
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Solution sol = new Solution();
			sol.input(br);
			bw.write(sol.getResult());
		}
	}
}