public class LinkedListCircular<T> implements MyList{
    private SentinelNode head, last;
    private int i,inicial;
    private boolean row;
    private LinkedListCircular<T> col;

    public LinkedListCircular() {
        this.row = true;
    }

    @SuppressWarnings("unchecked")
    public void Col(LinkedListCircular<?> b) {
        this.col = (LinkedListCircular<T>) b;
        col.row = false;
    }

    /*-----------------------------------------Nodes----------------------*/
    public static class Node {
        private Node E, S;

        public Node(Node E, Node S) {
            this.E = E;
            this.S = S;
        }

        public Node getE() {
            return this.E;
        }

        public Node getS() {
            return this.S;
        }

        public void setE(Node e) {
            this.E = e;
        }

        public void setS(Node s) {
            this.S = s;
        }
    }

    public static class SentinelNode extends Node {
        private SentinelNode next;

        public SentinelNode(Node E, Node s, SentinelNode next) {
            super(E, s);
            this.next = next;
        }

        public SentinelNode getnext() {
            return this.next;
        }

        @Override
        public void setE(Node e) {
            super.setE(e);
        }

        public String toString() {
            return "sent";
        }

        @Override
        public Node getE() {
            return super.E;
        }

        @Override
        public Node getS() {
            return super.S;
        }
    }

    public static class DataNode<T> extends Node {
        private T value;

        public DataNode(Node E, Node S, T value) {
            super(E, S);
            this.value = value;
        }

        public String toString() {
            return String.valueOf(value);
        }

        public T getvalue() {
            return this.value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public Node getE() {
            return super.E;
        }

        @Override
        public Node getS() {
            return super.S;
        }

    }
    /*---------------------------------------------end Nodes-----------------------------------*/

    public void addLine() {
        SentinelNode l = new SentinelNode(null, null, null);
        if (row)
            l.setE(l);
        else
            l.setS(l);
        if (head == null) {
            this.inicial=0;
            head = l;
        } else {
            last.next = l;
        }
        last = l;
        last.next = head;
        i++;
    }

    public void addfirstLine() {
        SentinelNode l = new SentinelNode(null, null, null);
        if(row) l.setE(l);
        else l.setS(l);
        last.next = l;
        Node k = head;
        head = l;
        head.next = (SentinelNode) k;
        i++;
        this.inicial-=1;
    }

    /*---------------------------------------------end add----------------------------------------------------*/

    public Node getlastLine() {
        SentinelNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        return last;
    }

    public Node getfirstLine() {
        return head;
    }

    @SuppressWarnings("rawtypes")
    public int getindexOf(T s, int linhadoobjecto) {
        Node n = getLinha(linhadoobjecto).getE();
        int i = 0;
        while (n instanceof DataNode) {
            DataNode k = (DataNode) n;
            if (k.getvalue().equals(s)) {
                return i;
            }
            n = n.getE();
            i++;
        }
        return -1;
    }

    public Node getLinha(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        int o = 0;
        SentinelNode curr = head;
        while (o < index) {
            curr = curr.next;
            o++;
        }
        return curr;
    }

    public int getfirstIndex(){
        return inicial;
    }
    @Override
    @SuppressWarnings("rawtypes")
    public Object getfirstElementOf(int i) {
        Node n = getLinha(i);
        if (n.getE() instanceof DataNode) {
            DataNode o = (DataNode) getLinha(i).getE();
            Cell Scell = new Cell(1, (Ponto) o.getvalue());
            return Scell;
        }
        return new Cell(0, new Ponto(-1, -1));
    }

    @SuppressWarnings("unchecked")
    public Object getElementof(int i, int j) {
        Object o = getfirstElementOf(i);
        int k = 0;
        while (k < j) {
            if (k == j) {
                return o;
            }
            k++;
            o = nextcellHorizon((T) o, i);
        }
        return null;
    }

    public LinkedListCircular<T> getColList() {
        return col;
    }

    /*----------------------------------------------------end gets------------------------------------------------*/
    public int size() {
        return i;
    }
    /*------------------------------------------------------end size-------------------------------------------*/
    @Override
    public void clear() {
        SentinelNode g = (SentinelNode) head.getnext();
        while (g != head) {
            SentinelNode h = g;
            g = null;
            i--;
            g = h.getnext();
        }
        head = null;
        i--;
    }

