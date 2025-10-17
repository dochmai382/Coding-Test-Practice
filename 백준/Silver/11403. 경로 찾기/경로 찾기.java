import java.util.*;
import java.io.*;

class Solution {
    private int N;
    private int[][] G;

    public void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        G = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                G[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private void solve() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (G[i][k] == 1 && G[k][j] == 1) {
                        G[i][j] = 1;
                    }
                }
            }
        }
    }

    public String getResult() {
        solve();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(G[i][j]).append(" ");
            }
            sb.append("\n");
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
            bw.write(sol.getResult());
        }
    }
}