import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class Tests {
    	//-----------------------Teste construtor Ponto------------------------------
	@Test 
	public void testPonto(){
		new Ponto(0,1);
	}
	
	@Test
	public void testPonto1(){
		new Ponto(1,11);
	}

	@Test
	public void TestPonto2(){
		new Ponto(0,0);
    }
    //---------------------------------Teste contrutor GOL-------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testGOL1() throws Exception {
        List<String> s=new List<String>();
        s.add("01010");s.add("01010");
        new GOL(s,-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGOL2() throws Exception {
        List<String> s=new List<String>();
        s.add("1 ");s.add("1");
        new GOL(s,5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGOL3() throws Exception {
        List<String> s=new List<String>();
        new GOL(s,5);
    }

    //------------------------------------------------test contrutor Cell-------------------------

    @Test
    public void testCell(){
        Ponto p=new Ponto(1,1);
        new Cell(0,p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCell1(){
        Ponto p=new Ponto(-1,-1);
        new Cell(-1,p);
    }

    @Test
    public void testCell2(){
        Ponto p=new Ponto(0,0);
        new Cell(1,p);
    }

    //----------------------------------------------test contrustor LinkedListCircular-------------------------

    @Test
    public void testLinkedListCircular(){
        new LinkedListCircular<Cell>();
    }

    @Test
    public void testLinkedListCircular2(){
        new LinkedListCircular<Ponto>();
    }

    @Test
    public void testLinkedListCircular3(){
        new LinkedListCircular<Integer>();
    }

    //-------------------------------------------test List-----------------------------------------------
    @Test
    public void List(){
        new List<Cell>();
    }

    @Test
    public void List2(){
        new List<Ponto>();
    }

    @Test
    public void List3(){
        new List<Integer>();
    }

    //------------------------------------------teste contrutor Node--------------------------------
    @Test
    public void Node1(){
        LinkedListCircular.Node E=new LinkedListCircular.Node(null,null);
        E.setE(E);
    }

    @Test
    public void Node2(){
        LinkedListCircular.Node S=new LinkedListCircular.Node(null,null);
        S.setS(S);
    }

    @Test
    public void Node3(){
        new LinkedListCircular.Node(null,null);
    }
    //------------------------------------------teste contrutor SentinelNode--------------------------------
    @Test
    public void TestSentinelNode(){
        LinkedListCircular.SentinelNode E=new LinkedListCircular.SentinelNode(null,null,null);
        E.setE(E);
        E.setnext(E);
    }
    
    @Test
    public void TestSentinelNode1(){
        LinkedListCircular.SentinelNode S=new LinkedListCircular.SentinelNode(null,null,null);
        S.setS(S);
        S.setnext(S);
    }
    
   @Test
    public void TestSentinelNode2(){
       new LinkedListCircular.SentinelNode(null,null,null);
    }
    //------------------------------------------teste contrutor SentinelNode--------------------------------
    @Test
    public void testDataNode(){
        LinkedListCircular.DataNode<Integer> E=new LinkedListCircular.DataNode<Integer>(null,null,null);
        E.setE(E);
        E.setValue(1);
    }
    
    @Test
    public void testDataNode2(){
        LinkedListCircular.DataNode<Ponto> E=new LinkedListCircular.DataNode<Ponto>(null,null,null);
        E.setE(E);
        E.setValue(new Ponto(1,1));
    }
    
   @Test
    public void testDataNod3e(){
        new LinkedListCircular.DataNode<Cell>(null,null,null);
    }
    //------------------------------------------teste distancia entre 2 pontos---------------------------
	@Test
	public void testDistanceBetweenTwoPontos() {

		Ponto a = new Ponto(4, 3);
		Ponto b = new Ponto(3, -2);
		assertEquals(5.0990195135927845, a.dist(b), 0);


		 a = new Ponto(5,2);
		 b = new Ponto(5,2);
        assertEquals(0, a.dist(b), 0);
        
        
		 a = new Ponto(0,0);
		 b = new Ponto(1,0);
        assertEquals(1, a.dist(b), 0);
    }
    
    //------------------------------------------teste equals ponto-----------------------------------------
    @Test
    public void testEquals2Points(){
        Ponto a = new Ponto(4, 3);
		Ponto b = new Ponto(3, -2);
		assertEquals(false, a.equals(b));


		 a = new Ponto(5,2);
		 b = new Ponto(5,2);
        assertEquals(true, a.equals(b));
        
        
		 a = new Ponto(0,0);
		 b = new Ponto(1,0);
        assertEquals(false, a.equals(b));
    }
    //------------------------------------------Test isAlive------------------------------------

    @Test
    public void TestisAlive(){
        Ponto p=new Ponto(1,1);
        Cell c=new Cell(1,p);
        assertEquals(true, c.isAlive());

         p=new Ponto(1,1);
         c=new Cell(0,p);
        assertEquals(false, c.isAlive());

         p=new Ponto(0,1);
         c=new Cell(1,p);
        assertEquals(true, c.isAlive());
    }

    //----------------------------------------Test isBorn-------------------------------------

    @Test
    public void testisBorn(){
        Ponto p=new Ponto(1,1);
        Cell c=new Cell(1,p);
        c.setVizinhos(3);
        assertEquals(true, c.isBorn());

         p=new Ponto(1,1);
         c=new Cell(0,p);
         c.setVizinhos(0);
        assertEquals(false, c.isBorn());

         p=new Ponto(0,1);
         c=new Cell(1,p);
         c.setVizinhos(2);
        assertEquals(false, c.isBorn());
    }

    //-----------------------------------------test equals Cell------------------------------
    @Test(expected=NullPointerException.class)
    public void testequals(){
        Ponto p=new Ponto(1,1);
        Cell c=new Cell(1,p);
        c.setVizinhos(3);
        assertEquals(false, c.equals(null));

        Ponto p1=new Ponto(1,1);
        Cell c1=new Cell(0,p1);
         c1.setVizinhos(0);
        assertEquals(false, c.equals(c));

        Ponto p3=new Ponto(1,1);
        Cell c3=new Cell(1,p3);
         c3.setVizinhos(3);
        assertEquals(true, c.equals(c3));
    }

    //----------------------------------------test isSurvive --------------------------------------
    
    @Test
    public void testisSurvive(){
        Ponto p=new Ponto(1,1);
        Cell c=new Cell(1,p);
        c.setVizinhos(3);
        assertEquals(true, c.isSurvive());

         p=new Ponto(1,1);
         c=new Cell(0,p);
         c.setVizinhos(0);
        assertEquals(false, c.isSurvive());

         p=new Ponto(0,1);
         c=new Cell(1,p);
         c.setVizinhos(2);
        assertEquals(true, c.isSurvive());
    }
    //------------------------------------------test neighboor_cell------------------------
    @Test
    public void testneighboor_cell(){
        Board b=new Board();
        Cell c = new Cell(0, new Ponto(1,1));
        List<Cell> myline = new List<Cell>();
        Ponto p=new Ponto(1,2);
        LinkedListCircular<Ponto> llc = new LinkedListCircular<Ponto>();
        Cell r=new Cell(0, new Ponto(1,2));r.setVizinhos(1);
        Cell t=(Cell)b.neighboors_cell(c, myline, p, llc);
       // System.out.println(r.equals(t));
        assertEquals(true,r.equals(t));

        c = new Cell(0, new Ponto(1,1));c.setVizinhos(3);
        List<Cell> l = new List<Cell>();l.add(c);
        p=new Ponto(1,2);
        LinkedListCircular<Ponto> llc1 = new LinkedListCircular<Ponto>();
        r=new Cell(0, new Ponto(1,1));r.setVizinhos(4);
         t=(Cell)b.neighboors_cell(c, l, p, llc1);
        //System.out.println(r.equals(t));
        assertEquals(true,r.equals(t));

    }
    //----------------------------------------test Col-----------------------------------------
    @Test
    public void testCol(){
        LinkedListCircular<Cell> l=new LinkedListCircular<Cell>();
        l.Col(new LinkedListCircular<Cell>());

        LinkedListCircular<String> l1=new LinkedListCircular<String>();
        l1.Col(new LinkedListCircular<String>());

        LinkedListCircular<Ponto> l2=new LinkedListCircular<Ponto>();
        l2.Col(new LinkedListCircular<Cell>());
    }
    //----------------------------------------test CellAlreadyExist--------------------------
    @Test
    public void TestCellAlreadyExist(){
        Board b=new Board();
        List<Cell> l=new List<Cell>();
        Cell c=new Cell(1,new Ponto(1,1));
        assertEquals(c,b.CellAlreadyExisted(l, c));

        l.add(c);
        Cell c1=new Cell(0,new Ponto(1,1));
        assertEquals(c, b.CellAlreadyExisted(l, c1));

        Cell c2=new Cell(0,new Ponto(1,2));
        assertEquals(c2, b.CellAlreadyExisted(l, c2));
    }

    //------------------------------------test createsentinels------------------------------
    @Test
    public void Testcreatesentinels(){
        Board b=new Board();
        LinkedListCircular<Ponto> h=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> hcol=new LinkedListCircular<Ponto>();
        b.createsentinels(5, 5, h, hcol);
        assertEquals(5, h.size());assertEquals(5, hcol.size());

        LinkedListCircular<Cell> h1=new LinkedListCircular<Cell>();
        LinkedListCircular<Cell> hcol1=new LinkedListCircular<Cell>();
        b.createsentinels(10, 5, h1, hcol1);
        assertEquals(10, h1.size());assertEquals(5, hcol1.size());

        LinkedListCircular<String> h2=new LinkedListCircular<String>();
        LinkedListCircular<String> hcol2=new LinkedListCircular<String>();
        b.createsentinels(1, 5, h2, hcol2);
        assertEquals(1, h2.size());assertEquals(5, hcol2.size());
    }

    //----------------------------test newCells (Board)--------------------------------------

    @Test
    public void TestnewCells(){
        Board b=new Board();
        LinkedListCircular<Ponto> g=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> g1=new LinkedListCircular<Ponto>();g.Col(g1);
        Cell c=new Cell(1,new Ponto(0,0));c.setVizinhos(3);
        b.newCells(c,g);
        assertEquals(1, g.size());assertEquals(1, g1.size());

        c=new Cell(0,new Ponto(-1,-1));c.setVizinhos(3);
        b.newCells(c,g);
        assertEquals(2, g1.size());assertEquals(2, g.size());

        c=new Cell(0,new Ponto(0,0));c.setVizinhos(4);
        b.newCells(c,g);
        assertEquals(2, g1.size());assertEquals(2, g.size());
    }

    //----------------------------test set (board)---------------------------------------
    @Test
    public void testsetBoard(){
        Board b=new Board();
        int[][] n=new int[][]{
            {0,1},
            {1,0}
        };
        b.set(n);
        //assertEquals("", actual);
    }

    //------------------------test size & add------------------------------------
    @Test
    public void testaddandsize(){
        List<String> h=new List<String>();
        assertEquals(0, h.size());
        h.add("d");
        assertEquals(1, h.size());
        h.add("d");
        assertEquals(2, h.size());
    }

    //-----------------------------test clear------------------------------
    @Test
    public void testclear(){
        List<String> h=new List<String>();
        h.add("d");
        h.add("d");
        h.clear();
        assertEquals(0,h.size());
        h.clear();
        assertEquals(0,h.size());
        h.add("d");
        h.clear();
        assertEquals(0,h.size());
    }
    //----------------------------test remove---------------------------
    @Test
    public void testremove(){
        List<String> h=new List<String>();
        h.add("a");
        h.add("b");
        h.add("c");
        h.remove("a");
        assertEquals(2,h.size());
        h.remove("b");
        assertEquals(1, h.size());
        h.remove("c");
        assertEquals(0,h.size());
    }

    @Test
    public void testremoveindex(){
        List<String> h=new List<String>();
        h.add("a");
        h.add("b");
        h.add("c");
        h.removeindex(1);
        assertEquals(2,h.size());
        h.removeindex(0);
        assertEquals(1, h.size());
        h.removeindex(0);;
        assertEquals(0,h.size());
    }

    //------------------------------------test contains-------------------------------
    @Test
    public void testcontains(){
        List<Integer> g=new List<Integer>();
        g.add(1);
        g.add(2);
        //System.out.println(g.contains("f", 1));
        assertEquals(true,g.contains(1));
        assertEquals(false,g.contains(3));
        assertEquals(true,g.contains(2));
    }
    //-----------------------------------test clone---------------------------
    @Test
    public void testclone(){
        List<String> g=new List<String>();
        List<String> g1=new List<String>();
        g.add("skajhsa");
        g.add("f");
        g1=g.clone();
        assertEquals(true,g.toString().equals(g1.toString()));
        g.clear();
        g.add("f");
        assertEquals(false,g.toString().equals(g1.toString()));
        g.clear();g1.clear();
        assertEquals(true, g.toString().equals(g1.toString()));
    }
    //------------------------------------test addline & addfirstline & size ------------------
    @Test
    public void testaddline(){
        LinkedListCircular<Ponto> p=new LinkedListCircular<Ponto>();
        assertEquals(0, p.size());
        p.addLine();
        p.addLine();
        assertEquals(2, p.size());
        p.addfirstLine();
        assertEquals(3,p.size());
    }

    //-----------------------------------test getlasline & getLinha---------------------------
    @Test
    public void testgetlastline(){
        LinkedListCircular<Ponto> p=new LinkedListCircular<Ponto>();
        p.addLine();
        assertEquals(true,p.getlastLine().equals(p.getLinha(0)));
        p.addLine();
        assertEquals(false,p.getlastLine().equals(p.getLinha(0)));
        assertEquals(true,p.getlastLine().equals(p.getLinha(1)));
    }
    //------------------------------------test getfirstLine & getLinha-------------------------
    @Test
    public void testgetfirstline(){
        LinkedListCircular<Ponto> p=new LinkedListCircular<Ponto>();
        p.addLine();
        assertEquals(true,p.getfirstLine().equals(p.getLinha(0)));
        p.addLine();
        assertEquals(false,p.getfirstLine().equals(p.getLinha(1)));
        assertEquals(false,p.getfirstLine().equals(p.getLinha(1)));
    }
    //----------------------------------test getfirstindex && associateTo-------------------------
    @Test(expected = IndexOutOfBoundsException.class)
    public void testgetfirstindex(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();k1.addLine();
        k.associateTo(0, 0, new Ponto(0,0));
        assertEquals(0, k.getfirstIndex());
        k1.addfirstLine();
        k.associateTo(1, 0, new Ponto(0,1));
        assertEquals(-1, k.getfirstIndex());
    }
    //--------------------------------test clear-------------------------
    @Test
    public void testclearLinkedList(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();k1.addLine();
        k.clear();
        assertEquals(0,k.size());
        assertEquals(true, k1.size()==1);
        k1.clear();
        assertEquals(true, k1.size()==0);
    }

    //------------------------------test associationTO & removeassiciationOf & addline---------
    @Test
    public void testremoveassociationOf(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();
        k.addLine();k1.addLine();k.addLine();k1.addLine();
        k.associateTo(0, 0, new Ponto(0,0));
        k.associateTo(0, 1, new Ponto(0,1));
        k.removeAssociationOf(new Ponto(0,1), 0);
        //System.out.println(((Ponto)k.getfirstElementOf(0)).equals(new Ponto(0,0)));
        assertEquals(true,((Ponto)k.getfirstElementOf(0)).equals(new Ponto(0,0)));
        k.associateTo(0, 1, new Ponto(0,1));
        k.removeAssociationOf(new Ponto(0,0), 0);
       // System.out.println(k.printListrow());
        assertEquals(true,((Ponto)k.getfirstElementOf(0)).equals(new Ponto(0,1)));
        k.removeAssociationOf(new Ponto(0,1), 0);
        assertEquals(false, k.getfirstElementOf(0).equals(new Ponto(0,0)));
    }
    //---------------------------------test nextCellHorizon & association & addline-------------------
    @Test
    public void testnextCellhorizon(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();
        k.addLine();k1.addLine();k1.addLine();
        Ponto p=new Ponto(0,0);Ponto p1=new Ponto(0,1);
        k.associateTo(0, 0, p);
        k.associateTo(0, 1, p1);
        //System.out.println(k.nextcellHorizon(p,0));
        assertEquals(p1,(Ponto)k.nextcellHorizon(p,0));
        assertEquals(false,k.nextcellHorizon(p1,0) instanceof Ponto);
        k1.addLine();
        Ponto p2=new Ponto(0,2);
        k.associateTo(0, 2, p2);
        assertEquals(p2,k.nextcellHorizon(p1,0));
    }
    //-----------------------------------test nextcellVertical-----------------------
    @Test
    public void testnextCellvertical(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();
        k1.addLine();k.addLine();k1.addLine();
        Ponto p=new Ponto(0,0);Ponto p1=new Ponto(1,0);
        k.associateTo(0, 0, p);
        k.associateTo(1, 0, p1);
        //System.out.println(k.nextcellvertical(p, 0));
        assertEquals(p1,(Ponto)k.nextcellvertical(p,0));
        assertEquals(false,k.nextcellvertical(p1,0) instanceof Ponto);
        k.addLine();
        Ponto p2=new Ponto(2,0);
        k.associateTo(2, 0, p2);
        //System.out.println(k.nextcellvertical(p1, 0));
        assertEquals(p2,k.nextcellvertical(p1,0));
    }
    //-------------------------------------test contains-----------------------
    @Test
    public void testcontainsLinkedList(){
        LinkedListCircular<Ponto> k=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> k1=new LinkedListCircular<Ponto>();
        k.Col(k1);
        k.addLine();
        k.addLine();k1.addLine();k1.addLine();
        k.associateTo(0, 0, new Ponto(0,0));
        k.associateTo(0, 1, new Ponto(0,1));
        assertEquals(true, k.contains(new Ponto(0,0),0));
        assertEquals(false, k.contains(new Ponto(1,0),0));
        assertEquals(true, k.contains(new Ponto(0,1),0));
    }
    //-----------------------------------test child-------------------------------
    @Test
    public void testchild(){
        Board b=new Board();
        LinkedListCircular<Ponto> g=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> g1=new LinkedListCircular<Ponto>();
        g.Col(g1);
        g.addLine();g.addLine();g1.addLine();g1.addLine();
        Ponto p=new Ponto(0,1);Ponto p1=new Ponto(1,0);
        g.associateTo(0, 1, p);g.associateTo(1, 0, p1);
        b.setcol(g1);b.setrow(g);
        b.child();
        g=b.getrow();g1=b.getcol();
        assertEquals(false,g.getfirstElementOf(0) instanceof Ponto);
        assertEquals(false,g.getfirstElementOf(1) instanceof Ponto);

         g=new LinkedListCircular<Ponto>();
         g1=new LinkedListCircular<Ponto>();
        g.Col(g1);
        g.addLine();g.addLine();g1.addLine();g1.addLine();
         p=new Ponto(0,0); p1=new Ponto(0,1);
        g.associateTo(0, 0, p);g.associateTo(0, 1, p1);
        b.setcol(g1);b.setrow(g);
        b.child();
        g=b.getrow();g1=b.getcol();
        assertEquals(false,g.getfirstElementOf(0) instanceof Ponto);

    }
    //-----------------------------------test getboard----------------------------
    @Test
    public void testgetboard(){
        Board b=new Board();
        LinkedListCircular<Ponto> g=new LinkedListCircular<Ponto>();
        LinkedListCircular<Ponto> g1=new LinkedListCircular<Ponto>();
        g.Col(g1);
        g.addLine();g.addLine();g1.addLine();g1.addLine();
        Ponto p=new Ponto(0,1);Ponto p1=new Ponto(1,0);
        g.associateTo(0, 1, p);g.associateTo(1, 0, p1);
        b.setcol(g1);b.setrow(g);
        b.child();
        int[][] r=new int[][]{
            {0,0},
            {0,0}
        };
        assertEquals(false,b.get().equals(r));
         g=new LinkedListCircular<Ponto>();
         g1=new LinkedListCircular<Ponto>();
        g.Col(g1);
        g.addLine();g.addLine();g1.addLine();g1.addLine();
         p=new Ponto(0,0); p1=new Ponto(0,1);
        g.associateTo(0, 0, p);g.associateTo(0, 1, p1);
        b.setcol(g1);b.setrow(g);
        b.child();
        r=new int[][]{
            {0,0}
        };
        assertEquals(false,b.get().equals(r));
    }
}