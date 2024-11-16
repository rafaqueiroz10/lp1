package br.cefetmg.inf.llp1.lista16.p1255;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        for(int caso = 0; caso < n; caso++) {
            String str = input.nextLine().toLowerCase();

            int ocorrencias[] = new int[26];
            for(int i = 0; i < 26; i++) 
                ocorrencias[i] = 0;
            
            char letras[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

            for(int i = 0; i < str.length(); i++) 
                for(int j = 0; j < letras.length; j++) 
                    if(str.charAt(i) == letras[j]) 
                        ocorrencias[j]++;

            int max = ocorrencias[0];
            for(int i = 1; i < 26; i++) 
                if(ocorrencias[i] > max)
                    max = ocorrencias[i];

            for(int i = 0; i < 26; i++) 
                if(ocorrencias[i] == max) 
                    System.out.print(letras[i]);

            System.out.println();
        }
    }
}
