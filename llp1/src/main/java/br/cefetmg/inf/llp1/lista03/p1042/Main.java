package br.cefetmg.inf.llp1.lista03.p1042;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int a, b, c, l, m, n, temp;
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        
        l = a;
        m = b;
        n = c;
        
        if (l > m) {
            temp = l;
            l = m;
            m = temp;
        }
        if (l > n) {
            temp = l;
            l = n;
            n = temp;
        }
        if (m > n) {
            temp = m;
            m = n;
            n = temp;
        }
        
        System.out.printf ("%d\n%d\n%d\n\n", l, m, n);
        System.out.printf ("%d\n%d\n%d\n", a, b, c);
    }
}
