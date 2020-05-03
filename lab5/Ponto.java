/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class Ponto {
    private int x, y;

    /**
     * 
     * @param x int abcissa do ponto
     * @param y int ordenado do ponto
     * @inv this.x e a abcissa do ponto
     * @inv this.y e a ordenada do ponto
     */
    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * devolve o valor da abcissa do ponto
     * @return int devolve o valor da abcissa do ponto
     */
    public int getX(){
        return x;
    }

    /**
     * devolve o valor da ordenada do ponto
     * @return int devolve o valor da ordenada do ponto
     */
    public int getY(){
        return y;
    }

    /**
     * altera o valor da abcissa
     * @param x int valor novo da abcisssa
     */
    public void setX(int x){
        this.x=x;
    }

    /**
     * altera o valor da ordenada
     * @param y int novo valor da ordenada
     */
    public void setY(int y){
        this.y=y;
    }

    /**
     * Calcula a distancia entre 2 pontos
     * @param p Ponto ao qual queremos saber a distancia
     * @return devolve a distancia entre 2 pontos
     */
    public double dist(Ponto p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Compara 2 pontos
     * @param p Ponto que queremos comparar
     * @return devove se true se for igual e false senao
     */
    public boolean equals(Ponto p){
        if(x==p.x && y==p.y){
            return true;
        }
        return false;
    }

    /**
     * @return devolve o formato da impressao do ponto
     */
    public String toString(){
        return x+":"+y;
    }
}
