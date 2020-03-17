
import java.util.*;
public class Cliente{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Ponto n=new Ponto(sc.nextDouble(),sc.nextDouble());
        Ponto m=new Ponto(sc.nextDouble(),sc.nextDouble());
        sc.close();
        double res=n.dist(m);
        System.out.print(Math.floor(res));

    }
    
}
