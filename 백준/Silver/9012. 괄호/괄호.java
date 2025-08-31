import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
             StringBuilder sb = new StringBuilder();
             
             int N = Integer.parseInt(br.readLine());
             for (int i = 0; i < N; i++) {
                 String input = br.readLine();
                 boolean flag = true;
                 Stack<Character> stack = new Stack<>();

                 for (int j = 0; j < input.length(); j++) {
                     char ch = input.charAt(j);

                     if (ch == '(') {
                         stack.push(ch);
                     } else if (ch == ')') {
                         if (stack.isEmpty()) {
                             flag = false;
                             break;
                         } else {
                             stack.pop();
                         }
                     }
                 }
                 
                 if (stack.isEmpty() && flag) {
                     sb.append("YES").append("\n");
                 } else {
                     sb.append("NO").append("\n");
                 }
             }
             
             bw.write(sb.toString());
         }       
    }
}