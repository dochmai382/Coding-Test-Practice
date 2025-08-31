import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

             int K = Integer.parseInt(br.readLine());

             Stack<Integer> stack = new Stack<>();
             for (int i = 0; i < K; i++) {
                 int num = Integer.parseInt(br.readLine());
                 if (!stack.isEmpty() && num == 0) {
                     stack.pop();
                 } else {
                     stack.push(num);
                 }
             }

             long sum = 0l;
             while (!stack.isEmpty()) {
                 sum += stack.pop();
             }

             bw.write(String.valueOf(sum));
         }       
    }
}