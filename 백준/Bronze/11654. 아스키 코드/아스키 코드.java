import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            char ch = br.readLine().charAt(0);
            int code = (int) ch;

            bw.write(String.valueOf(code));            
        }
    }
}