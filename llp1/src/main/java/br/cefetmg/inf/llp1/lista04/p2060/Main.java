package br.cefetmg.inf.llp1.lista04.p2060;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n, l, m2 = 0, m3 = 0, m4 = 0, m5 = 0;
        n = input.nextInt();
        
        for (int i = 0; i < n; i++) {
            l = input.nextInt();
            if (l % 2 == 0) m2++;
            if (l % 3 == 0) m3++;
            if (l % 4 == 0) m4++;
            if (l % 5 == 0) m5++;
        }
        
        System.out.printf ("%d Multiplo(s) de 2\n%d Multiplo(s) de 3\n%d Multiplo(s) de 4\n%d Multiplo(s) de 5\n", m2, m3, m4, m5);
    }
}