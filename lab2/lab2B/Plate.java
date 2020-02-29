
package lab2B;
public class Plate {
    private int p1,p2,type=0;
    private String p3;
    private final int c= 5290000;

/**
 * Cria um objeto Plate(next)
 * @param next
 * @pre next!=null && s==3
 * @post p3=string nao nula && p1=inteiro positivo && p2=inteiro positivo
 * @return new Plate(next)
 */
	public Plate( String next) {
        String[] s = next.split("-");
        if(next==null || s.length!=3) System.exit(0);
        order(s);
    }
/** ordena a matricula no formato normal (LL-NN-NN)
@param s Array de string
@pre s.length==3 
@post p3=letras p2=inteiro p1=inteiro
*/
    private  void order( String[] s) {
        if (s[2].matches("[A-Z]*")) {
            p1 = Integer.parseInt(s[1]);
            p2 = Integer.parseInt(s[0]);
            p3 = s[2];
            type = 1;
        } else if (s[1].matches("[A-Z]*")) {
            p1 = Integer.parseInt(s[2]);
            p2 = Integer.parseInt(s[0]);
            p3 = s[1];
            type = 2;
        } else {
            p1 = Integer.parseInt(s[2]);
            p2 = Integer.parseInt(s[1]);
            p3 = s[0];
        }
    }
/** Calcula o valor das 2 letras juntas na base 100
@param p3 string nao nula
@pre p3!=null
@post return == valueWord();
@return inteiro com valor da palavra na base 100
*/
    public int valueWord() {
		 char[] p = p3.toCharArray();
		 int pos = value(p[0]);
         int pos1=value(p[1]);
        return pos * 23 + pos1;
	}
/** Calcula o valor das 1 letra na base 23
@param g1 char nao nulo
@pre g1!=null
@post return == value(g1);
@return inteiro com valor da letra na base 23
*/
	public int value(char g1){
        int g=g1- (int)'A';
		if((int)g1>89){
			return g-3;
		}
		else if((int)g1>87){
			return g-2;
        }
        
		else if((int)g1>75){
			return g-1;
		}
		else{
			return g;
		}
	}
/** Calcula a distancia entre as 2 matriculas this e q
@param q plate 
@pre p3!=null
@post return == dist(q);
@return inteiro com valor da distancia entre as 2 matriculas this e q
*/
    public int dist( Plate q) {
        int t=this.valueWord();
        int t1=q.valueWord();
		return Math.abs((this.p1+this.p2*100+t*10000+this.type*c)-(q.p1+q.p2*100+t1*10000+q.type*c));
	}

}
