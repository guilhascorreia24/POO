import static org.junit.Assert.assertEquals;
import org.junit.Test;

import LinkedListCircular.DataNode;

public class Tests {
    	//-----------------------Teste connstrutor Ponto------------------------------
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
        s.add("01010");s.add("10000");
        new GOL(s,5);
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

    @Test(expected = IllegalArgumentException.class)
    public void testCell(){
        Ponto p=new Ponto(1,1);
        new Cell(0,p);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCell1(){
        Ponto p=new Ponto(-1,-1);
        new Cell(-1,p);
    }

    @Test(expected = IllegalArgumentException.class)
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
    @Test
    public void testequals(){
        Ponto p=new Ponto(1,1);
        Cell c=new Cell(1,p);
        c.setVizinhos(3);
        assertEquals(false, c.equals(null));

        Ponto p1=new Ponto(1,1);
        Cell c1=new Cell(0,p);
         c1.setVizinhos(0);
        assertEquals(false, c.equals(c));

        Ponto p3=new Ponto(1,1);
        Cell c3=new Cell(1,p);
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
        Cell r=new Cell(0, new Ponto(1,1));r.setVizinhos(1);
        assertEquals(r,b.neighboors_cell(c, myline, p, llc));

        c = new Cell(0, new Ponto(1,2));
        List<Cell> l = new List<Cell>();l.add(c);
        p=new Ponto(1,2);
        LinkedListCircular<Ponto> llc1 = new LinkedListCircular<Ponto>();
        r=new Cell(0, new Ponto(1,1));r.setVizinhos(1);
        assertEquals(r,b.neighboors_cell(c, l, p, llc1));


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
}