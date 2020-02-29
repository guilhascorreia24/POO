package lab3.lab3B;

import java.util.Scanner;

public class client{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        sc.close();
        Pirate p=new Pirate(s);
    }
}