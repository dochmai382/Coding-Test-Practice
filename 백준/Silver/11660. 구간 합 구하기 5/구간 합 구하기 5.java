import java.util.*;
import java.io.*;

class Solution {
    private int N;
    private int M;
    private long[][] preSum;
    private int[][] input;

    private StringBuilder sb = new StringBuilder();

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        preSum = new long[N+1][N+1];
        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        input = new int[M][4];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public String solve() {
        for (int i = 0; i < M; i++) {
            int x1 = input[i][0];
            int y1 = input[i][1];
            int x2 = input[i][2];
            int y2 = input[i][3];

            long sum = preSum[x2][y2] - preSum[x1-1][y2] - preSum[x2][y1-1] + preSum[x1-1][y1-1];
            sb.append(sum).append("\n");
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