import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                String input = br.readLine();
                sb.append(input.charAt(0)).append(input.charAt(input.length()-1)).append("\n");
            }

            bw.write(sb.toString());
        }
    }
}