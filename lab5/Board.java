public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();

	public void child() {
		for (int i = 0; i < row.size(); i++) {
			Cell c =row.getfirstCellE(i);
			/*while(c!=null){
				Cell nextE=row.nextCellE(c, i);
				int icol=c.getPonto().getY();
				Cell nextS=col.nextCellS(c, icol);
				Cell beforeE=row.beforeCellE(c, i);
				Cell beforeS=col.nextCellS(c, icol);
				System.out.println(i+":"+nextE+" "+nextS+" "+beforeE+" "+beforeS);
				c=nextE;
			}*/
		}
		col.printList();
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
					Cell c=new Cell(1,new Ponto(i,j));
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
