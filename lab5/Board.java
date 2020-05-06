/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class Board implements iMatrix {
	private LinkedListCircular<Ponto> row = new LinkedListCircular<Ponto>();
	private LinkedListCircular<Ponto> col = new LinkedListCircular<Ponto>();

	/**
	 * @inv this.row LinkedListCircular que representa as linhas da matriz esparsa
	 * @inv this.col LinkedListCircular que representa as colunas da matriz esparsa
	 *      Criar a nova board da iteracao adiciona mais 1 vizinhos a todas a
	 *      celulas que se encontram em volta de uma celula viva Deseguida verifica
	 *      a distancia da proxima celula viva que esta na mesma linha e
	 *      translaciona as celulas da Este para Oeste da proxima celula viva e no
	 *      caso de estar longo ao lado mete o Norte e Sul com celulas NE e SE
	 *      respectivamente enquanto ocorre isso e adcionado em 2 listas de Cells
	 *      que serviram para verificar a parte norte e Este e Oeste das celulas que
	 *      estao abaixo da linha. Por fim e enviado a matriz final para as
	 *      LinkedListCircular row e col
	 */
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
					NE = neighboors_cell(NE, lastline, new Ponto(pc1.getX() - 1, pc1.getY() + 1), row1);
					N = neighboors_cell(N, lastline, new Ponto(pc1.getX() - 1, pc1.getY()), row1);
					NO = neighboors_cell(NO, lastline, new Ponto(pc1.getX() - 1, pc1.getY() - 1), row1);
					E = neighboors_cell(E, myline, new Ponto(pc1.getX(), pc1.getY() + 1), row1);
					myline.add(E);
					SO = neighboors_cell(SO, nextline, new Ponto(pc1.getX() + 1, pc1.getY() - 1), row1);
					nextline.add(SO);
					S = neighboors_cell(S, nextline, new Ponto(pc1.getX() + 1, pc1.getY()), row1);
					nextline.add(S);
					SE = neighboors_cell(SE, nextline, new Ponto(pc1.getX() + 1, pc1.getY() + 1), row1);
					nextline.add(SE);
					O = neighboors_cell(O, myline, new Ponto(pc1.getX(), pc1.getY() - 1), row1);
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
							NO = N;
							N = new Cell(0, null);
							N = NE;
							NE = new Cell(0, null);
							O = last;
							SO = S;
							S = new Cell(0, null);
							S = SE;
							SE = new Cell(0, null);
							E = new Cell(0, null);
						} else if (pc1.dist(last.getPonto()) == 2) {
							NO = NE;
							NE = new Cell(0, null);
							O = E;
							E = new Cell(0, null);
							SO = SE;
							SE = new Cell(0, null);
							N = new Cell(0, null);
							S = new Cell(0, null);
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

	/**
	 * Atualiza ou adciona a celula vizinha
	 * 
	 * @param neighboor celula que queremos identificar
	 * @param lastline  lista a qual queremos adiconar a celula
	 * @param pc1       coordenadas da celula
	 * @param row1      matriz esparsa que queremos calcular
	 * @return devolve a celula
	 */
	public Cell neighboors_cell(Cell neighboor, List<Cell> lastline, Ponto pc1, LinkedListCircular<?> row1) {
		if (neighboor.getVizinhos() == 0)
			neighboor = CellAlreadyExisted(lastline, new Cell(0, pc1));
		neighboor.setVizinhos(neighboor.getVizinhos() + 1);
		newCells(neighboor, row1);
		return neighboor;
	}

	/**
	 * verifica a existencia da celula c
	 * 
	 * @param list lista onde vamos verificar a existencia da coordenadas da celula
	 *             c
	 * @param c    celula que queremos comparar
	 * @return devolve a celula fincal
	 */
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

	public LinkedListCircular<?> getrow(){
		return row;
	}
	public LinkedListCircular<?> getcol(){
		return col;
	}

	/**
	 * Cria a estrutura da matriz esparsa (linhas e colunas) sem dados
	 * 
	 * @param x numero de linha da matriz atual
	 * @param y numero de colunas da matriz atual
	 * @param a LinkedListCircular (linhas) da matriz esparsa
	 * @param b LinkedListCircular (colunas) da matriz esparsa
	 */
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
			i++;
		}
	}

	/**
	 * cria a matriz esparsa
	 * 
	 * @param m matriz que e recebida no inicio da iteracao
	 */
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

	/**
	 * transforma a matriz esparsa da iteracao em mariz normal esta funcao da o
	 * resultado da iteracao
	 */
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

	/**
	 * Verifica se a celula tem condiçoes para sobreviver morrer ou nascer e
	 * dependente duma das ocasioes adiciona/remove da matriz esparsa
	 * 
	 * @param c1   celula que queremos adicionar ou remover
	 * @param row1 lista das linhas da matriz esparsa
	 */
	public void newCells(Cell c1, LinkedListCircular<?> row1) {
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