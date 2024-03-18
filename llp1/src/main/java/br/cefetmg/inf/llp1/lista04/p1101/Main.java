package br.cefetmg.inf.llp1.lista04.p1101;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m, n;
        Scanner input = new Scanner (System.in);
        m = input.nextInt ();
        n = input.nextInt ();

        while (m > 0 && n > 0) {
            if (m > n) {
                int aux = m;
                m = n;
                n = aux;
            }

            int soma = 0;
            for (int i = m; i < n + 1; i++) {
                soma += i;
                System.out.printf ("%d ", i);
            }
            System.out.printf ("Sum=%d\n", soma);

            m = input.nextInt ();
            n = input.nextInt ();
        }
    }
}
