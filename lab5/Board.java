

public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();

	public void child() {

	}

	private void createsentinels(int x,int y){
        int i=0;
        while(i<x){
			LinkedListCircular.SentinelNode sn=new LinkedListCircular.SentinelNode(null,null,null);
			sn.setE(sn);
			row.add(sn);
            i++;
		}i=0;
		while(i<y){
			LinkedListCircular.SentinelNode sn=new LinkedListCircular.SentinelNode(null,null,null);
			sn.setS(sn);
			col.add(sn);
            i++;
		}
	}
	

	@Override
	public void set(int[][] m) {
		int cols = m[0].length, rows = m.length, i = 0, j = 0;
		LinkedListCircular.Node sn,dn=null;
		createsentinels(rows,cols);
		while (i < rows || j < cols) {
			sn = row.get(i);
			while(i < cols) {
				dn.setE(new LinkedListCircular.DataNode<Ponto>(sn,null, new Ponto(i,j)));
				dn	
			}
		}
	}

	@Override
	public int[][] get() {
		return null;
	}
}
