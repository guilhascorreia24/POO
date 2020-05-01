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
				//System.out.println(c2);
				myline.remove(c2);
				//System.out.println(myline);
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
				//System.out.println(pc1);
				//System.out.println("NO:"+c1.getNO().getVizinhos()+" N:"+c1.getN().getVizinhos()+" NE:"+c1.getNE().getVizinhos()+" O:"+c1.getO().getVizinhos()+" C"+c1.getVizinhos()+" E:"+c1.getE().getVizinhos()+" SO:"+c1.getSO().getVizinhos()+" S:"+c1.getS().getVizinhos()+" SE:"+c1.getSE().getVizinhos());
				if(pc1!=null){
					last=c1;
					//linha.associateTo(1, last.getPonto().getY(),coluna, last);
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
			System.out.println("1:lastline:"+lastline+"\nmyline"+myline+"\nnextline"+nextline+"\n");
			lastline.clear();
			lastline=myline.clone();
			//System.out.println("2:lastline:"+lastline+"\nmyline"+myline+"\nnextline"+nextline+"\n");
			myline.clear();
			myline=nextline.clone();
			//System.out.println("3:lastline:"+lastline+"\nmyline"+myline+"\nnextline"+nextline+"\n");
			nextline.clear();
		}
		row=row1;
		col=col1;
		//row.printListrow();
		//col.printListcol();
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
		//int l=0;
		if(row.size()>0)row.clear();
		if(col.size()>0)col.clear();
		int cols = m[0].length, rows = m.length;
		createsentinels(rows,cols,row,col);
		//System.out.println("set:"+row.size()+":"+col.size());
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(m[i][j]==1){
					//System.out.println("sj");
					Ponto c=new Ponto(i,j);
					row.associateTo(i,j,(Object)c);
				}
			}
		}
		//row.printListrow();
	}

	@Override
	public int[][] get() {
		//row.removeAssociationOf((Object)new Ponto(0,0),0);
		//System.out.println(row.size()+" "+col.size()+" "+row.getfirstIndex());
		int [][] m=new int[row.size()][col.size()];
		int l=Math.abs(row.getfirstIndex());
		int k=Math.abs(col.getfirstIndex());
		//System.out.println("get:"+row.size()+":"+col.size());
		for(int i=row.getfirstIndex();i<row.size()-l;i++){
			for(int j=col.getfirstIndex();j<col.size()-k;j++){
				Ponto p=new Ponto(i,j);
				//System.out.println((i+l)+" "+(j+k));
				if(row.contains(p,i))
					m[i+l][j+k]=1;
				else{
					m[i+l][j+k]=0;
				}
			}
		}
		//System.out.println("get before:"+m.length+":"+m[0].length);
		//System.out.println(m.length);
		return m;
	}

	private void newCells(Cell c1,LinkedListCircular<?> row1){
		if(c1.isSurvive() || c1.isBorn()){
			if(c1.isBorn()){
				if(c1.getPonto().getX()<0){
					row1.addfirstLine();
				}
				if(c1.getPonto().getX()>=row.size()){
					row1.addLine();
				}
				if(c1.getPonto().getY()<0){
					row1.getColList().addfirstLine();
				}
				if(c1.getPonto().getY()>=col.size()){
					row1.getColList().addLine();
				} 
			}
			//row1.associateTo(c1.getPonto().getX(),c1.getPonto().getY(),c1.getPonto());
			//System.out.println(c1);
			if(!row1.contains(c1.getPonto(),c1.getPonto().getX()))
				row1.associateTo(c1.getPonto().getX(), c1.getPonto().getY(),(Object)c1.getPonto());
		}
		if(c1.getVizinhos()>3 || c1.getVizinhos()<2 && c1.isAlive()){
			//row1.printListrow();
			row1.removeAssociationOf((Object)c1.getPonto(),c1.getPonto().getX());
			//System.out.println(c1+" "+row1.contains(c1.getPonto(),c1.getPonto().getX()));
			//row1.printListrow();
			//System.out.println(c1);
		}
	}

}
