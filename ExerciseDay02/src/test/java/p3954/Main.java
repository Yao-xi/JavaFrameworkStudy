package p3954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] i = stringArrToIntArr(s);
        System.out.println((i[0] * 2 + i[1] * 3 + i[2] * 5)/10);
    }
    
    public static int[] stringArrToIntArr(String[] s) {
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
}
