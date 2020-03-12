import java.util.Scanner;

public class client{
	
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Ponto p1=new Ponto(sc.nextFloat(),sc.nextFloat());
        Ponto p2=new Ponto(sc.nextFloat(),sc.nextFloat());
        Ponto p3=new Ponto(sc.nextFloat(),sc.nextFloat());
        Ponto p4=new Ponto(sc.nextFloat(),sc.nextFloat());
        Circunferencia o=new Circunferencia(p1,p2,p3);
        System.out.println(o.distancia(p4));
    }
}