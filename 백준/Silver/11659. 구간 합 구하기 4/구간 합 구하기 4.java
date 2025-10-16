import java.util.*;
import java.io.*;

class Solution {
    private int N;
    private int M;
    private long[] preSum;
    private int[][] req;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preSum = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i-1] + Integer.parseInt(st.nextToken());
        }

        req = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            req[i][0] = Integer.parseInt(st.nextToken());
            req[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public String solve() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < M; i++) {
            int x = req[i][0];
            int y = req[i][1];

            long result = preSum[y] - preSum[x-1];
            sb.append(result).append("\n");
        }

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
            bw.write(sol.solve());
        }
    }
}