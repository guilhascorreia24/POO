package lab3.lab3B;
//package lab3B;
import java.util.ArrayList;
import java.util.List;

public class BordaFora {
    private List<Integer> p;
    private String s;
    private int step=1;

    public BordaFora(String s) {
        this.s = s;
        p = new ArrayList<Integer>();
        char[] a = s.toCharArray();
        if (a.length % 2 != 0) {
            System.exit(0);
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < Character.getNumericValue(a[i]); j++) {
                if (i % 2 != 0) {
                    p.add(1);
                } else
                    p.add(0);
            }
        }
    }

    public BordaFora clone(){
        return new BordaFora(s);
    }


    public int steps(){
        BordaFora news=clone();
        List<Integer> o=p;
        for(int i=step-1;i<o.size();){
            System.out.println(o+" "+step+" "+i);
            if(!o.contains(0)){break;}
            if(o.get(i)==1){
                step++;
                BordaFora t=clone();
                o.clear();
                o=news.p;
                news=t;
                i=step-1;
            }else{
            o.remove(i);
            i--;
            i=(i+step)%o.size();}
        }
        return step;
        
    }


}
