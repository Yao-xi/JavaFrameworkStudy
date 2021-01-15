package p1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 2; i < x; i++) {
            if (x % i == 0 && isPrime(i)) {
                res = x / i;
                break;
            }
        }
        System.out.println(res);
    }
    
    /**
     * 判断素数
     */
    public static boolean isPrime(int num) {
        boolean isprime = true;
        int y = (int) Math.sqrt(num);
        for (int i = 2; i < y; i++) {
            if (num % i == 0) {
                isprime = false;
                break;
            }
        }
        return isprime;
    }
}
