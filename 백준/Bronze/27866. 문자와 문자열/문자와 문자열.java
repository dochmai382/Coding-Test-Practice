import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            String input = br.readLine();
            int num = Integer.parseInt(br.readLine());

            bw.write(input.charAt(num-1));
        }
    }
}