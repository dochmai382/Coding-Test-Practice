import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            sb.append(a).append(" * ").append(i).append(" = ").append(a*i).append("\n");
        }
        
        System.out.print(sb);
    }
}