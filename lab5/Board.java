
public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();

	public void child() {
		LinkedListCircular row1=new LinkedListCircular();
		LinkedListCircular col1 = new LinkedListCircular();
		createsentinels(row.size(),col.size(),row1,col1);
		for (int i = 0; i < row.size(); i++) {
			Cell c =row.getfirstCellE(i);
			//System.out.println(c);
			while(c.getState()!=0){
				newCells(row1,col1,c);
				Ponto pnext=row.nextcellHorizon(c.getPonto(), i);
				if(pnext==null){
					c=new Cell(0,new Ponto(-1,-1));
				}else{
					c.setPonto(pnext);
					c.setState(1);
				}
				//System.out.println(c.getState());
			}
		}
		row=row1;
		col=col1;
		//row.printListrow();
		//col.printListcol();
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
				Ponto p=new Ponto(i,j);
				//System.out.println(p+":"+col.contains(p,j));
				if(col.contains(p,j))
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

	private Cell check_cell_in_board(boolean a,Ponto p){
		if(a){
			return new Cell(1,p);
		}
		return new Cell(0,p);
	}

	private void newCells(LinkedListCircular row1,LinkedListCircular col1,Cell c){
		int x=c.getPonto().getX();
		int y=c.getPonto().getY();
		int i=0,j=0;
		Cell[] vizinhos=new Cell[8];
		Cell[] vizinhos_dos_vizinhos=new Cell[16];
		Ponto p=new Ponto(x,y+1); //E
		vizinhos[i++] = check_cell_in_board(col.contains(p, y+1),p);
		p.setX(x+1);p.setY(y+1);//SE
		vizinhos[i++] =check_cell_in_board(col.contains(p, y+1),p);
		p.setX(x+1);p.setY(y);//S
		vizinhos[i++]=check_cell_in_board(col.contains(p, y),p);
		p.setX(x+1);p.setY(y-1);//SO
		vizinhos[i++]=check_cell_in_board(col.contains(p, y-1),p);
		p.setX(x);p.setY(y-1);//O
		vizinhos[i++]=check_cell_in_board(col.contains(p,y-1),p);
		p.setX(x-1);p.setY(y-1);//NO
		vizinhos[i++]=check_cell_in_board(col.contains(p, y-1),p);
		p.setX(x-1);p.setY(y);//N
		vizinhos[i++] = check_cell_in_board(col.contains(p, y),p);
		p.setX(x-1);p.setY(y+1);//NE
		vizinhos[i++]= check_cell_in_board(col.contains(p, y+1),p);



		p.setX(x-2);p.setY(y+1);//NNE
		if(col.contains(p, y+1)){
			vizinhos_dos_vizinhos[j++]=new Cell(1, p);
		}
		p.setX(x-1);p.setY(y+2);//ENE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j++  ]=new Cell(1, p);
		}
		p.setX(x-2);p.setY(y+2);//NENE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x-2);p.setY(y+1);//NNE
		if(col.contains(p, y+1)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x-1);p.setY(y+2);//ENE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x-2);p.setY(y+2);//NENE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}

		p.setX(x-2);p.setY(y-1);//NNO
		if(col.contains(p, y-1)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x-1);p.setY(y-2);//ONO
		if(col.contains(p, y-2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x-2);p.setY(y-2);//NONO
		if(col.contains(p, y-2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}

		p.setX(x+2);p.setY(y+1);//SSE
		if(col.contains(p, y+1)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x+1);p.setY(y+2);//ESE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x+2);p.setY(y+2);//SESE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}

		p.setX(x+2);p.setY(y-1);//SSO
		if(col.contains(p, y-1)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x+1);p.setY(y-2);//OSO
		if(col.contains(p, y-2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}
		p.setX(x+2);p.setY(y-2);//SOSO
		if(col.contains(p, y-2)){
			vizinhos_dos_vizinhos[j]=new Cell(1, p);
		}

		p.setX(x);p.setY(y+2);//EE
		if(col.contains(p, y+2)){
			vizinhos_dos_vizinhos[i++]=new Cell(1,p);
		}
		p.setX(x);p.setY(y-2);//OO
		if(col.contains(p,y-2)){
			vizinhos_dos_vizinhos[i++]=new Cell(1,p);
		}
		p.setX(x-2);p.setY(y);//NN
		if(col.contains(p, y)){
			vizinhos_dos_vizinhos[i++]=new Cell(1,p);
		}
		p.setX(x+2);p.setY(y);//SS
		if(col.contains(p, y)){
			vizinhos_dos_vizinhos[i++]=new Cell(1, p);
		}



		//System.out.println("E:"+E+" O:"+O+" N:"+N+" S:"+S+" NE:"+NE+" NO:"+NO+" SO:"+SO+" SE:"+
		//SE+" NNE:"+NNE+" NENE:"+NENE+" ENE:"+ENE+" SSE:"+SSE+" SESE:"+SESE+" ESE:"+ESE+" NNO:"+NNO+" NONO:"+NONO+" ONO:"+ONO+" SSO:"+SSO
		//+" SOSO:"+SOSO+" OSO:"+OSO+" NN:"+NN+" SS:"+SS+"OO:"+OO+" EE:"+EE);
		//System.out.println(c.getPonto());
		p=new Ponto(x,y);
		//System.out.println(c.isSurvive(vizinhos));
		if(c.isSurvive(vizinhos)){
			row1.associateTo(p, col1);
		}


	}
}
