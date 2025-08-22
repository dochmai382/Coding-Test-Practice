import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        long result = 1;
        
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}