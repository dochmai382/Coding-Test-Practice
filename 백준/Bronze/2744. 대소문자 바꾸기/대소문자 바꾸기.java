import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringBuilder sb = new StringBuilder();
            String input = br.readLine();

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                // if ('A' <= ch  && ch <= 'Z') {
                //     sb.append((char) (ch + 32));
                // } else {
                //     sb.append((char) (ch - 32));   
                // }
                if (Character.isUpperCase(ch)) {
                    sb.append(Character.toLowerCase(ch));
                } else {
                    sb.append(Character.toUpperCase(ch));
                }
            }

            bw.write(sb.toString());
        }
    }
}