package lab2;

import java.util.Scanner;

public class client {
    public static void main( String [] s) {
     Scanner sc = new Scanner (System.in);
     Hora p = new Hora(sc.nextLine());
     String k=sc.nextLine();
    if(k.equals("asSeconds")){
        System.out.println(p.convert_seconds());
    }else if(k.equals("asTime")){
        System.out.println(p.converttoHMS());
    }
    else if(k.equals("add")){
        Hora q = new Hora(sc.nextLine());
        System.out.println(q.add(p));
    }
    else{
        System.exit(0);
    }
    sc.close();
    }
    }