public class LinkedListCircular<T> {
    private SentinelNode head, last;
    private int i = 0;
    private boolean row;

    public LinkedListCircular(boolean row){
        this.row=row;
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

        public void setValue(T value){
            this.value=value;
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

    public void add() {
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

    public void addfirst() {
        SentinelNode l = new SentinelNode(null, null, null);
        l.setE(l);
        last.next=l;
        Node k=head;
        head=l;
        head.next= (SentinelNode) k;
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
    public Object getfirstCellE(int i) {
        Node n=get(i);
        if(n.getE() instanceof DataNode){
            DataNode o= (DataNode) get(i).getE();
            Cell Scell=new Cell(1,(Ponto)o.getvalue());
            return Scell;
        }
        return new Cell(0,new Ponto(-1,-1));
    }


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

    @SuppressWarnings("rawtypes")
    public void removeAssociation(T p,int i){
        if(contains(p,i)){
            Node n=get(i).getE();
            while(n instanceof DataNode){
                Node o=n.getE();
                if(o instanceof DataNode){
                    if(((DataNode) o).getvalue().equals(p)) 
                        n.setE(o.getE());
                }
                n=n.getE();
            }
        }
    }

    public void associateTo(int i,int j,LinkedListCircular<T> col,T p){
        Node s=get(i);
        Node h=s;
            while(h.getE()!=s){
                h=h.getE();
            }
            Node o=new DataNode<T>(get(i), null, p);
            h.setE(o);
        s=col.get(j);
        h=s;
            while(h.getS()!=s){
                h=h.getS();
            }
            o.setS(col.get(j));
            //System.out.println(o);
            h.setS(o);  
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public T nextcellHorizon(T x,int i){
        Node n=get(i).getE();
        while(n instanceof DataNode){
            DataNode n1= (DataNode) n;
            if(n1.getvalue().equals(x) && n1.getE() instanceof DataNode){
                n1=(DataNode)n1.getE();
                return (T)n1.getvalue();
            }
            n=n.getE();
        }
        return null; 
    }
    @SuppressWarnings({"rawtypes","unchecked"})
    public T nextcellvertical(T x,int i){
        Node n=get(i).getS();
        while(n instanceof DataNode){
            DataNode n1= (DataNode) n;
            if(n1.getvalue().equals(x) && n1.getS() instanceof DataNode){
                n1=(DataNode)n1.getS();
                return (T)n1.getvalue();
            }
            n=n.getS();
        }
        return null; 
    }

    public boolean contains(T p,int lineIndex){
       // System.out.println(lineIndex);
        if(lineIndex<0 || lineIndex>=i){
            return false;
        }
        SentinelNode n=(SentinelNode) get(lineIndex);
        Node n1=n.getE();
       //System.out.println(n1 instanceof DataNode);
        while(n1 instanceof DataNode){
            //System.out.println(p.toString().equals(n1.toString()));
            //System.out.println(n1.toString());
                if(p.toString().equals(n1.toString())){
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
   
        System.out.print("LinkedListRow:\n");
            
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
   
        System.out.print("LinkedListCol:\n");
            
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