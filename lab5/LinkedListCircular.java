public class LinkedListCircular{
    private SentinelNode head;
    public class Node implements Comparable<Node>{
        private Node E,S;
        public Node(Node E,Node S){
            this.E=E;
            this.S=S;
        } 

        @Override
        public int compareTo(Node o) {
            if(this.E.equals(o.E) && this.S.equals(o.S)){
                return 0;
            }
            else{
                return 1;
            }
        }

        public Node E(){
            return this.E;
        }

        public Node S(){
            return this.S;
        }

    }
    public class SentinelNode extends Node{
        private SentinelNode next;
        public SentinelNode(Node E, Node S,SentinelNode next){
            super(E,S);
            this.next=next;
        }

        public String toString(){
            return E()+":"+S()+":"+next;
        }

        public SentinelNode getnext(){
            return this.next;
        }
    }


    public class DataNode<T> extends Node{
        private T value;
        public DataNode(Node E, Node S,T value) {
            super(E, S);
            this.value=value;
        }

        public String toString(){
            return E()+":"+S()+":"+value;
        }

        public T getvalue(){
            return this.value;
        }

    }   
    public void push(Node SN){
        SentinelNode new_node=new SentinelNode(SN.E,SN.S,null);
        if(head==null){
            head=new_node;
        }
        SentinelNode last=head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=new_node;
        new_node.next=head;
        return ;
    }

    public int getIndex(SentinelNode n){
        SentinelNode last=head;
        int index=0;
        while(!last.equals(n)){
            index++;
        }
        return index;
    }

    public SentinelNode getlastNode(){
        SentinelNode last=head;
        while(last.next!=head){
            last=last.next;
        }
        return last;
    }

    public SentinelNode getfirstNode(){
        return head;
    }

    public void addfirst(SentinelNode n){
        SentinelNode last=getlastNode();
        last.next=n;
        n.next=head;
        head=n;
    }
}
