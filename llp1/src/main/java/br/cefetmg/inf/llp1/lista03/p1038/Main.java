package br.cefetmg.inf.llp1.lista03.p1038;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int codigo, quantidade;
        codigo = input.nextInt();
        quantidade = input.nextInt();

        double valorTotal = 0;
        
        switch (codigo) {
            case 1: valorTotal = 4 * quantidade; break;
            case 2: valorTotal = 4.5 * quantidade; break;
            case 3: valorTotal = 5 * quantidade; break;
            case 4: valorTotal = 2 * quantidade; break;
            case 5: valorTotal = 1.5 * quantidade;
        }

        System.out.printf("Total: R$ %.2f\n", valorTotal);
    }
}
