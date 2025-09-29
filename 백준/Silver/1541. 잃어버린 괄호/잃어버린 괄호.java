import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String input = br.readLine();

            String[] part = input.split("-");

            int result = 0;
            String[] first = part[0].split("\\+");
            for (String str : first) {
                result += Integer.parseInt(str);
            }

            for (int i = 1; i < part.length; i++) {
                String[] sub = part[i].split("\\+");
                int subTotal = 0;

                for (String str: sub) {
                    subTotal += Integer.parseInt(str);
                }

                result -= subTotal;
            }

            bw.write(String.valueOf(result));
        }
    }
}