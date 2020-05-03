import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        Scanner sc=new Scanner(System.in);
        List<String> l=new List<String>();
        int times=Integer.parseInt(sc.nextLine());
        while(sc.hasNextLine()){
            String s=sc.nextLine();
            l.add(s);
        }
        sc.close();
        long startTime = System.nanoTime();
        GOL gol=new GOL(l,times);
        gol.run();
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=afterUsedMem-beforeUsedMem;
        long duration = (endTime - startTime)/1000000;
        System.out.println(actualMemUsed*Math.pow(10, -6)+" mb");
        System.out.println(duration+"ms");
    }
}