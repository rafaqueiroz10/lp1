package br.cefetmg.inf.llp1.lista04.p1071;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, y;
        Scanner input = new Scanner (System.in);
        x = input.nextInt();
        y = input.nextInt();
        
        if (x > y) {
            int aux = x;
            x = y;
            y = aux;
        }

        int contImpares = 0; 

        for (int i = x + 1; i < y; i++) {
            if (i % 2 != 0)
                contImpares += i;
        }
        
        System.out.println (contImpares);
    }
}
