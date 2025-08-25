import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            
            int N = Integer.parseInt(br.readLine());
            List<Integer> input = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                input.add(Integer.parseInt(br.readLine()));
            }

            Collections.sort(input);
            for (int i = 0; i < N; i++) {
                sb.append(input.get(i)).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}