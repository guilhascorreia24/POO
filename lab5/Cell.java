

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

    public Cell isBorn(Ponto p) {

        if (this.getState() == 0) {
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

    //@SuppressWarnings("rawtypes")
    public Cell diagonalE(LinkedListCircular a, LinkedListCircular b, int i) {
        Cell r = new Cell(0, new Ponto(i,this.getPonto().getY()+1));
        if(this.getPonto().getY()+1<b.size() && i>=0 && i<a.size()){
            LinkedListCircular.Node E=a.get(i).getE();
            while(E instanceof LinkedListCircular.DataNode){
                LinkedListCircular.Node o=E;
                while(o instanceof LinkedListCircular.DataNode){
                    o=o.getS();
                }
               // System.out.println(b.getindex(o)+" "+(this.getPonto().getY()+1));
                if(b.getindex(o)==this.getPonto().getY()+1){
                    r.setState(1);
                    break;
                }
                E=E.getE();
            }
        }
        return r;
    }

    //@SuppressWarnings("rawtypes")
    public Cell diagonalO(LinkedListCircular a, LinkedListCircular b, int i) {
        Cell r = new Cell(-1, new Ponto(i, this.getPonto().getY()-1));
        if(this.getPonto().getY()>0 && i>=0 && i<a.size()){
            LinkedListCircular.Node E=a.get(i).getE();
            while(E instanceof LinkedListCircular.DataNode){
                LinkedListCircular.Node o=E;
                while(o instanceof LinkedListCircular.DataNode){
                    o=o.getS();
                }
                //System.out.println(b.getindex(o)+" "+(this.getPonto().getY()-1));
                if(b.getindex(o)==this.getPonto().getY()-1){
                    r.setState(1);
                    break;
                }
                E=E.getE();
            }
        }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell E(LinkedListCircular row, int i) {
        LinkedListCircular.Node n = row.get(i).getE();
        Cell r = new Cell(-1,new Ponto(-1,-1));
        LinkedListCircular.DataNode o = null;
        if (this != new Cell(-1,new Ponto(-1,-1))) {
            while (n instanceof LinkedListCircular.DataNode) {
                o = (LinkedListCircular.DataNode) n;
                if (o.getvalue().equals(this.getPonto()) && n.getE() instanceof LinkedListCircular.DataNode) {
                    o = (LinkedListCircular.DataNode) o.getE();
                    r = new Cell(1, (Ponto) o.getvalue());
                    break;
                }
                n = n.getE();
            }
        }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell S(LinkedListCircular col, int i) {
        LinkedListCircular.Node n = col.get(i).getS();
        Cell r = new Cell(-1,new Ponto(-1,-1));
        LinkedListCircular.DataNode o = null;
        if (this != new Cell(-1,new Ponto(-1,-1))) {
            while (n instanceof LinkedListCircular.DataNode) {
                o = (LinkedListCircular.DataNode) n;
                if (o.getvalue().equals(this.getPonto()) && n.getS() instanceof LinkedListCircular.DataNode) {
                    o = (LinkedListCircular.DataNode) o.getS();
                    r = new Cell(1, (Ponto) o.getvalue());
                    break;
                }
                n = n.getS();
            }
        }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell N(LinkedListCircular col, int i) {
        LinkedListCircular.Node n = col.get(i).getS(), m = col.get(i);
        Cell r = new Cell(-1,new Ponto(-1,-1));
        LinkedListCircular.DataNode o = null;
        if (this != new Cell(-1,new Ponto(-1,-1))) {
            while (n instanceof LinkedListCircular.DataNode) {
                o = (LinkedListCircular.DataNode) n;
                if (o.getvalue().equals(this.getPonto()) && m instanceof LinkedListCircular.DataNode) {
                    o = (LinkedListCircular.DataNode) m;
                    r = new Cell(1, (Ponto) o.getvalue());
                    break;
                }
                m = (LinkedListCircular.Node) n;
                n = n.getS();
            }
        }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell O(LinkedListCircular row, int i) {
        LinkedListCircular.Node n = row.get(i).getE(), m = row.get(i);
        Cell r = new Cell(-1,new Ponto(-1,-1));
        LinkedListCircular.DataNode o = null;
        if (this != new Cell(-1,new Ponto(-1,-1))) {
            while (n instanceof LinkedListCircular.DataNode) {
                o = (LinkedListCircular.DataNode) n;
                if (o.getvalue().equals(this.getPonto()) && m instanceof LinkedListCircular.DataNode) {
                    o = (LinkedListCircular.DataNode) m;
                    r = new Cell(1, (Ponto) o.getvalue());
                    break;
                }
                m = (LinkedListCircular.Node) n;
                n = n.getE();
            }
        }
        return r;
    }

}