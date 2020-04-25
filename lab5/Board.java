public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();

	public void child() {
		Cell O=null,N=null,E=null,S=null,NE=null,NO=null,SE=null,SO=null,NE1=null,NO1=null;
		for (int i = 0; i < row.size(); i++) {
			Cell c =row.getfirstCellE(i);
			//System.out.println(c);
			while(c!=null){
				E=row.nextCellE(c, i);
				int icol=c.getPonto().getY();
				S=col.nextCellS(c, icol);
				N=col.northCell(c, icol);
				O=row.Ocell(c, i);
				System.out.println("N: "+(N!=null)+" E:"+(E!=null));
				if(N!=null && E!=null && col.northCell(E,E.getPonto().getY()).equals(row.nextCellE(N,N.getPonto().getX()))){
					NE=row.nextCellE(N,N.getPonto().getX());
				}
				//System.out.println(i+" @ "+E+" "+S+" "+O+" "+N+" "+NE);
				c=E;
			}
		}
	}

	private void createsentinels(int x,int y){
        int i=0;
        while(i<x){
			row.add(true);
            i++;
		}i=0;
		while(i<y){
			col.add(false);
            i++;
		}
	}
	
	@Override
	public void set(int[][] m) {
		//int l=0;
		if(row.size()>0)row.clear();
		if(col.size()>0)col.clear();
		int cols = m[0].length, rows = m.length;
		createsentinels(rows,cols);
		//System.out.println("set:"+row.size()+":"+col.size());
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(m[i][j]==1){
					Ponto c=new Ponto(i,j);
					row.associateTo(i,c,true);
					col.associateTo(j,c, false);
				}
			}
		}
		//row.printList();
	}

	@Override
	public int[][] get() {
		int [][] m=new int[row.size()][col.size()];
		//System.out.println("get:"+row.size()+":"+col.size());
		for(int i=0;i<row.size();i++){
			for(int j=0;j<col.size();j++){
				if(row.contains(new Cell(m[i][j],new Ponto(i,j)),i))
					m[i][j]=1;
				else{
					m[i][j]=0;
				}
			}
		}
		//System.out.println("get before:"+m.length+":"+m[0].length);
		//System.out.println(m.length);
		return m;
	}
}
