
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ponto p1 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p2 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p3 = new Ponto(sc.nextDouble(), sc.nextDouble());
        Ponto p4 = new Ponto(sc.nextDouble(), sc.nextDouble());

        Circunferencia o = new Circunferencia(p1, p2, p3);
        DecimalFormatSymbols s = new DecimalFormatSymbols();
        s.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", s);
        System.out.println(df.format(o.distancia(p4)));
        sc.close();
    }
}