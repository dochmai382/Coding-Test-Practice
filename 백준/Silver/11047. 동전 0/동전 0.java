import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            for (int i = N-1; i >= 0; i--) {
                if (K >= coins[i]) {
                    int numCoins = K / coins[i];
                    count += numCoins;
                    K %= coins[i];
                }

                if(K == 0) break;
            }
            
            bw.write(String.valueOf(count));
        }
    }
}