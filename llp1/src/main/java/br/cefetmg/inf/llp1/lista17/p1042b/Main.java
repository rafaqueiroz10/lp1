package br.cefetmg.inf.llp1.lista17.p1042b;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        list.add(a);
        list.add(b);
        list.add(c);
        
        list2.add(a);
        list2.add(b);
        list2.add(c);
        
        Collections.sort(list);
        
        try {
            int i = 0;
            while(true) {
                System.out.println(list.get(i));
                i++;
            }
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println();
        }
        
        try {
            int i = 0;
            while(true) {
                System.out.println(list2.get(i));
                i++;
            }
        }
        catch(IndexOutOfBoundsException e) {}
    }
}