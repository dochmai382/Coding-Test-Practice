import java.util.*;
import java.io.*;

/*
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){

            int N = Integer.parseInt(br.readLine());
            int[] stack = new int[10001];
            int top = -1;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch(command) {
                    case "push":
                        int x = Integer.parseInt(st.nextToken());
                        top++;
                        stack[top] = x;
                        break;
                    case "pop":
                        if (top == -1) {
                            sb.append(-1).append("\n");
                        } else {
                           int value = stack[top];
                            top--;
                            sb.append(value).append("\n");
                        }
                        break;
                    case "size":
                        sb.append(top+1).append("\n");
                        break;
                    case "empty":
                        if (top == -1) {
                            sb.append(1).append("\n");
                        } else {
                            sb.append(0).append("\n");
                        }
                        break;
                    case "top":
                        if (top == -1) {
                            sb.append(-1).append("\n");
                        } else{
                            sb.append(stack[top]).append("\n");
                        }
                        break;
                }
            }

            bw.write(sb.toString());
        }
    }
}