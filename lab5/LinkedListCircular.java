public class LinkedListCircular {
    private SentinelNode head, last;
    private int i = 0;
    private Cell Scell,eCell;

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
        public SentinelNode(Node E,Node s,SentinelNode next) {
            super(E,s);
            this.next = next;
        }

        public SentinelNode getnext() {
            return this.next;
        }

        @Override
        public void setE(Node e) {
            super.setE(e);
        }
        public String toString(){
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

        public String toString(){
            return String.valueOf(value);
        }

        public T getvalue() {
            return this.value;
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

    public void add(boolean row) {
        SentinelNode l = new SentinelNode(null,null,null);
        if(row) l.setE(l);
        else l.setS(l);
        if (head == null) {
            head = l;
        } else {
            last.next = l;
        }
        last = l;
        last.next = head;
        i++;
    }

    public void addfirst(SentinelNode SN) {
        SentinelNode l = SN;
        last.next = l;
        l.next = head;
        head = l;
        i++;
    }

    /*---------------------------------------------end add----------------------------------------------------*/

    public Node getlastNode() {
        SentinelNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        return last;
    }


    public Node getfirstNode() {
        return head;
    }

    public int getindex(Node s){
        last=head;
        int i=0;
        while(last!=s){
            i++;
            last=last.next;
        }
        return i;
    }

    public Node get(int index) {
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

    public boolean hasnextCell(Node i){
        return i instanceof DataNode;
    }
    
    @SuppressWarnings("rawtypes")
    public Cell getfirstCellE(int i) {
        Node n=get(i);
        if(n.getE() instanceof DataNode){
            DataNode o= (DataNode) get(i).getE();
            Scell=new Cell(1,(Ponto)o.getvalue());
            return Scell;
        }
        return new Cell(-1,new Ponto(-1,-1));
    }

    @SuppressWarnings("rawtypes") 
    public Cell getfirstCellS(int i) {
        Node n=get(i);
            if(n.getS() instanceof DataNode){
                DataNode o= (DataNode) get(i).getS();
                eCell = new Cell(1, (Ponto) o.getvalue());
                return eCell;
            }
        return new Cell(-1,new Ponto(-1,-1));
     }

   /* @SuppressWarnings("rawtypes") 
    public Cell nextCellE(Cell c,int i){
        Node n=get(i).getE();
        Cell r=null;
        DataNode o=null;
        if(c!=null){
        while(n instanceof DataNode){
            o=(DataNode)n;
            if(o.getvalue().equals(c.getPonto()) && n.getE() instanceof DataNode){
                o=(DataNode) o.getE();
                r=new Cell(1,(Ponto)o.getvalue());
            }
            n=n.getE();
        }
    }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell nextCellS(Cell c,int i){
        Node n=get(i).getS();
        Cell r=null;
        DataNode o=null;
        if(c!=null){
        while(n instanceof DataNode){
            o=(DataNode)n;
            if(o.getvalue().equals(c.getPonto()) && n.getS() instanceof DataNode){
                o=(DataNode) o.getS();
                r=new Cell(1,(Ponto)o.getvalue());
            }
            n=n.getS();
        }
    }
        return r;
    }

    @SuppressWarnings("rawtypes")
    public Cell northCell(Cell c,int i){
        Node n=get(i).getS(),m=get(i);
        Cell r=null;
        DataNode o=null;
        if(c!=null){
        while(n instanceof DataNode){
            o=(DataNode)n;
            if(o.getvalue().equals(c.getPonto()) && m instanceof DataNode){
                o=(DataNode) m;
                r=new Cell(1,(Ponto)o.getvalue());
            }
            m=(Node)n;
            n=n.getS();
        }
    }
        return r;
    }

    
    @SuppressWarnings("rawtypes")
    public Cell Ocell(Cell c,int i){
        Node n=get(i).getE(),m=get(i);
        Cell r=null;
        DataNode o=null;
        if(c!=null){
        while(n instanceof DataNode){
            o=(DataNode)n;
            if(o.getvalue().equals(c.getPonto()) && m instanceof DataNode){
                o=(DataNode) m;
                r=new Cell(1,(Ponto)o.getvalue());
            }
            m=(Node)n;
            n=n.getE();
        }
    }
        return r;
    }*/


    /*----------------------------------------------------end gets------------------------------------------------*/
    public int size() {
        return i;
    }
    /*------------------------------------------------------end size-------------------------------------------*/

    public void clear(){
        SentinelNode g=(SentinelNode) head.getnext();
        while(g!=head){
            SentinelNode h=g;
            g=null;
            i--;
            g=h.getnext(); 
        }
        head=null;
        i--;
    }

    public void removeNode(Node s){
        last=head.next;
        SentinelNode prev=head;
        while(last!=s){
            last=last.next;
            prev=prev.next;
        }
        prev.next=last.next;
    }

    public void associateTo(Ponto p,LinkedListCircular col){
        int i=p.getX(),j=p.getY();
        Node s=get(i);
        Node h=s;
            while(h.getE()!=s){
                h=h.getE();
            }
            Node o=new DataNode<Ponto>(get(i), null, p);
            h.setE(o);
        s=col.get(j);
        h=s;
            while(h.getS()!=s){
                h=h.getS();
            }
            o.setS(col.get(j));
            h.setS(o);
        
    }

    public boolean contains(Cell p,int lineIndex){
        SentinelNode n=(SentinelNode) get(lineIndex);
        Node n1=n.getE();
        while(n1!=n){
                if(p.getPonto().toString().equals(n1.toString())){
                    return true;
                }
            n1=n1.getE();
        }
        return false;
    }

    //----------------------------------------------remove-----------------------------------------------------*/

    private void printDataNodesrow(){
        Node g=last.getE();
        System.out.print("[ ");
        while(g instanceof DataNode){
            System.out.print(g+" ");
            g=g.getE();}
        System.out.print(" ]");
    }
    public void printListrow() 
    { 
        last = head; 
   
        System.out.print("LinkedList:\n");
            
        System.out.print(last+" ");
        if(last.getE() instanceof DataNode){
            printDataNodesrow();
        } 
        System.out.println();
        last=last.next;
        // Traverse through the LinkedList 
        while (last != head) { 
            // Print the data at current node 
            System.out.print(last+ " ");
            if(last.getE() instanceof DataNode){
                printDataNodesrow();
            } 
            // Go to next node 
            last = last.next; 
            System.out.println();
        } 
          
        System.out.println(); 
    } 
    private void printDataNodescol(){
        Node g=last.getS();
        System.out.print("[ ");
        while(g instanceof DataNode){
            System.out.print(g+" ");
            g=g.getS();}
        System.out.print(" ]");
    }
    public void printListcol() 
    { 
        last = head; 
   
        System.out.print("LinkedList:\n");
            
        System.out.print(last+" ");
        if(last.getS() instanceof DataNode){
            printDataNodescol();
        } 
        System.out.println();
        last=last.next;
        // Traverse through the LinkedList 
        while (last != head) { 
            // Print the data at current node 
            System.out.print(last+ " ");
            if(last.getS() instanceof DataNode){
                printDataNodescol();
            } 
            // Go to next node 
            last = last.next; 
            System.out.println();
        } 
          
        System.out.println(); 
    } 
    /*------------------------------------------------------------print---------------------------------------*/

}