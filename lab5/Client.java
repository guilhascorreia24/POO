/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
import java.util.Scanner;
public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        List<String> l=new List<String>();
        int times = Integer.parseInt(sc.nextLine().replace("\\D+",""));
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            s = s.replaceAll("\\D+","");
            l.add(s);
        }
        sc.close();
        GOL gol=new GOL(l,times);
        gol.run();
    }
}