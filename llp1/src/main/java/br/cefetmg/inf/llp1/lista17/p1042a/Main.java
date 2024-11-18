package br.cefetmg.inf.llp1.lista17.p1042a;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new PriorityQueue<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Integer vetor[] = new Integer[3];
        
        for(int i = 0; i < 3; i++) {
            int number = input.nextInt();
            queue2.add(number);
            vetor[i] = number;
        }
        
        Collections.sort(Arrays.asList(vetor));
        for(int i = 0; i < vetor.length; i++)  
            queue.add(vetor[i]);
        
        try {
            while(true) {
                System.out.println(queue.remove());
            }
        }
        catch(NoSuchElementException e) {
            System.out.println();
        }
        
        try {
            while(true) {
                System.out.println(queue2.remove());
            }
        }
        catch(NoSuchElementException e) {}
    }
}
