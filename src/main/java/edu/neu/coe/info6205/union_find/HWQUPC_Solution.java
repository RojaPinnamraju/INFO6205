package edu.neu.coe.info6205.union_find;



import java.util.Random;
import java.util.Scanner;
public class HWQUPC_Solution {
    public static void main(String[] args) {
        int[] testdata = new int[30];
        int out = 0;
        Random random = new Random();
        for (int i = 0; i < testdata.length; i++) testdata[i] = random.ints(200, 1000).findFirst().getAsInt();
        for (int i = 0; i < testdata.length; i++) {
            out = 0;
            for (int j = 0; j < 5000; j++) {
                out += count(testdata[i]);

            }

            System.out.println(testdata[i] + " " + out / 5000);
            // System.out.println("For "+out+" objects, number of connections ="+out);
        }
    }

    public static int count(int i) {
        int randoms = 0;
        UF_HWQUPC uf = new UF_HWQUPC(i, true);
        Random random = new Random();
        while (uf.components() > 1) {
            int a = random.ints(0, i).findFirst().getAsInt();
            int b = random.ints(0, i).findFirst().getAsInt();
            randoms++;
            if (!uf.isConnected(a, b)) {
                uf.union(a, b);
            }
        }
        return randoms;
    }
}