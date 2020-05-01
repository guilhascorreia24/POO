public class Cell {

    private int STATE;
    private Ponto p;
    private int vizinhos = 0;
    private Cell N, NE, NO, O, E, SO, S, SE;

    public Cell(int state, Ponto p) throws IllegalArgumentException{
        if(state<0 || state>1){
            throw new IllegalArgumentException();
        }
        this.STATE = state;
        this.p = p;
    }

    public Cell getSE() {
        return SE;
    }

    public void setSE(Cell sE) {
        if(this.SE==null)
            this.SE = sE;
    }

    public Cell getS() {
        return S;
    }

    public void setS(Cell s) {
        if(this.S==null)
            this.S = s;
    }

    public Cell getSO() {
        return SO;
    }

    public void setSO(Cell sO) {
        if(this.SO==null)
            this.SO = sO;
    }

    public Cell getE() {
        return E;
    }

    public void setE(Cell e) {
        if(this.E==null)
            this.E = e;
    }

    public Cell getO() {
        return O;
    }

    public void setO(Cell o) {
        if(this.O==null)
            this.O = o;
    }

    public Cell getN() {
        return N;
    }

    public void setN(Cell n) {
        if(this.N==null)
            this.N = n;
    }

    public Cell getNE() {
        return NE;
    }

    public void setNE(Cell nE) {
        if(this.NE==null)
        this.NE = nE;
    }

    public Cell getNO() {
        return NO;
    }

    public void setNO(Cell nO) {
        if(this.NO==null)
        this.NO = nO;
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