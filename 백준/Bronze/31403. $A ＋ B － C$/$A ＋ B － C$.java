import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();
            
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());

            int result1 = a + b - c;
            sb.append(result1).append("\n");
            
            int result2 = Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c;
            sb.append(result2).append("\n");
            
            bw.write(sb.toString());
        }
    }
}