package br.cefetmg.inf.llp1.lista16.p2866;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        input.nextLine();
        
        for(int i = 0; i < c; i++) {
            String s = input.nextLine();
            
            for(int j = s.length()-1; j > -1; j--) 
                if(s.charAt(i) > 96 && s.charAt(i) < 123) 
                    System.out.printf("%c", s.charAt(j));
                
            System.out.println();
        }
    }
}