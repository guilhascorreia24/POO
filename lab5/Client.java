import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        List<String> l=new List<String>();
        Scanner sc=new Scanner(System.in);
        int times=Integer.parseInt(sc.nextLine());
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            l.add(s);
        }
        sc.close();
        GOL gol=new GOL(l,times);
        gol.run();
    }
}