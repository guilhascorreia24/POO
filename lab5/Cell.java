/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class Cell {
    private int STATE;
    private Ponto p;
    private int vizinhos = 0;

    /**
     * 
     * @pre state tem de ser 0 ou 1
     * @param state estado em que a celula se encontra (tipo integer)
     * @param p ponto coordenadas da celula na matriz
     * @throws IllegalArgumentException lancada quando um dos paramentros nao e o que se espera
     * @inv State estado da celula (0=morto e 1=vivo)
     * @inv p coordenada da celula
     * @inv vizinhos numero de celulas vivas vizinhas
     */
    public Cell(int state, Ponto p) throws IllegalArgumentException{
        if(state<0 || state>1){
            throw new IllegalArgumentException();
        }
        this.STATE = state;
        this.p = p;
    }

    /**
     * numero de vizinhos vivos
     * @param v numero de vizinhos vivos
     */
    public void setVizinhos(int v) {
        this.vizinhos=v;
    }

    /**
     * devolve o numero de vizinhos vivos
     * @return devolve o numero de vizinhos vivos
     */
    public int getVizinhos(){
        return vizinhos;
    }

    /**
     * devolve o estado da celula
     * @return devolve o estado da celula
     */
    public int getState() {
        return STATE;
    }

    /**
     * alterar o estado da celula
     * @param i estado da celula
     */
    public void setState(int i) {
        this.STATE = i;
    }

    /**
     * alterar as coordenadas da celula
     * @param p coordenada da celula
     */
    public void setPonto(Ponto p) {
        this.p = p;
    }

    /**
     * devolve as coordenadas da celula
     * @return devolve as coordenadas da celula
     */
    public Ponto getPonto() {
        return p;
    }

    /**
     * verifica se a celula esta viva
     * @return devolve se a celula esta viva ou morta
     */
    public boolean isAlive() {

        if (this.getState() == 1)
            return true;

        return false;
    }

    /**
     * verifica se celula tem condicoes para nacer
     * @return devolve se a celula pode nascer ou nao 
     */
    public boolean isBorn(){
        if(vizinhos==3){
            this.STATE=1;
            return true;
        }
        return false;
    }

    /**
     * devolve o formato de impressao da celula
     * @return String devolve o formato de impressao da celula
     */
    public String toString() {
        return p.toString()+" "+STATE+" "+vizinhos;
    }

    /**
     * Compara duas celulas
     * @param c celula a qual queremos comparar
     * @return devolve se as celulas sao iguais ou nao
     */
    public boolean equals(Cell c) {
        // System.out.println(c.STATE + " " + STATE);
        if (STATE == c.STATE && p.equals(c.p) && c.getVizinhos()==vizinhos) {
            return true;
        }
		return false;
    }

    /**
     * verifica se a celula tem condicoes para continuar viva
     * @return devolve se a celula continua viva ou morre
     */
    public boolean isSurvive(){
        if(vizinhos>1 && vizinhos<4 && this.isAlive()){
            return true;
        }
        return false;
    }
}