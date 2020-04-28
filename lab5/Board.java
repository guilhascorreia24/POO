
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
			while(!c.equals(new Cell(-1,new Ponto(-1,-1)))){
				int neighboors=0;
				Cell E=c.E(row, i);
				int icol=c.getPonto().getY();
				Cell S=c.S(col, icol);
				Cell N=c.N(col, icol);
				Cell O=c.O(row, i);
				Cell NE=c.diagonalE(row,col,i-1);
				Cell NO=c.diagonalO(row,col,i-1);
				Cell SE=c.diagonalE(row,col,i+1);
				Cell SO=c.diagonalO(row,col,i+1);
				//System.out.println(i+" @ E:"+E+" S:"+S+" O:"+O+" N:"+N+" NE:"+NE+" NO:"+NO+" SE:"+SE+" SO:"+SO+" ");
				//System.out.print(i+" @ E:"+E.getPonto()+" S:"+S.getPonto()+" O:"+O.getPonto()+" N:"+N.getPonto()+" NE:"+NE.getPonto()+" NO:"+NO.getPonto()+" SE:"+SE.getPonto()+" SO:"+SO.getPonto()+" ");
				if(E!=new Cell(-1,new Ponto(-1,-1)) && c.getPonto().dist(E.getPonto())<DISTANCE_CELLS){
					neighboors++;
					//System.out.print("E ");
				}
				if(S!=new Cell(-1,new Ponto(-1,-1)) && c.getPonto().dist(S.getPonto())<DISTANCE_CELLS){
					neighboors++;
					//System.out.print("S ");
				}
				if(N!=new Cell(-1,new Ponto(-1,-1)) && c.getPonto().dist(N.getPonto())<DISTANCE_CELLS){
					neighboors++;
					//System.out.print("N ");
				}
				if(O!=new Cell(-1,new Ponto(-1,-1)) && c.getPonto().dist(O.getPonto())<DISTANCE_CELLS){
					neighboors++;
					//System.out.print("O ");
				}
				if(!SE.equals(new Cell(-1,new Ponto(-1,-1)))){
					neighboors++;
					//System.out.print("SE ");
				}
				if(!SO.equals(new Cell(-1,new Ponto(-1,-1)))){
					neighboors++;
					//System.out.print("SO ");
				}
				if(!NE.equals(new Cell(-1,new Ponto(-1,-1)) )){
					neighboors++;
					//System.out.print("NE ");
				}
				if(!NO.equals(new Cell(-1,new Ponto(-1,-1)))){
					neighboors++;
					//System.out.print("NO ");
				}
				//System.out.println("vizi:"+neighboors);
				//System.out.println(i+" @ E:"+E.isAlive()+" S:"+S.isAlive()+" O:"+O.isAlive()+" N:"+N.isAlive()+" NE:"+NE.isAlive()+" NO:"+NO.isAlive()+" SE:"+SE.isAlive()+" SO:"+SO.isAlive()+" ");
				if(neighboors>1 && neighboors<4){
					row1.associateTo(c.getPonto(),col1);
				}
				if(N.isAlive() && E.isAlive()){
					System.out.println("NE alive");
					row1.associateTo(new Ponto(E.getPonto().getX(),N.getPonto().getY()), col1);
				}
				if(N.isAlive() && O.isAlive()){
					System.out.println("NO alive");
					row1.associateTo(new Ponto(O.getPonto().getX(),N.getPonto().getY()), col1);
				}
				if(S.isAlive() && E.isAlive()){
					System.out.println("SE alive");
					row1.associateTo(new Ponto(E.getPonto().getX(),S.getPonto().getY()), col1);
				}
				if(S.isAlive() && O.isAlive()){
					System.out.println("SO alive");
					row1.associateTo(new Ponto(O.getPonto().getX(),S.getPonto().getY()), col1);
				}
				/*if(NE.isAlive() && SE.isAlive()){
					row1.associateTo(new Ponto(E.getPonto().getX(),c.getPonto().getY()), col1);
				}
				if(NE.isAlive() && NO.isAlive()){
					row1.associateTo(new Ponto(c.getPonto().getX(),N.getPonto().getY()),col1);
				}
				if(NO.isAlive() && SO.isAlive()){
					row1.associateTo(new Ponto(O.getPonto().getY(),c.getPonto().getY()), col1);
				}
				if(SO.isAlive() && SE.isAlive()){
					row1.associateTo(new Ponto(S.getPonto().getX(),c.getPonto().getY()), col1);
				}
				if(N.isAlive() && S.isAlive()){
					row1.associateTo(new Ponto(c.getPonto().getX(),c.getPonto().getY()+1),col1);
					row1.associateTo(new Ponto(c.getPonto().getX(),c.getPonto().getY()-1), col1);
				}
				if(E.isAlive() && O.isAlive()){
					row1.associateTo(new Ponto(c.getPonto().getX()-1,c.getPonto().getY()), col1);
					row1.associateTo(new Ponto(c.getPonto().getX()+1,c.getPonto().getY()),col1);
				}*/
				c=E;
			}
		}
		row=row1;
		col=col1;
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
