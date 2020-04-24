public class LinkedListCircular {
    private SentinelNode head, last;
    private int i = 0;

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

    public void associateTo(int i,Cell p,boolean row){
        Node s=get(i);
        Node h=s;
        if(row){
            while(h.getE()!=s){
                h=h.getE();
            }
            h.setE(new DataNode<Ponto>(s,null,p.getPonto()));
        }else{
            while(h.getS()!=s){
                h=h.getS();
            }
            h.setE(new DataNode<Ponto>(null,s,p.getPonto()));
        }
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

    private void printDataNodes(){
        Node g=last.getE();
        System.out.print("[ ");
        while(g instanceof DataNode){
            System.out.print(g+" ");
            g=g.getE();}
        System.out.print(" ]");
    }
    public void printList() 
    { 
        last = head; 
   
        System.out.print("LinkedList:\n");
            
        System.out.print(last+" ");
        if(last.getE() instanceof DataNode){
            printDataNodes();
        } 
        System.out.println();
        last=last.next;
        // Traverse through the LinkedList 
        while (last != head) { 
            // Print the data at current node 
            System.out.print(last+ " ");
            if(last.getE() instanceof DataNode){
                printDataNodes();
            } 
            // Go to next node 
            last = last.next; 
            System.out.println();
        } 
          
        System.out.println(); 
    } 
    /*------------------------------------------------------------print---------------------------------------*/

}