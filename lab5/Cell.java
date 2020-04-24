public class Cell {

<<<<<<< HEAD
    private int STATE = 1;
    private Ponto p;
=======
private int STATE;
>>>>>>> 176b052848d029fbaef070872430ec2681cf0988

    public Cell(int state, Ponto p) {
        this.STATE = state;
        this.p = p;
    }

    public int getState() {
        return STATE;
    }

    public void setCell(int newValue) {
        this.STATE = newValue;
    }

    public boolean isAlive() {

        if (this.getState() == 1)
            return true;

        return false;
    }

    public int isDead() {

        if (this.getState() == 1)
            return 0;

        return 1;
    }

    public int isBorn() {

        if (this.getState() == 0) {
            this.setCell(1);
        }
        return 0;
    }

    public void setPonto(Ponto p) {
        this.p = p;
    }

    public Ponto getPonto() {
        return p;
    }

    public String toString() {
        return STATE + "@" + p;
    }

}