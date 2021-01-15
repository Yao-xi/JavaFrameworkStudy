package cf918a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> isBig =
            new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987));
        for (int i = 1; i <= n; i++) {
            if (isBig.contains(i)) {
                System.out.print("O");
            } else {
                System.out.print("o");
            }
        }
    }
    
    public static void method() {
        boolean[] b = new boolean[1000];
        int j = 1; // n-1
        int k = 0; // n-2
        for (int i = 1; i < b.length + 1; ) {
            b[i - 1] = true;
            k = j;
            j = i;
            i = j + k;
        }
        System.out.println(Arrays.toString(b));
    }
    
    public static void method2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int j = 1; // n-1
        int k = 0; // n-2
        for (int i = 1; i <= 1000; ) {
            list.add(i);
            k = j;
            j = i;
            i = j + k;
        }
        System.out.println(list);
    }
}
// O O O o O o o O
// 0 1 2 3 4 5 6 7
// 1 2 3 5 8
