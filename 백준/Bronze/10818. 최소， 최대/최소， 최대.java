import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int number = Integer.parseInt(st.nextToken());
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }
            
            sb.append(min).append(" ").append(max);
            bw.write(sb.toString());
        }
    }
}