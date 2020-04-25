public class Cell{

    private int STATE;
    private Ponto p;


    public Cell(int state, Ponto p) {
        this.STATE = state;
        this.p = p;
    }

    public int getState() {
        return STATE;
    }


    public void setState(int i){
        this.STATE=i;
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

    public Cell isBorn(Ponto p) {

        if (this.getState() == 0) {
            return new Cell(1,p);
        }
        return null;
    }

    public String toString() {
        return STATE + "@" + p;
    }

}