
public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();
	final double DISTANCE_CELLS = Math.sqrt(2);

	public void child() {
		LinkedListCircular row1=new LinkedListCircular();
		LinkedListCircular col1 = new LinkedListCircular();
		createsentinels(row.size(),col.size(),row1,col1);
		for (int i = 0; i < row.size(); i++) {
			Cell c =row.getfirstCellE(i);
			while(c!=null){
				int neighboors=0;
				Cell E=c.E(row, i);
				int icol=c.getPonto().getY();
				Cell S=c.S(col, icol);
				Cell N=c.N(col, icol);
				Cell O=c.O(row, i);
				Cell NE=c.NE(E,N,row,col);
				Cell NO=c.NO(O, N, row, col);
				Cell SE=c.SE(E, S, row, col);
				Cell SO=c.SO(O, S, row, col);
				System.out.print(i+" @ E:"+E+" S:"+S+" O:"+O+" N:"+N+" NE:"+NE+" NO:"+NO+" SE:"+SE+" SO:"+SO+" ");
				if(E!=null && c.getPonto().dist(E.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("E ");
				}
				if(S!=null && c.getPonto().dist(S.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("S ");
				}
				if(N!=null && c.getPonto().dist(N.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("N ");
				}
				if(O!=null && c.getPonto().dist(O.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("O ");
				}
				if(SE!=null && c.getPonto().dist(SE.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("SE ");
				}
				if(SO!=null && c.getPonto().dist(SO.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("SO ");
				}
				if(NE!=null && c.getPonto().dist(NE.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("NE ");
				}
				if(NO!=null && c.getPonto().dist(NO.getPonto())<DISTANCE_CELLS){
					neighboors++;
					System.out.print("NO ");
				}
				System.out.println("vizi:"+neighboors);
				if(neighboors>1 && neighboors<4){
					row1.associateTo(i, c.getPonto(), true);
					col1.associateTo(c.getPonto().getY(), c.getPonto(), false);
				}
				c=E;
			}
		}
		row=row1;
		col=col1;
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
