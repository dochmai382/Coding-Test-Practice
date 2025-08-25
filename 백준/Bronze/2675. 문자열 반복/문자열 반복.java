import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            int T = Integer.parseInt(br.readLine());
            
            StringTokenizer st;
            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(st.nextToken());
                String input = st.nextToken();

                for (int j = 0; j < input.length(); j++) {
                    char ch = input.charAt(j);
                    for (int k = 0; k < R; k++) {
                        sb.append(ch);
                    }
                }
                sb.append("\n");
            }
            
            bw.write(sb.toString());
        }
    }
}