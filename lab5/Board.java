public class Board implements iMatrix {
	private LinkedListCircular<Ponto> row = new LinkedListCircular<Ponto>();
	private LinkedListCircular<Ponto> col = new LinkedListCircular<Ponto>();

	public void child() {
		LinkedListCircular<Ponto> row1 = new LinkedListCircular<Ponto>();
		LinkedListCircular<Ponto> col1 = new LinkedListCircular<Ponto>();
		List<Cell> myline = new List<Cell>(), nextline = new List<Cell>(), lastline = new List<Cell>();
		Cell c1 = new Cell(0, null), last;
		createsentinels(row.size(), col.size(), row1, col1);
		for (int i = 0; i < row.size(); i++) {
			Object c = row.getfirstElementOf(i);
			Cell NE = new Cell(0, null), E = new Cell(0, null), O = new Cell(0, null), N = new Cell(0, null),
					S = new Cell(0, null), NO = new Cell(0, null), SO = new Cell(0, null), SE = new Cell(0, null);
			if (c instanceof Ponto) {
				Ponto pc1 = (Ponto) c;
				c1 = new Cell(1, pc1);
				while (c instanceof Ponto) {
					Cell c2 = CellAlreadyExisted(myline, c1);
					myline.remove(c2);
					c1.setVizinhos(c2.getVizinhos());
					if (NE.getVizinhos() == 0)
						NE = CellAlreadyExisted(lastline, new Cell(0, new Ponto(pc1.getX() - 1, pc1.getY() + 1)));
					// c1.setNE(NE);// NE
					NE.setVizinhos(NE.getVizinhos() + 1);
					newCells(NE, row1);

					//neighboors_cell(NE, lastline,new Ponto(pc1.getX() - 1, pc1.getY() + 1), row1);

					if (N.getVizinhos() == 0)
						N = CellAlreadyExisted(lastline, new Cell(0, new Ponto(pc1.getX() - 1, pc1.getY())));
					// c1.setN(N);// N
					N.setVizinhos(N.getVizinhos() + 1);
					newCells(N, row1);

					if (NO.getVizinhos() == 0)
						NO = CellAlreadyExisted(lastline, new Cell(0, new Ponto(pc1.getX() - 1, pc1.getY() - 1)));
					// c1.setNO(NO);// NO
					NO.setVizinhos(NO.getVizinhos() + 1);
					newCells(NO, row1);

					if (E.getVizinhos() == 0)
						E = CellAlreadyExisted(myline, new Cell(0, new Ponto(pc1.getX(), pc1.getY() + 1)));
					// c1.setE(E);// E
					E.setVizinhos(E.getVizinhos() + 1);
					newCells(E, row1);
					myline.add(E);

					if (SO.getVizinhos() == 0)
						SO = new Cell(0, new Ponto(pc1.getX() + 1, pc1.getY() - 1));
					// c1.setSO(SO);// SO
					SO.setVizinhos(SO.getVizinhos() + 1);
					newCells(SO, row1);
					nextline.add(SO);

					if (S.getVizinhos() == 0)
						S = new Cell(0, new Ponto(pc1.getX() + 1, pc1.getY()));
					// c1.setS(S);// S
					S.setVizinhos(S.getVizinhos() + 1);
					newCells(S, row1);
					nextline.add(S);

					if (SE.getVizinhos() == 0)
						SE = new Cell(0, new Ponto(pc1.getX() + 1, pc1.getY() + 1));
					// c1.setSE(SE);// SE
					SE.setVizinhos(SE.getVizinhos() + 1);
					newCells(SE, row1);
					nextline.add(SE);

					if (O.getVizinhos() == 0)
						O = CellAlreadyExisted(myline, new Cell(0, new Ponto(pc1.getX(), pc1.getY() - 1)));
					// c1.setO(O);// O
					O.setVizinhos(O.getVizinhos() + 1);
					newCells(O, row1);
					myline.add(O);
					myline.add(c1);
					newCells(c1, row1);

					c = row.nextcellHorizon(pc1, pc1.getX());
					if (c instanceof Ponto) {
						pc1 = (Ponto) c;
						last = c1;
						c1 = new Cell(1, pc1);
						if (pc1.dist(last.getPonto()) == 1) {
							c1.setVizinhos(E.getVizinhos());
							NO = N;N=new Cell(0,null);
							N = NE;NE= new Cell(0,null);
							O = last;
							SO = S;S=new Cell(0,null);
							S = SE;SE=new Cell(0,null);
							E=new Cell(0,null);
							/*
							 * c1.setN(last.getNE());//N=NE c1.setNO(last.getN());//NO=N
							 * c1.setO(last);//O=last c1.setSO(last.getS()); c1.setS(last.getSE());
							 */
						} else if (pc1.dist(last.getPonto()) == 2) {
							NO = NE;NE=new Cell(0,null);
							O = E;E=new Cell(0,null);
							SO = SE;SE=new Cell(0,null);
							N=new Cell(0,null);S=new Cell(0,null);
							/*
							 * c1.setNO(last.getNE()); c1.setO(last.getE()); c1.setSO(last.getSE());
							 */
						} else {
							NE = new Cell(0, null);
							E = new Cell(0, null);
							O = new Cell(0, null);
							N = new Cell(0, null);
							S = new Cell(0, null);
							NO = new Cell(0, null);
							SO = new Cell(0, null);
							SE = new Cell(0, null);
						}
						//System.out.println(NO.getVizinhos()+" "+O.getVizinhos()+" "+SO.getVizinhos()+" "+N.getVizinhos()+" "+c1.getVizinhos()+" "+S.getVizinhos()+" "+NE.getVizinhos()+" "+E.getVizinhos()+" "+SE.getVizinhos());
					}
				}
			}
			lastline.clear();
			lastline = myline.clone();
			myline.clear();
			myline = nextline.clone();
			nextline.clear();
		}
		row.clear();
		col.clear();
		row = row1;
		col = col1;
	}

	public void neighboors_cell(Cell neighboor, List<Cell> lastline, Ponto pc1, LinkedListCircular<?> row1) {
	if (neighboor.getVizinhos() == 0)
		neighboor = CellAlreadyExisted(lastline, new Cell(0, pc1));
	// c1.setNE(NE);// NE
	neighboor.setVizinhos(neighboor.getVizinhos() + 1);
	newCells(neighboor, row1);
	}

	public Cell CellAlreadyExisted(List<Cell> list, Cell c) {
		Cell f = c;
		for (int i = 0; i < list.size(); i++) {
			Cell x = (Cell) list.getfirstElementOf(i);
			if (x.getPonto().equals(c.getPonto())) {
				f = x;
			}
		}
		return f;
	}

	public void createsentinels(int x, int y, LinkedListCircular<?> a, LinkedListCircular<?> b) {
		a.Col(b);
		int i = 0;
		while (i < x) {
			a.addLine();
			i++;
		}
		i = 0;
		while (i < y) {
			a.getColList().addLine();
			;
			i++;
		}
	}

	@Override
	public void set(int[][] m) {
		if (row.size() > 0)
			row.clear();
		if (col.size() > 0)
			col.clear();
		int cols = m[0].length, rows = m.length;
		createsentinels(rows, cols, row, col);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (m[i][j] == 1) {
					Ponto c = new Ponto(i, j);
					row.associateTo(i, j, (Object) c);
				}
			}
		}
	}

	@Override
	public int[][] get() {
		int[][] m = new int[row.size()][col.size()];
		int l = Math.abs(row.getfirstIndex());
		int k = Math.abs(col.getfirstIndex());
		for (int i = row.getfirstIndex(); i < row.size() - l; i++) {
			for (int j = col.getfirstIndex(); j < col.size() - k; j++) {
				Ponto p = new Ponto(i, j);
				if (row.contains(p, i))
					m[i + l][j + k] = 1;
				else {
					m[i + l][j + k] = 0;
				}
			}
		}
		return m;
	}

	public void newCells(Cell c1, LinkedListCircular<?> row1) {
	//System.out.println(c1);
		if (c1.isSurvive() || c1.isBorn()) {
			if (c1.isBorn()) {
				if (c1.getPonto().getX() < row1.getfirstIndex()) {
					row1.addfirstLine();
				}
				if (c1.getPonto().getX() >= row1.size() - Math.abs(row1.getfirstIndex())) {
					row1.addLine();
				}
				if (c1.getPonto().getY() < row1.getColList().getfirstIndex()) {
					row1.getColList().addfirstLine();
				}
				if (c1.getPonto().getY() >= row1.getColList().size() - Math.abs(row1.getColList().getfirstIndex())) {
					row1.getColList().addLine();
				}
			}
			if (!row1.contains(c1.getPonto(), c1.getPonto().getX()))
				row1.associateTo(c1.getPonto().getX(), c1.getPonto().getY(), (Object) c1.getPonto());
		} else {
			row1.removeAssociationOf((Object) c1.getPonto(), c1.getPonto().getX());
		}
	}
}
