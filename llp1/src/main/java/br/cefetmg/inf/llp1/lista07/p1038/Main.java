package br.cefetmg.inf.llp1.lista07.p1038;
import java.util.Scanner;

class Lanchonete {
    int codigo, quantidade;
    
    Lanchonete (int codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }
    
    double calcularConta () {
        double precos[] = {4, 4.5, 5, 2, 1.5};
        return precos[codigo-1] * quantidade;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int codigo, quantidade;
        codigo = input.nextInt ();
        quantidade = input.nextInt ();
        Lanchonete lanc = new Lanchonete (codigo, quantidade);
        System.out.printf ("Total: R$ %.2f\n", lanc.calcularConta ());
    }
}