    @SuppressWarnings("rawtypes")
    public void removeAssociationOf(Object p, int i) {
        if (contains(p, i)) {
            Node n = getLinha(i);
            while (n.getE() instanceof DataNode) {
                Node o = n.getE();
                if (o instanceof DataNode) {
                    if (((DataNode) o).getvalue().toString().equals(p.toString()))
                        n.setE(o.getE());
                }
                n = n.getE();
            }
        }
    }

    // associar um objecto a uma linha e a uma coluna que exista
    @SuppressWarnings("unchecked")
    public void associateTo(int i, int j,Object p) {
        if(i>=size() || j>=col.size() || i<inicial || j< col.inicial){
            throw new IndexOutOfBoundsException();
        }
        if (i < size() && i >= inicial && j < col.size() && j >= col.inicial) {
            Node s = getLinha(i);
            Node h = s;
            while (h.getE() != s) {
                h = h.getE();
            }
            Node o = new DataNode<T>(getLinha(i), null, (T)p);
            h.setE(o);
            s = col.getLinha(j);
            h = s;
            while (h.getS() != s) {
                h = h.getS();
            }
            o.setS(col.getLinha(j));
            h.setS(o);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object nextcellHorizon(T x, int i) {
        if(i>=size() ||  i<inicial ){
            throw new IndexOutOfBoundsException();
        }
        Node n = getLinha(i).getE();
        while (n instanceof DataNode) {
            DataNode n1 = (DataNode) n;
            if (n1.getvalue().equals(x) && n1.getE() instanceof DataNode) {
                n1 = (DataNode) n1.getE();
                return (T) n1.getvalue();
            }
            n = n.getE();
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object nextcellvertical(T x, int i) {
        if(i>=col.size() || i< col.inicial){
            throw new IndexOutOfBoundsException();
        }
        Node n = getLinha(i).getS();
        while (n instanceof DataNode) {
            DataNode n1 = (DataNode) n;
            if (n1.getvalue().equals(x) && n1.getS() instanceof DataNode) {
                n1 = (DataNode) n1.getS();
                return (T) n1.getvalue();
            }
            n = n.getS();
        }
        return null;
    }

    public boolean contains(Object p, int lineIndex) {
        if (lineIndex < inicial || lineIndex >= i) {
            return false;
        }
        SentinelNode n = (SentinelNode) getLinha(lineIndex);
        Node n1 = n.getE();
        while (n1 instanceof DataNode) {
            if (p.toString().equals(n1.toString())) {
                return true;
            }
            n1 = n1.getE();
        }
        return false;
    }

    // ----------------------------------------------remove-----------------------------------------------------*/

    private void printDataNodesrow() {
        Node g = last.getE();
        System.out.print("[ ");
        while (g instanceof DataNode) {
            System.out.print(g + " ");
            g = g.getE();
        }
        System.out.print(" ]");
    }

    public void printListrow() {
        last = head;

        System.out.print("LinkedListRow:\n");

        System.out.print(last + " ");
        if (last.getE() instanceof DataNode) {
            printDataNodesrow();
        }
        System.out.println();
        last = last.next;
        while (last != head) {
            System.out.print(last + " ");
            if (last.getE() instanceof DataNode) {
                printDataNodesrow();
            }
            last = last.next;
            System.out.println();
        }

        System.out.println();
    }

    private void printDataNodescol() {
        Node g = last.getS();
        System.out.print("[ ");
        while (g instanceof DataNode) {
            System.out.print(g + " ");
            g = g.getS();
        }
        System.out.print(" ]");
    }

    public void printListcol() {
        last = head;

        System.out.print("LinkedListCol:\n");

        System.out.print(last + " ");
        if (last.getS() instanceof DataNode) {
            printDataNodescol();
        }
        System.out.println();
        last = last.next;
        while (last != head) {
            System.out.print(last + " ");
            if (last.getS() instanceof DataNode) {
                printDataNodescol();
            }
            last = last.next;
            System.out.println();
        }

        System.out.println();
    }
    /*------------------------------------------------------------print---------------------------------------*/

}