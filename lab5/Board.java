//falta exeptions

public class Board implements iMatrix {
	private LinkedListCircular<Ponto> row = new LinkedListCircular<Ponto>();
	private LinkedListCircular<Ponto> col=new LinkedListCircular<Ponto>();

	public void child() {
		LinkedListCircular<Ponto> row1=new LinkedListCircular<Ponto>();
		LinkedListCircular<Ponto> col1 =new LinkedListCircular<Ponto>();
		List<Cell> myline=new List<Cell>(),nextline=new List<Cell>(),lastline=new List<Cell>();
		createsentinels(row.size(), col.size(), row1,col1);
		for(int i=0;i<row.size();i++){
			Cell c1=(Cell)row.getfirstElementOf(i),last;
			while(c1.getState()!=0){
				Ponto pc1=c1.getPonto();
				Cell c2=CellAlreadyExisted(myline, c1);
				myline.remove(c2);
				c1.setVizinhos(c2.getVizinhos());
				c1.setNE(CellAlreadyExisted(lastline,new Cell(0,new Ponto(pc1.getX()-1,pc1.getY()+1))));//NE
				c1.getNE().setVizinhos(c1.getNE().getVizinhos()+1);
				newCells(c1.getNE(), row1);

				c1.setN(CellAlreadyExisted(lastline,new Cell(0,new Ponto(pc1.getX()-1,pc1.getY()))));//N
				c1.getN().setVizinhos(c1.getN().getVizinhos()+1);
				newCells(c1.getN(), row1);

				c1.setNO(CellAlreadyExisted(lastline,new Cell(0,new Ponto(pc1.getX()-1,pc1.getY()-1))));//NO
				c1.getNO().setVizinhos(c1.getNO().getVizinhos()+1);
				newCells(c1.getNO(), row1);

				c1.setE(CellAlreadyExisted(myline,new Cell(0,new Ponto(pc1.getX(),pc1.getY()+1))));//E
				c1.getE().setVizinhos(c1.getE().getVizinhos()+1);
				newCells(c1.getE(), row1);
				myline.add(c1.getE());
				
				c1.setSO(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY()-1)));//SO
				c1.getSO().setVizinhos(c1.getSO().getVizinhos()+1);
				newCells(c1.getSO(), row1);
				nextline.add(c1.getSO());
				
				c1.setS(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY())));//S
				c1.getS().setVizinhos(c1.getS().getVizinhos()+1);
				newCells(c1.getS(), row1);
				nextline.add(c1.getS());
				
				c1.setSE(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY()+1)));//SE
				c1.getSE().setVizinhos(c1.getSE().getVizinhos()+1);
				newCells(c1.getSE(), row1);
				nextline.add(c1.getSE());
				
				c1.setO(CellAlreadyExisted(myline,new Cell(0,new Ponto(pc1.getX(),pc1.getY()-1))));//O
				c1.getO().setVizinhos(c1.getO().getVizinhos()+1);
				newCells(c1.getO(), row1);
				myline.add(c1.getO());
				myline.add(c1);
				newCells(c1, row1);
				
				pc1= (Ponto) row.nextcellHorizon(pc1, pc1.getX());
				if(pc1!=null){
					last=c1;
					c1=new Cell(1,pc1);
					if(pc1.dist(last.getPonto())==1){
						c1.setVizinhos(last.getE().getVizinhos());
						c1.setN(last.getNE());c1.setNO(last.getN());c1.setO(last);c1.setSO(last.getS());c1.setS(last.getSE());
					}else if(pc1.dist(last.getPonto())==2){
						c1.setNO(last.getNE());c1.setO(last.getE());c1.setSO(last.getSE());
					}
				}else{
					c1=new Cell(0,pc1);
				}
			}
			lastline.clear();
			lastline=myline.clone();
			myline.clear();
			myline=nextline.clone();
			nextline.clear();
		}
		row.clear();col.clear();
		row=row1;
		col=col1;
	}

	private Cell CellAlreadyExisted(List<Cell> list,Cell c){
		Cell f=c;
		for(int i=0;i<list.size();i++){
			Cell x= (Cell) list.getfirstElementOf(i);
			if(x.getPonto().equals(c.getPonto())){
				f=x;
			}
		}
		return f;
	}


	private void createsentinels(int x,int y,LinkedListCircular<?> a,LinkedListCircular<?> b){
		a.Col(b);
        int i=0;
        while(i<x){
			a.addLine();
            i++;
		}i=0;
		while(i<y){
			a.getColList().addLine();;
            i++;
		}
	}
	
	@Override
	public void set(int[][] m) {
		if(row.size()>0)row.clear();
		if(col.size()>0)col.clear();
		int cols = m[0].length, rows = m.length;
		createsentinels(rows,cols,row,col);
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(m[i][j]==1){
					Ponto c=new Ponto(i,j);
					row.associateTo(i,j,(Object)c);
				}
			}
		}
	}

	@Override
	public int[][] get() {
		int [][] m=new int[row.size()][col.size()];
		int l=Math.abs(row.getfirstIndex());
		int k=Math.abs(col.getfirstIndex());
		for(int i=row.getfirstIndex();i<row.size()-l;i++){
			for(int j=col.getfirstIndex();j<col.size()-k;j++){
				Ponto p=new Ponto(i,j);
				if(row.contains(p,i))
					m[i+l][j+k]=1;
				else{
					m[i+l][j+k]=0;
				}
			}
		}
		return m;
	}

	private void newCells(Cell c1,LinkedListCircular<?> row1){
		if(c1.isSurvive() || c1.isBorn()){
			if(c1.isBorn()){
				if(c1.getPonto().getX()<row1.getfirstIndex()){
					row1.addfirstLine();
				}
				if(c1.getPonto().getX()>=row1.size()-Math.abs(row1.getfirstIndex())){
					row1.addLine();
				}
				if(c1.getPonto().getY()<row1.getColList().getfirstIndex()){
					row1.getColList().addfirstLine();
				}
				if(c1.getPonto().getY()>=row1.getColList().size()-Math.abs(row1.getColList().getfirstIndex())){
					row1.getColList().addLine();
				} 
			}
			if(!row1.contains(c1.getPonto(),c1.getPonto().getX()))
				row1.associateTo(c1.getPonto().getX(), c1.getPonto().getY(),(Object)c1.getPonto());
		}
		if(c1.getVizinhos()>3 || c1.getVizinhos()<2 && c1.isAlive()){
			row1.removeAssociationOf((Object)c1.getPonto(),c1.getPonto().getX());		}
	}
}
