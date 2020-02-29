package lab2B;
import java.util.Scanner;

public class client {
public static void main(final String [] s) {
final Scanner sc = new Scanner (System.in);
while(sc.hasNextLine()) {
     Plate p = new Plate(sc.next());
    Plate q = new Plate(sc.next());
    //System.out.println(p.toString());
    //System.out.println(q.toString());
System.out.println(p.dist(q));
}
sc.close();
}
}