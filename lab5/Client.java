public class Client {
    public static void main(String[] args){
        LinkedListCircular lk=new LinkedListCircular();
        LinkedListCircular.SentinelNode n=new LinkedListCircular.SentinelNode(null, null,null);
        LinkedListCircular.SentinelNode n1=new LinkedListCircular.SentinelNode(null,null,null);
       // n.setE(n);n1.setE(n1);
        lk.add(n);
        lk.add(n1);
        LinkedListCircular.DataNode<Integer> g=new LinkedListCircular.DataNode<Integer>(n,null,1);
        n1.setE(g);
        lk.printList();
    }
}