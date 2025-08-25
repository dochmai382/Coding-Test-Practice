import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = line.charAt(i) - '0';
                sum += num;
            }

            bw.write(String.valueOf(sum));      
        }
    }
}