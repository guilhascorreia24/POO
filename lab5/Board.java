
public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();
	final double DISTANCE_CELLS = Math.sqrt(2);

	public void child() {
		Cell none=new Cell(0,new Ponto(-1,-1));
		LinkedListCircular row1=new LinkedListCircular();
		LinkedListCircular col1 = new LinkedListCircular();
		createsentinels(row.size(),col.size(),row1,col1);
		for (int i = 0; i < row.size(); i++) {
			Cell c =row.getfirstCellE(i);
			//System.out.println(c);
			while(c.getState()!=0){
				int x=c.getPonto().getX();
				int y=c.getPonto().getY();
				boolean E=col.contains(new Ponto(x,y+1), y+1);
				boolean O=col.contains(new Ponto(x,y-1),y-1);
				boolean N=col.contains(new Ponto(x-1,y),y);
				boolean S=col.contains(new Ponto(x-1,y),y);
				boolean SE=col.contains(new Ponto(x+1,y+1), y+1);
				boolean NE=col.contains(new Ponto(x-1,y+1), y+1);
				boolean NO=col.contains(new Ponto(x-1,y-1), y-1);
				boolean SO=col.contains(new Ponto(x+1,y-1), y-1);
				System.out.println("E:"+E+" O:"+O+" N:"+N+" S:"+S+" NE:"+NE+" NO:"+NO+" SO:"+SO+" SE:"+SE);
				System.out.println(c.getPonto());
				Ponto pnext=row.nextcellHorizon(c.getPonto(), i);
				if(pnext==null){
					c=new Cell(0,new Ponto(-1,-1));
				}else{
					c.setPonto(pnext);
				}
				System.out.println(c.getState());
			}
		}
		//row=row1;
		//col=col1;
		//row.printListrow();
		//col.printListcol();
		//System.out.println(col.getfirstNode().getS().getE()+" "+col.getfirstNode().getS().getS());
	}


	private void createsentinels(int x,int y,LinkedListCircular a,LinkedListCircular b){
        int i=0;
        while(i<x){
			a.add(true);
            i++;
		}i=0;
		while(i<y){
			b.add(false);
            i++;
		}
	}
	
	@Override
	public void set(int[][] m) {
		//int l=0;
		if(row.size()>0)row.clear();
		if(col.size()>0)col.clear();
		int cols = m[0].length, rows = m.length;
		createsentinels(rows,cols,row,col);
		//System.out.println("set:"+row.size()+":"+col.size());
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(m[i][j]==1){
					Ponto c=new Ponto(i,j);
					row.associateTo(c,col);
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
				if(row.contains(new Ponto(i,j),i))
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
