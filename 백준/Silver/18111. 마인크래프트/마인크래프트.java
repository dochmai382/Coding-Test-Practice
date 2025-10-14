import java.util.*;
import java.io.*;

class Solution {
    private int N;
    private int M;
    private int B;
    private int[][] map;
    private int minHeight = Integer.MAX_VALUE;
    private int maxHeight = Integer.MIN_VALUE;
    
    public void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }
                if (map[i][j] < minHeight) {
                    minHeight = map[i][j];
                }
            }
        }
    }

    public String solve() {
        long minTime = Long.MAX_VALUE;
        int bestHeight = minHeight;

        for (int h = minHeight; h <= maxHeight; h++) {
            long currentTime = 0;
            long requiredBlocks = 0;
            long removedBlocks = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int currentHeight = map[i][j];

                    if (currentHeight > h) {
                        long diff = currentHeight - h;
                        removedBlocks += diff;
                        currentTime += (diff*2);
                    } else if (currentHeight < h) {
                        long diff = h - currentHeight;
                        requiredBlocks += diff;
                        currentTime += diff;
                    }
                }
            }

            if ((B + removedBlocks) >= requiredBlocks) {
                if (currentTime <= minTime) {
                    minTime = currentTime;
                    bestHeight = h;
                }
            }
        }

        return minTime + " " + bestHeight;  
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