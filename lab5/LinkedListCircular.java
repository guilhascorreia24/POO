/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class LinkedListCircular<T> implements MyList{
    private SentinelNode head, last;
    private int i,inicial;
    private boolean row;
    private LinkedListCircular<T> col;

    /**
     * @inv head indica a cabeca da lista
     * @inv last indica o ultimo elemento da linkedlist
     * @inv i indica o tamanho da lista
     * @inv inicial indica o index do 1 elemento
     * @inv row indica se e uma lista de nos sentinel vertical
     * @inv col linkedlistCircular que indica as colunas associada a linkedlistCircular das linhas
     * incia a lista indicado que se orienta pelos nos verticais
     */
    public LinkedListCircular() {
        this.row = true;
    }

    /**
     * inicia a a lista que se orientara pelos nos horizontais 
     */
    @SuppressWarnings("unchecked")
    public void Col(LinkedListCircular<?> b) {
        this.col = (LinkedListCircular<T>) b;
        col.row = false;
    }

    /*-----------------------------------------Nodes----------------------*/
    public static class Node {
        private Node E, S;

        /**
         * inicializa o no
         * @inv E no de Este
         * @inv S no de Sul
         * @param E no Este
         * @param S no Sul
         */
        public Node(Node E, Node S) {
            this.E = E;
            this.S = S;
        }

        /**
         * devolve o no Este
         * @return devolve o no de Este
         */
        public Node getE() {
            return this.E;
        }

        /**
         * devolve o no Sul
         * @return devolve o no de Sul
         */
        public Node getS() {
            return this.S;
        }

        /**
         * altera o no de Este
         * @param e no de Este
         * 
         */
        public void setE(Node e) {
            this.E = e;
        }

        /**
         * altera o no do Sul
         * @param S no do Sul
         * 
         */
        public void setS(Node s) {
            this.S = s;
        }
    }

    public static class SentinelNode extends Node {
        private SentinelNode next;

        /**
         * inicializa o SentinelNode 
         * @inv next proximo no sentinel
         * @param E no de Este
         * @param S no do Sul
         * @param next proximo no sentinel
         */
        public SentinelNode(Node E, Node s, SentinelNode next) {
            super(E, s);
            this.next = next;
        }

        /**
         * devolve o proximo no sentinela
         * @return devolve o proximo no sentinel associado
         */
        public SentinelNode getnext() {
            return this.next;
        }

        /**
         * Altera o no de Este
         * @param E no de Este
         */
        @Override
        public void setE(Node e) {
            super.setE(e);
        }

        /**
         * imprime o no 
         */
        public String toString() {
            return "sent";
        }

        /**
         * devolve o no Este
         * @return devolve o no de Este
         */
        @Override
        public Node getE() {
            return super.E;
        }

        /**
         * devolve o no Sul
         * @return devolve o no do Sul
         */
        @Override
        public Node getS() {
            return super.S;
        }

		public void setnext(SentinelNode e) {
            this.next=e;
		}
    }

    public static class DataNode<T> extends Node {
        private T value;

        /**
         * incializa o No de dados
         * @inv value e do tipo generico
         * @param E no associado de Este
         * @param S no associado do Sul
         * @param value dado do no
         */
        public DataNode(Node E, Node S, T value) {
            super(E, S);
            this.value = value;
        }

        /**
         * imprime o valor do no
         */
        public String toString() {
            return String.valueOf(value);
        }

        /**
         * devolve o valor do no
         * @return devolve o valor do no
         */
        public T getvalue() {
            return this.value;
        }

        /**
         * altera o valor do no
         * @param value valor para o qual queremos mudar
         */
        public void setValue(T value) {
            this.value = value;
        }

        /**
         * devolve o no este
         * @return devolve o no que esta associado a Este
         */
        @Override
        public Node getE() {
            return super.E;
        }

        /**
         * devolve o no Sul
         * @return devolve o no que esta associado a Sul
         */
        @Override
        public Node getS() {
            return super.S;
        }

    }
    /*---------------------------------------------end Nodes-----------------------------------*/

    /**
     * adiciona o um no sentinel a LinkedListCircular
     */
    public void addLine() {
        SentinelNode l = new SentinelNode(null, null, null);
        if (row)
            l.setE(l);
        else
            l.setS(l);
        if (head == null) {
            this.inicial=0;
            head = l;
        } else {
            last.next = l;
        }
        last = l;
        last.next = head;
        i++;
    }

    /**
     * adiciona a LinkedListCircular um sentinel Node na primeira posicao da lista
     */
    public void addfirstLine() {
        SentinelNode l = new SentinelNode(null, null, null);
        if(row) l.setE(l);
        else l.setS(l);
        last.next = l;
        Node k = head;
        head = l;
        head.next = (SentinelNode) k;
        i++;
        this.inicial-=1;
    }

    /*---------------------------------------------end add----------------------------------------------------*/

    /**
     * devolve o ultimo no da lista
     * @return devolve o no que esta na ultima posicao da linkedlist
     */
    public Node getlastLine() {
        SentinelNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        return last;
    }

    public Node getfirstLine() {
        return head;
    }

    /**
     * encontra o index do s na linkedListCircular associado neste a coluna em que se encontra
     * @param s objecto que queremos encontrar
     * @param linhadoobjecto linha que queremos precorrer
     * @return devolve o objecto ou -1 no caso de nao encontrar
     */
    @SuppressWarnings("rawtypes")
    public int getindexOf(T s, int linhadoobjecto) {
        Node n = getLinha(linhadoobjecto).getE();
        int i = 0;
        while (n instanceof DataNode) {
            DataNode k = (DataNode) n;
            if (k.getvalue().equals(s)) {
                return i;
            }
            n = n.getE();
            i++;
        }
        return -1;
    }

    /**
     * encontra o no da linha index
     * @param index linha que queremos 
     * @return no que esta associado ao index
     */
    public Node getLinha(int index) {
        if (index >= size())
            throw new IndexOutOfBoundsException();
        int o = 0;
        SentinelNode curr = head;
        while (o < index) {
            curr = curr.next;
            o++;
        }
        return curr;
    }

    /**
     * devolve o index do primeiro no
     * @return devolve o index do primeiro no
     */
    public int getfirstIndex(){
        return inicial;
    }

    /**
     * encontra o primeiro no de dados da linha i
     * @param i index do no sentinel
     * @return devolve o valor do primeiro no de dados que esta na linha
     */
    @Override
    @SuppressWarnings("rawtypes")
    public Object getfirstElementOf(int i) {
        Node n = getLinha(i);
        if (n.getE() instanceof DataNode) {
            DataNode o = (DataNode) getLinha(i).getE();
            return o.getvalue();
        }
        return n;
    }

    /**
     * devolve o valor do no dados que esta na coluna j e na linha i
     * @param i linha onde se encontra
     * @param j coluna onde se encontra
     * @return devolve o objecto caso encontre senao devolve o no sentinela
     */
    @SuppressWarnings("unchecked")
    public Object getElementof(int i, int j) {
        Object o = getfirstElementOf(i);
        int k = 0;
        while (k < j) {
            if (k == j) {
                return o;
            }
            k++;
            o = nextcellHorizon((T) o, i);
        }
        return o;
    }

    /**
     * devolve a linkedlist associada
     * @return devolve a linkedList associada
     */
    public LinkedListCircular<T> getColList() {
        return col;
    }

    /*----------------------------------------------------end gets------------------------------------------------*/
    /**
     * tamanho da linkedListcircular
     * @return devolve o tamanho da LinkedListCircular
     */
    public int size() {
        return i;
    }
    /*------------------------------------------------------end size-------------------------------------------*/
    /**
     * Limpa a LinkedListCircular isto é volta a ser nula
     */
    @Override
    public void clear() {
        SentinelNode g = (SentinelNode) head.getnext();
        while (g != head) {
            SentinelNode h = g;
            g = null;
            i--;
            g = h.getnext();
        }
        head = null;
        i--;
    }

    /**
     * remove um objecto p da linha i
     */
    @SuppressWarnings("rawtypes")
    public void removeAssociationOf(Object p, int i) {
        if (contains(p, i)) {
            Node n = getLinha(i);
            while (n.getE() instanceof DataNode) {
                Node o = n.getE();
                if (o instanceof DataNode) {
                    if (((DataNode) o).getvalue().toString().equals(p.toString()))
                        n.setE(o.getE());
                }
                n = n.getE();
            }
        }
    }

    /**
     * Associar um objecto p queremos associar as 2 LinkedListCircular colunas e a das linhas que exista
     * @prev o numero da linha e coluna tem estar nas LinkedList respetivas
     * @param i linha da LinkedListCircular
     * @param j coluna da LinkedListCircular
     * @param p Objecto que queremos associar
     * @throws e lancado quando o numero da linha ou coluna nao esta na LinkedList
     */
    @SuppressWarnings("unchecked")
    public void associateTo(int i, int j,Object p) {
        if(i>=size() || j>=col.size() || i<inicial || j< col.inicial){
            throw new IndexOutOfBoundsException();
        }
        if (i < size() && i >= inicial && j < col.size() && j >= col.inicial) {
            Node s = getLinha(i);
            Node h = s;
            while (h.getE() != s) {
                h = h.getE();
            }
            Node o = new DataNode<T>(getLinha(i), null, (T)p);
            h.setE(o);
            s = col.getLinha(j);
            h = s;
            while (h.getS() != s) {
                h = h.getS();
            }
            o.setS(col.getLinha(j));
            h.setS(o);
        }
    }

    /**
     * Encontra o no que esta a seguir ao objecto x com orientacao horizontal
     * @param x objecto anterior ao pretendido
     * @param i int linha da LinkedList
     * @throws lancado quando a linha i nao existe na LinkedList
     * @return devolve o proximo valor do proximo no de dados
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object nextcellHorizon(T x, int i) {
        if(i>=size() ||  i<inicial ){
            throw new IndexOutOfBoundsException();
        }
        Node n = getLinha(i).getE();
        while (n instanceof DataNode) {
            DataNode n1 = (DataNode) n;
            if (n1.getvalue().equals(x) && n1.getE() instanceof DataNode) {
                n1 = (DataNode) n1.getE();
                return (T) n1.getvalue();
            }
            n = n.getE();
        }
        return n;
    }

    /**
     * Encontra o no que esta a seguir ao objecto x com orientacao vertical
     * @param x objecto anterior ao pretendido
     * @param i int coluna da LinkedList
     * @throws lancado quando a linha i nao existe na LinkedList
     * @return devolve o proximo valor do proximo no de dados
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object nextcellvertical(T x, int i) {
        if(i>=col.size() || i< col.inicial){
            throw new IndexOutOfBoundsException();
        }
        Node n = getLinha(i).getS();
        while (n instanceof DataNode) {
            DataNode n1 = (DataNode) n;
            if (n1.getvalue().equals(x) && n1.getS() instanceof DataNode) {
                n1 = (DataNode) n1.getS();
                return (T) n1.getvalue();
            }
            n = n.getS();
        }
        return null;
    }

    /**
     * Verifica se o objecto p na linha lineindex (orientacao horizontal)
     * @param p object objecto que queremos encontrar
     * @param lineIndex int linha da LinkedList
     * @return devolve se existe na linha ou nao
     */
    public boolean contains(Object p, int lineIndex) {
        if (lineIndex < inicial || lineIndex >= i) {
            return false;
        }
        SentinelNode n = (SentinelNode) getLinha(lineIndex);
        Node n1 = n.getE();
        while (n1 instanceof DataNode) {
            if (p.toString().equals(n1.toString())) {
                return true;
            }
            n1 = n1.getE();
        }
        return false;
    }

    // ----------------------------------------------remove-----------------------------------------------------*/

    /**
     * imprime a LinkedListCircular de orientacao horizontal de nos existentes 
     */
    private void printDataNodesrow() {
        Node g = last.getE();
        System.out.print("[ ");
        while (g instanceof DataNode) {
            System.out.print(g + " ");
            g = g.getE();
        }
        System.out.print(" ]");
    }

    /**
     * imprime a LinkedListCircular de orientacao horizontal de nos existentes 
     */
    public void printListrow() {
        last = head;

        System.out.print("LinkedListRow:\n");

        System.out.print(last + " ");
        if (last.getE() instanceof DataNode) {
            printDataNodesrow();
        }
        System.out.println();
        last = last.next;
        while (last != head) {
            System.out.print(last + " ");
            if (last.getE() instanceof DataNode) {
                printDataNodesrow();
            }
            last = last.next;
            System.out.println();
        }

        System.out.println();
    }

    /**
     * imprime a LinkedListCircular de orientacao vertical de nos existentes 
     */
    private void printDataNodescol() {
        Node g = last.getS();
        System.out.print("[ ");
        while (g instanceof DataNode) {
            System.out.print(g + " ");
            g = g.getS();
        }
        System.out.print(" ]");
    }

    /**
     * imprime a LinkedListCircular de orientacao vertical de nos existentes 
     */
    public void printListcol() {
        last = head;

        System.out.print("LinkedListCol:\n");

        System.out.print(last + " ");
        if (last.getS() instanceof DataNode) {
            printDataNodescol();
        }
        System.out.println();
        last = last.next;
        while (last != head) {
            System.out.print(last + " ");
            if (last.getS() instanceof DataNode) {
                printDataNodescol();
            }
            last = last.next;
            System.out.println();
        }

        System.out.println();
    }
    /*------------------------------------------------------------print---------------------------------------*/

}