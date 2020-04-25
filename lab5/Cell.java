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

    public Cell NE(Cell E, Cell N, LinkedListCircular row, LinkedListCircular col) {
        if (N != null && E != null) {
            if (E.N(col, E.getPonto().getY()).getPonto() == N.E(row, N.getPonto().getX()).getPonto()) {
                return N.E(row, N.getPonto().getX());
            }
        }
        return null;
    }

    public Cell NO(Cell O, Cell N, LinkedListCircular row, LinkedListCircular col) {
        if (N != null && O != null) {
            if (O.N(col, O.getPonto().getY()).getPonto() == N.O(row, N.getPonto().getX()).getPonto()) {
                return O.N(col, O.getPonto().getY());
            }
        }
        return null;
    }

    public Cell SE(Cell E, Cell S, LinkedListCircular row, LinkedListCircular col) {
        if (S != null && E != null) {
            if (E.S(col, E.getPonto().getY()).getPonto() == S.E(row, S.getPonto().getX()).getPonto()) {
                return S.E(row, S.getPonto().getX());
            }
        }
        return null;
    }

    public Cell SO(Cell O, Cell S, LinkedListCircular row, LinkedListCircular col) {
        if (S != null && O != null) {
            if (O.S(col, O.getPonto().getY()).getPonto() == S.O(row, S.getPonto().getX()).getPonto()) {
                return S.O(row, S.getPonto().getX());
            }
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    public Cell E(LinkedListCircular row, int i) {
        LinkedListCircular.Node n = row.get(i).getE();
        Cell r = null;
        LinkedListCircular.DataNode o = null;
        if (this != null) {
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
        Cell r = null;
        LinkedListCircular.DataNode o = null;
        if (this != null) {
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
        Cell r = null;
        LinkedListCircular.DataNode o = null;
        if (this != null) {
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
        Cell r = null;
        LinkedListCircular.DataNode o = null;
        if (this != null) {
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