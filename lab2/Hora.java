package lab2;

import java.text.DecimalFormat;

public class Hora {
    private  int m=0, h=0, s=0;
    private final int total= 48436;
/**Cria um objeto hora(p3,p2,p1)
@param s string 
@pre j.length==3 || j.length==1
@post h=inteiro positivo && m=inteiro positivo && s=inteiro positivo
@return new hora(m,h,s)
*/
    public Hora(String s) {
        String[] j = s.split(":"); 
        if (j.length== 3) {
            if(Integer.parseInt(j[0])>=0 ) this.h=Integer.parseInt(j[0]);
            else System.exit(0);
            if(Integer.parseInt(j[1])>=0 ) this.m=Integer.parseInt(j[1]);
            else System.exit(0);
            if(Integer.parseInt(j[2])>=0) this.s=Integer.parseInt(j[2]);
            else System.exit(0);
        } 
        else if(j.length==1){
            this.s = Integer.parseInt(j[0]);
        }
        else {
            System.exit(0);
        }
        if(this.convert_seconds()>total-1){
            System.exit(0);
        }

    }

    public Hora( int h,  int m,  int s) {
        if(h>=0) this.h=h;
        else System.exit(0);
        if(m>=0) this.m=m;
        else System.exit(0);
        if(s>=0) this.s=s;
        else System.exit(0);
    }
/** Converte o formato hh:mm:ss para segundos
@param h inteiro positivo
@param m inteiro positivo
@param s inteiro positivo
@pre h >=0 && m >=0 && s>=0
@post return == convert_seconds()
@return inteiro com o conversor para segundos
*/
    public int convert_seconds(){ 
        return (h*3600+m*60+s);
    }
/** Converte para o formato hh:mm:ss
@param h inteiro positivo
@param m inteiro positivo
@param s inteiro positivo
@pre h >=0 && m >=0 && s>=0
@post return == converttoHMS()
@return Hora no formato hh:mm:ss
*/
    public Hora converttoHMS(){ 
        int d=this.convert_seconds()%total;
        int h =(int) Math.floor(d / 3600);
        int m = (int)Math.floor(d % 3600 / 60);
        int s=(int)Math.floor(d % 3600%60);
        return new Hora(h,m,s);
    }
/** Calcula a soma das duas horas this e p
@param h inteiro positivo
@param m inteiro positivo
@param s inteiro positivo
@pre h >=0 && m >=0 && s>=0
@post return == add(Hora p)
@return Hora no formato hh:mm:ss com h inteiro, m inteiro e s inteiro
*/
    public Hora add(Hora p){ 
        int t=(this.convert_seconds()%total+p.convert_seconds()%total)%total;
        return new Hora(Integer.toString(t)).converttoHMS();
    }

/** Imprime no formato hh:mm:ss
@param h inteiro positivo
@param m inteiro positivo
@param s inteiro positivo
@pre h=="%s%s" && m=="%s%s" && s=="%s%s"
@post return == toString()
@return Hora no formato hh:mm:ss
*/
    public String toString(){ 
        DecimalFormat formatter = new DecimalFormat("00");
        return formatter.format(h)+":"+formatter.format(m)+":"+formatter.format(s);
    }


}
