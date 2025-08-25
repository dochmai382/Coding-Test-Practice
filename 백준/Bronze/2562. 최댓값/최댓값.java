import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringBuilder sb = new StringBuilder();
            int max = 1;
            int pos = 0;

            for (int i = 1; i <= 9; i++) {
                int num = Integer.parseInt(br.readLine());
                if (num > max) {
                    max = num;
                    pos = i;
                }
            }
            
            sb.append(max).append("\n").append(pos);
            bw.write(sb.toString());
        }
    }
}