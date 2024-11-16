package br.cefetmg.inf.llp1.lista16.p1253;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        
        for(int inst = 0; inst < n; inst++) {
            String sentenca = input.nextLine();
            int indexDeslocar = input.nextInt();
            input.nextLine();
            
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < sentenca.length(); j++) {
                char ch = sentenca.charAt(j);
                if(ch - indexDeslocar < 'A')
                    s.append((char) ('Z' - (indexDeslocar - (ch - 'A')) + 1));
                else 
                    s.append((char) (ch - indexDeslocar));

            }
            
            System.out.println(s.toString());
        }
    }
}
