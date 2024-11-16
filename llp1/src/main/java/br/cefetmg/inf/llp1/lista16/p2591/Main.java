package br.cefetmg.inf.llp1.lista16.p2591;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        input.nextLine();
        
        for(int caso = 0; caso < c; caso++) {
            String str = input.nextLine();
            
            int letrasAAposk = 0, letrasAAposH = 0;
            for(int i = 1; str.charAt(i) == 'a'; i++) 
                letrasAAposH++;
            
            int i = 0;
            while(str.charAt(i) != 'k')
                i++;
            
            for(i++; str.charAt(i) == 'a'; i++)
                letrasAAposk++;
            
            System.out.printf("k");
            int produtoLetrasA = letrasAAposk * letrasAAposH;
            for(int j = 1; j < produtoLetrasA + 1; j++)
                System.out.printf("a");
            
            System.out.println();
        }
    }
}