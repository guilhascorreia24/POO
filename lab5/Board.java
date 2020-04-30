
public class Board implements iMatrix {
	private LinkedListCircular<Ponto> row = new LinkedListCircular<Ponto>(true);
	private LinkedListCircular<Ponto> col = new LinkedListCircular<Ponto>(false);

	public void child() {
		LinkedListCircular<Ponto> row1=new LinkedListCircular<Ponto>(true);
		LinkedListCircular<Ponto> col1 = new LinkedListCircular<Ponto>(false);
		createsentinels(row.size(),col.size(),row1,col1);
		for(int i=0;i<row.size();i++){
			Cell c1=(Cell)row.getfirstCellE(i),last;
			LinkedListCircular<Cell> linha=new LinkedListCircular<Cell>(true);
			LinkedListCircular<Cell> coluna=new LinkedListCircular<Cell>(false);
			createsentinels(2,col.size(), linha, coluna);
			while(c1.getState()!=0){
				Ponto pc1=c1.getPonto();
				c1.setNE(new Cell(0,new Ponto(pc1.getX()-1,pc1.getY()+1)));
				c1.getNE().setVizinhos(1);
				if(c1.getNE().isSurvive() || c1.getNE().isBorn()){
					row1.associateTo(c1.getNE().getPonto().getX(),c1.getNE().getPonto().getY(),col1,c1.getNE().getPonto());}
				else { 
					row1.removeAssociation(c1.getNE().getPonto(),c1.getNE().getPonto().getX());}
				c1.setN(new Cell(0,new Ponto(pc1.getX()-1,pc1.getY())));
				c1.getN().setVizinhos(1);
				if(c1.getN().isSurvive() || c1.getN().isBorn()){
					row1.associateTo(c1.getN().getPonto().getX(),c1.getN().getPonto().getY(),col1,c1.getN().getPonto());}
				else { 
					row1.removeAssociation(c1.getN().getPonto(),c1.getN().getPonto().getX());}
				c1.setNO(new Cell(0,new Ponto(pc1.getX()-1,pc1.getY()-1)));
				c1.getNO().setVizinhos(1);
				if(c1.getNO().isSurvive() || c1.getNO().isBorn()){
					row1.associateTo(c1.getNO().getPonto().getX(),c1.getNO().getPonto().getY(),col1,c1.getNO().getPonto());}
				else { 
					row1.removeAssociation(c1.getNO().getPonto(),c1.getNO().getPonto().getX());}
				c1.setE(new Cell(0,new Ponto(pc1.getX(),pc1.getY()+1)));
				c1.getE().setVizinhos(1);
				if(c1.getE().isSurvive() || c1.getE().isBorn()){
					row1.associateTo(c1.getE().getPonto().getX(),c1.getE().getPonto().getY(),col1,c1.getE().getPonto());}
				else { 
					row1.removeAssociation(c1.getE().getPonto(),c1.getE().getPonto().getX());}
				c1.setSO(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY()-1)));c1.getSO().setVizinhos(1);
				if(c1.getSO().isSurvive() || c1.getSO().isBorn()){
					row1.associateTo(c1.getSO().getPonto().getX(),c1.getSO().getPonto().getY(),col1,c1.getSO().getPonto());}
				else {
					row1.removeAssociation(c1.getSO().getPonto(),c1.getSO().getPonto().getX());}
				c1.setS(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY())));c1.getS().setVizinhos(1);
				if(c1.getS().isSurvive() || c1.getS().isBorn()){
					row1.associateTo(c1.getS().getPonto().getX(),c1.getS().getPonto().getY(),col1,c1.getS().getPonto());}
				else { 
					row1.removeAssociation(c1.getS().getPonto(),c1.getS().getPonto().getX());}
				c1.setSE(new Cell(0,new Ponto(pc1.getX()+1,pc1.getY()+1)));c1.getSE().setVizinhos(1);
				if(c1.getSE().isSurvive() || c1.getSE().isBorn()){
					row1.associateTo(c1.getSE().getPonto().getX(),c1.getSE().getPonto().getY(),col1,c1.getSE().getPonto());}
				else { 
					row1.removeAssociation(c1.getSE().getPonto(),c1.getSE().getPonto().getX());}
				c1.setO(new Cell(0,new Ponto(pc1.getX(),pc1.getY()-1)));c1.getO().setVizinhos(1);
				if(c1.getO().isSurvive() || c1.getO().isBorn()){
					row1.associateTo(c1.getO().getPonto().getX(),c1.getO().getPonto().getY(),col1,c1.getO().getPonto());}
				else { 
					row1.removeAssociation(c1.getO().getPonto(),c1.getO().getPonto().getX());}
				pc1= (Ponto) row.nextcellHorizon(pc1, pc1.getX());
				System.out.println(c1.getO());
				System.out.println("NO:"+c1.getNO().getVizinhos()+" N:"+c1.getN().getVizinhos()+" NE:"+c1.getNE().getVizinhos()+" O:"+c1.getO().getVizinhos()+" C"+c1.getVizinhos()+" E:"+c1.getE().getVizinhos()+" SO:"+c1.getSO().getVizinhos()+" S:"+c1.getS().getVizinhos()+" SE:"+c1.getSE().getVizinhos());
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

		}
		row=row1;
		col=col1;
		//row.printListrow();
		//col.printListcol();
	}




	private void createsentinels(int x,int y,LinkedListCircular<?> a,LinkedListCircular<?> b){
        int i=0;
        while(i<x){
			a.add();
            i++;
		}i=0;
		while(i<y){
			b.add();
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
					row.associateTo(i,j,col,c);
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
				Ponto p=new Ponto(i,j);
				//System.out.println(p+":"+col.contains(p,j));
				if(row.contains(p,i))
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
