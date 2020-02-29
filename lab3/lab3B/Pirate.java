package lab3.lab3B;

public class Pirate {
    private int[] enimes,allies;
    public Pirate(String s) {
        char[] a=s.toCharArray();
        if(a.length%2!=0 || a.length<2 && a.length>8){System.exit(0);}
        enimes=new int[a.length/2];
        allies=new int[a.length/2];
        groups(a);
    }


    

}
