package lab2;

import java.text.DecimalFormat;

public class Plate {
    private  int m=0, h=0, s=0;
    private final int total= 48436;

    public Plate(String s) {
        String[] j = s.split(":");
        if (j.length > 1) {
            this.s = Integer.parseInt(j[2]);
            this.m = Integer.parseInt(j[1]);
            this.h = Integer.parseInt(j[0]);
        } 
        else{
            this.s = Integer.parseInt(j[0]);
        }

    }

    public Plate( int h,  int m,  int s) {
        this.h=h;
        this.m=m;
        this.s=s;
    }

    public int convert_seconds(){
        return (h*3600+m*60+s)%total;
    }

    public Plate converttoHMS(){
        int d=this.convert_seconds();
        int h =(int) Math.floor(d / 3600);
        int m = (int)Math.floor(d % 3600 / 60);
        int s=(int)Math.floor(d % 3600%60);
        return new Plate(h,m,s);
    }

    public Plate dist(Plate p){
        int t=(this.convert_seconds()+p.convert_seconds())%total;
        return new Plate(Integer.toString(t)).converttoHMS();
    }



    public String toString(){
        DecimalFormat formatter = new DecimalFormat("00");
        return formatter.format(h)+":"+formatter.format(m)+":"+formatter.format(s);
    }


}
