public class Cell {

    private int STATE;
    private Ponto p;

    public Cell(int state, Ponto p) {
        this.STATE = state;
        this.p = p;
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

    public Cell isBorn(Cell a,Cell b) {
        if (this.isAlive() && a && b) {
            return new Cell(1, p);
        }
        return null;
    }

    public String toString() {
        return p.toString();
    }

    public boolean equals(Cell c) {
        // System.out.println(c.STATE + " " + STATE);
        if (STATE == c.STATE && p.equals(c.p)) {
            return true;
        }
		return false;
    }

    public boolean isSurvive(boolean[] vizinhos){
        int r=0;
        for(boolean t:vizinhos){
            if(t){
                r++;
            }
        }
        if(r>1 && r<4){
            return true;
        }
        return false;
    }

}