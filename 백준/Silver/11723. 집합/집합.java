import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] S;
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            S = new boolean[21];

            int M = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < M; i++) {
                calculate(br.readLine());
            }

            bw.write(sb.toString());
        }     
    }

    private static void calculate(String input) {
        StringTokenizer st = new StringTokenizer(input);
        String command = st.nextToken();
        int x;

        switch (command) {
            case "add":
                x = Integer.parseInt(st.nextToken());
                S[x] = true;
                break;
            case "remove":
                x = Integer.parseInt(st.nextToken());
                S[x] = false;
                break;
            case "check":
                x = Integer.parseInt(st.nextToken());
                if (S[x]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;
            case "toggle":
                x = Integer.parseInt(st.nextToken());
                S[x] = !S[x];
                break;
            case "all":
                for (int i = 1; i < 21; i++) {
                    S[i] = true;
                }
                break;
            case "empty":
                S = new boolean[21];
                break;
        }
    }
}