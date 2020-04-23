
public class Client{
    public static void main(String[] args){
        LinkedListCircular<LinkedListCircular.SentinelNode> lk=new LinkedListCircular<LinkedListCircular.SentinelNode>();
        LinkedListCircular.Node n=new LinkedListCircular.Node(null, null);
        LinkedListCircular.Node n1=new LinkedListCircular.Node(null,null);
        n.setE(n);n1.setE(n1);
        lk.add(n);
        lk.add(n1);
        LinkedListCircular.DataNode<Integer> g=new LinkedListCircular.DataNode<Integer>(n,null, 1);
        n.setE(g);

        for(LinkedListCircular.SentinelNode p:lk){
            System.out.println(lk.getindex(p)+" "+lk.size());
            if(lk.getindex(p)<lk.size()){
                System.out.println(lk.getindex(p));
            }
            else{
                break;
            }
        }
    }
}