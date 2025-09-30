import java.util.*;
import java.io.*;


class Main {
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] region = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            long high = 0L;
            for (int i = 0; i < N; i++) {
                region[i] = Integer.parseInt(st.nextToken());
                if (high < region[i]) {
                    high = region[i];
                }
            }
            long budget = Long.parseLong(br.readLine());

            long low = 0L;
            long result = 0L;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                long sum = 0L;

                for (int reg : region) {
                    if (reg <= mid) {
                        sum += reg;
                    } else {
                        sum += mid;
                    }
                }

                if (sum <= budget) {
                    result = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            bw.write(String.valueOf(result));
                
        }
    }    
    
}