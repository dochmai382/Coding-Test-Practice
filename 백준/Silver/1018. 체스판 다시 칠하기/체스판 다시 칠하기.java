import java.util.*;
import java.io.*;

class Solution {
    private int N;
    private int M;
    private char[][] board;

    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }

    public String solve() {
        int minCnt = 64;

        for (int r = 0; r <= N-8; r++) {
            for (int c = 0; c <= M-8; c++) {
                int countW = 0;
                int countB = 0;

                for (int i = r; i < r+8; i++) {
                    for (int j = c; j < c+8; j++) {
                        if ((i + j) % 2 == 0) {
                            if (board[i][j] == 'B') countW++;
                            if (board[i][j] == 'W') countB++;
                        } else {
                            if (board[i][j] == 'W') countW++;
                            if (board[i][j] == 'B') countB++;
                        }
                    }
                }

                int currentMin = Math.min(countW, countB);
                minCnt = Math.min(minCnt, currentMin);
            }
        }
        
        return String.valueOf(minCnt);
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