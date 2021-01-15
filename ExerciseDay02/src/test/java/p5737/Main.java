package p5737;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = stringArrToIntArr(br.readLine().split(" "));
        int x = a[0], y = a[1];
        
        List<Integer> list = new ArrayList<>();
        int i = x;
        while (i <= y) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                list.add(i);
                i += 4;
            } else {
                i++;
            }
        }
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.print(integer);
            System.out.print(" ");
        }
    }
    
    public static int[] stringArrToIntArr(String[] s) {
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
    }
}
