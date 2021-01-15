package p5739;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(getJc(num));
    }
    
    public static int getJc(int num) {
        if (num == 1 || num == 0) {
            return 1;
        } else {
            return num * getJc(num - 1);
        }
    }
}
