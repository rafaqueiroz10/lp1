package br.cefetmg.inf.llp1.lista04.p1094;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, quantidadeCobaias, totalCobaias = 0, totalCoelhos = 0, totalRatos = 0, totalSapos = 0;
        double percentualCoelhos, percentualRatos, percentualSapos;
        char tipoCobaia;
        Scanner input = new Scanner (System.in);
        n = input.nextInt ();
        
        for (int i = 0; i < n; i++) {
            quantidadeCobaias = input.nextInt();
            tipoCobaia = input.nextLine().charAt(1);
            
            totalCobaias += quantidadeCobaias;

            switch (tipoCobaia) {
                case 'C': totalCoelhos += quantidadeCobaias; break;
                case 'R': totalRatos += quantidadeCobaias; break;
                case 'S': totalSapos += quantidadeCobaias;
            } 
        }
        percentualCoelhos = (totalCoelhos * 100.0) / totalCobaias;
        percentualRatos = (totalRatos * 100.0) / totalCobaias;
        percentualSapos = (totalSapos * 100.0) / totalCobaias;

        System.out.printf ("Total: %d cobaias\n", totalCobaias);
        System.out.printf ("Total de coelhos: %d\nTotal de ratos: %d\nTotal de sapos: %d\n", totalCoelhos, totalRatos, totalSapos);
        System.out.printf ("Percentual de coelhos: %.2f %%\n", percentualCoelhos);
        System.out.printf ("Percentual de ratos: %.2f %%\n", percentualRatos);
        System.out.printf ("Percentual de sapos: %.2f %%\n", percentualSapos);
    }
}
