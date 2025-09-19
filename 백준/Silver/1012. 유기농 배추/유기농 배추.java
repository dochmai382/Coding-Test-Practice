import java.util.*;
import java.io.*;


class Main {
    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());

                field = new int[N][M];
                visited = new boolean[N][M];
                int worm = 0;

                for (int k = 0; k < K; k++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    field[y][x] = 1;
                }
                
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < M; x++) {
                        if (field[y][x] == 1 && visited[y][x] == false) {
                            worm++;
                            DFS(y, x);
                        }
                    }
                }
                sb.append(worm).append("\n");
            }

            bw.write(sb.toString());
        }    
    }

    static void DFS(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                if (field[nextY][nextX] == 1 && visited[nextY][nextX] == false) {
                    DFS(nextY, nextX);
                }
            }
        }
    }
}