import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            for (int i = 1; i <= n; i++) {
                for (int j = n - i; j > 0; j--) {
                    sb.append(" ");
                }
                for (int k = 1; k <= i; k++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

            bw.write(sb.toString());
        }
    }
}