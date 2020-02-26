package lab3;

public class Pirate {
    private int[] enimes,allies;
    public Pirate(String s) {
        char[] a=s.toCharArray();
        if(a.length%2!=0 || a.length<2 && a.length>8){System.exit(0);}
        enimes=new int[a.length/2];
        allies=new int[a.length/2];
        groups(a);
    }

    private void groups(char[] a){
        int enime=0,allie=0;
        for(int i=0;i<a.length;i++){
            if(i%2!=0){
                allies[allie++]=a[i]-'0';
            }else{ 
                enimes[enime++]=a[i]-'0';
            }
        }
    }

    public int sum(){
        int e=0,a=0,i=0,j=0;
        while(e<=a && i<allies.length){
            e+=enimes[j++];
            a+=allies[i++];
        }
        if(i<allies.length){a=a-allies[i-=1];}
        if(a+e>9999) System.exit(0);
        return a+e;
    }
    

}
