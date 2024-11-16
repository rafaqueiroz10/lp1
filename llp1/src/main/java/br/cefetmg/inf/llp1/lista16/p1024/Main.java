package br.cefetmg.inf.llp1.lista16.p1024;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        for(int caso = 0; caso < n; caso++) {
            String s = input.nextLine();

            StringBuilder str = new StringBuilder(s);
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if((c > 64 && c < '[') || (c > 96 && c < 123)) {
                    c += 3;
                    str.setCharAt(i, c);
                }
            }

            StringBuilder auxStr = new StringBuilder();
            for(int i = s.length()-1; i > -1; i--) 
                auxStr.append(str.charAt(i));

            int metadeStr = s.length() / 2;
            for(int i = metadeStr; i < s.length(); i++) { 
                char c = auxStr.charAt(i);
                auxStr.setCharAt(i, --c);
            }

            System.out.println(auxStr);
        }
    }
}
