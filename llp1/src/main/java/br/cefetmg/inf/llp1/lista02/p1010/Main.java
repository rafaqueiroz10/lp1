package br.cefetmg.inf.llp1.lista02.p1010;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int idPecaUm = input.nextInt();
        int numPecasUm = input.nextInt ();
        double valorUnitarioPecaUm = input.nextDouble();
        int idPecaDois = input.nextInt();
        int numPecasDois = input.nextInt();
        double valorUnitarioPecaDois = input.nextDouble();
        double valorTotal = numPecasUm * valorUnitarioPecaUm + numPecasDois * valorUnitarioPecaDois;
        System.out.printf ("VALOR A PAGAR: R$ %.2f\n", valorTotal);
    }
}