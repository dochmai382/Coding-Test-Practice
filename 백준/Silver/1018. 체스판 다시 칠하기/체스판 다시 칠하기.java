import java.util.*;
import java.io.*;

/*
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
*/

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[][] board = new char[N][M];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            int minCnt = 64;

            for (int i = 0; i <= N-8; i++) {
                for (int j = 0; j <= M-8; j++) {
                    int cnt = 0;

                    for (int k = i; k < i+8; k++) {
                        for (int l = j; l < j+8; l++) {
                            if ((k + l) % 2 == 0) {
                                if (board[k][l] != 'B') {
                                    cnt++;
                                }
                            } else {
                                if (board[k][l] != 'W') {
                                    cnt++;
                                }
                            }
                        }
                    }

                    cnt = Math.min(cnt, 64 - cnt);
                    minCnt = Math.min(cnt, minCnt);
                }
            }

            bw.write(String.valueOf(minCnt));
        }
    }
}