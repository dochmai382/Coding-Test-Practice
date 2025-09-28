import java.util.*;
import java.io.*;


class Main {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
           
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            int[] trees = new int[N];

            long low = 0L;
            long high = 0L;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                if (high < trees[i]) {
                    high = trees[i];
                }
            }

            long result = 0L;
            while(low <= high) {
                long mid = (low + high) / 2;
                long totalCut = calculate(mid, trees);

                if (totalCut >= M) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
            
            bw.write(String.valueOf(result));
        }    
    }

    private static long calculate(long h, int[] trees) {
        long total = 0L;

        for (int tree: trees) {
            if (tree > h) {
                total += (long) tree - h;
            }
        }

        return total;
    }
}