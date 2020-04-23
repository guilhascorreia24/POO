import java.util.Iterator;

public class LinkedListCircular<T> implements Iterable<T> {
    private SentinelNode head, last;
    private int i = 0;

    /*-----------------------------------------Nodes----------------------*/
    public static class Node {
        private Node E, S;
        private int i;
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

        public String toString() {
            return E + ":" + S;
        }

        public void setindex(int i){
            this.i=i;
        }

        protected int getindex(){
            return i;
        }
    }

    public static class SentinelNode extends Node {
        private SentinelNode next;
        public SentinelNode(Node E, Node S, SentinelNode next) {
            super(E, S);
            this.next = next;
        }

        public String toString() {
            return getE() + ":" + getS() + ":" + next;
        }

        public SentinelNode getnext() {
            return this.next;
        }

        @Override
        public void setindex(int i) {
            super.setindex(i);
        }

        @Override
        protected int getindex() {
            // TODO Auto-generated method stub
            return super.getindex();
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

    public void add(Node SN) {
        SentinelNode l = new SentinelNode(SN.E, SN.S, null);
        if (head == null) {
            head = l;
        } else {
            last.next = l;
        }
        last = l;
        last.next = head;
        i++;
        last.setindex(i-1);
    }

    public void addfirst(Node SN) {
        SentinelNode l = new SentinelNode(SN.E, SN.S, null);
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

    public int getindex(Node n){
        return n.getindex();
    }

    /*----------------------------------------------------end gets------------------------------------------------*/
    public int size() {
        return i;
    }
    /*------------------------------------------------------end size-------------------------------------------*/

    @Override
    public Iterator<T> iterator() {
        return new ListCircularIterator<T>(this);
    }

}