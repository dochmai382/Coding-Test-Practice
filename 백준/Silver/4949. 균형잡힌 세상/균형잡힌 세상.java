import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

             StringBuilder sb = new StringBuilder();
             while (true) {
                 String input = br.readLine();

                 if (input.equals(".")) {
                     break;
                 }

                 Stack<Character> stack = new Stack<>();
                 boolean flag = true;
                 for (int i = 0; i < input.length(); i++) {
                     char ch = input.charAt(i);

                     if (ch == '(' || ch == '[') {
                         stack.push(ch);
                     } else if (ch == ')') {
                         if (stack.isEmpty() || stack.peek() != '(') {
                             flag = false;
                             break;
                         } else {
                             stack.pop();
                         }
                     } else if (ch == ']') {
                         if (stack.isEmpty() || stack.peek() != '[') {
                             flag = false;
                             break;
                         } else {
                             stack.pop();
                         }
                     }
                 }

                 if (stack.isEmpty() && flag) {
                     sb.append("yes").append("\n");
                 } else {
                     sb.append("no").append("\n");
                 }
             }
             
             bw.write(sb.toString());
         }       
    }
}