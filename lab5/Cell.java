public class Cell {

    private int STATE;
    private Ponto p;
    private int vizinhos = 0;

    public Cell(int state, Ponto p) throws IllegalArgumentException{
        if(state<0 || state>1){
            throw new IllegalArgumentException();
        }
        this.STATE = state;
        this.p = p;
    }

    public void setVizinhos(int v) {
        this.vizinhos=v;
    }

    public int getVizinhos(){
        return vizinhos;
    }

    public int getState() {
        return STATE;
    }

    public void setState(int i) {
        this.STATE = i;
    }

    public void setPonto(Ponto p) {
        this.p = p;
    }

    public Ponto getPonto() {
        return p;
    }

    public boolean isAlive() {

        if (this.getState() == 1)
            return true;

        return false;
    }

    public boolean isBorn(){
        if(vizinhos==3){
            this.STATE=1;
            return true;
        }
        return false;
    }


    public String toString() {
        return p.toString()+" "+STATE+" "+vizinhos;
    }

    public boolean equals(Cell c) {
        // System.out.println(c.STATE + " " + STATE);
        if (STATE == c.STATE && p.equals(c.p)) {
            return true;
        }
		return false;
    }

    public boolean isSurvive(){
        if(vizinhos>1 && vizinhos<4 && this.isAlive()){
            return true;
        }
        return false;
    }

}