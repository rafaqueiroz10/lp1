package br.cefetmg.inf.llp1.lista16.p2292;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        
        for(int caso = 0; caso < n; caso++) {
            String str = input.next();
            long c = input.nextLong();
            input.nextLine();
            
            char lampadas[] = str.toCharArray();
            
            if(c > lampadas.length-1) 
                for(int i = 0; i < lampadas.length; i++) 
                    lampadas[i] = 'O';
            
            else {
                if(c == 1 || c % 2 != 0) { 
                    lampadas[0] = (lampadas[0] == 'O') ? 'X' : 'O';
                    c--;
                }
            
            
                for(int i = 1; c > 0 && i < lampadas.length; i++) {
                    if(lampadas[i-1] == 'X') {
                        lampadas[i] = (lampadas[i] == 'O') ? 'X' : 'O';
                        c--;
                    }
                }
            }
            
            System.out.println(new String(lampadas));
        }
    }
}