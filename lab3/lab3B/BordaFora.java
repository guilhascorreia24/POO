package lab3.lab3B;

//package lab3B;
import java.util.ArrayList;
import java.util.List;

public class BordaFora {
    private List<Integer> p;
    private String s;
    private int step = 1;

/**
 * 
 * @param s string do input
 * @inv this.s e o input sem condicoes;
 * @inv p e a lista de conversao 
 * @throws  new IllegalArgumentException("error") se o tamanho de caracteres for impar e o valor do input for maior que 99999999 e menor que 10
 * 
 */
    public BordaFora(String s) {
        this.s = s;
        p = new ArrayList<Integer>();
        char[] a = s.toCharArray();
        if (a.length % 2 != 0 || Integer.parseInt(s)>=99999999 || Integer.parseInt(s)<=10) {
            throw new IllegalArgumentException("error");
        }
        convertToBinary(a);
    }
/**
 * 
 * @param a array de input repartido
 * retorna uma lista que formada por 1 e 0
 */
    private void convertToBinary(char[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < Character.getNumericValue(a[i]); j++) {
                if (i % 2 != 0) {
                    p.add(1);
                } else
                    p.add(0);
            }
        }
    }     
/**
 * faz uma copia do objecto
 */
    public BordaFora clone() {
        return new BordaFora(s);
    }
/**
 * a funcao verifica a cada iteracao (step-1) se ha algum 0 
 * e caso a iteracao esteja numa posicao com valor 1 
 * volta ao inicio+step-1 
 * @return o numero de passos necessarios para saltar sem remover da lista nenhum inimigo
 */
    public int steps() {
        BordaFora news = clone();
        List<Integer> o = p;
        int i = step - 1;
        while (o.contains(0)) {
            // System.out.println(o+" "+step+" "+i);
            if (o.get(i) == 1) {
                step++;
                BordaFora t = clone();
                o.clear();
                o = news.p;
                news = t;
                i = (step - 1) % o.size();
            } else {
                o.remove(i);
                i--;
                i = (i + step) % o.size();
            }
        }
        return step;
    }
}
// 4444
