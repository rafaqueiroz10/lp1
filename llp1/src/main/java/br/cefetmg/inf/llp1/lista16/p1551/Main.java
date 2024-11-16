package br.cefetmg.inf.llp1.lista16.p1551;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        
        for(int caso = 0; caso < n; caso++) {
            String str = input.nextLine();
            
            int[] ocorrencias = new int[26];
            
            for(int i = 0; i < ocorrencias.length; i++) 
                ocorrencias[i] = 0;
            
            char letras[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            
            for(int i = 0; i < str.length(); i++) 
                for(int j = 0; j < letras.length; j++) 
                    if(str.charAt(i) == letras[j])
                        ocorrencias[j]++;
                
            int somaLetras = 0;
            for(int i = 0; i < 26; i++) 
               if(ocorrencias[i] > 0)
                   somaLetras++;
            
            if(somaLetras == 26)
                System.out.println("frase completa");
            else if(somaLetras > 12)
                System.out.println("frase quase completa");
            else
                System.out.println("frase mal elaborada");
            
        }
    }
}