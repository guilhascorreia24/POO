/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class GOL{
    private int[][] m;
    private int times;
    /**
     * @pre o input nao pode ser vazio e o numero de itercoes nao pode ser menor ou igual a 0
     * @param l lista das linhas lidas no input (tipo String)
     * @param times numero lido no input (tipo int)
     * @throws Exception lancada quando nao é respeitado um todos inputs
     * este construtor transforma a lista em uma matriz composta por 0 e 1, identico ao input
     * no fim limpa a lista usada
     */
	public GOL(List<String> l,int times) throws Exception {
        if(l.size()==0){
            throw new IllegalArgumentException();
        }
        if(times<=0){
            throw new IllegalAccessException();
        }
        this.times=times;
        String n1=(String)l.getfirstElementOf(0);
        int n=n1.split("(\\s+)|").length;
        m=new int[l.size()][n];
        for(int i=0;i<l.size();i++){
            String s=(String)l.getfirstElementOf(i);
            for(int j=0;j<n;j++){
                m[i][j]=Character.digit(s.charAt(j),10);
            }
        }
        l.clear();
    }

    /**
     * esta funcao, indica o decorrer do jogo, em que cada iteraçao imprimir o estado do jogo
     */
    public void run(){
        Board g=new Board();
        int i=0;
        while(i<times){
            g.set(m);
            g.child();
            m=g.get();
            printBoards(m);
            if(i<times-1)
                System.out.println();
            i++;
        }
        
    }

    /**
     * esta funcao imprimir o estado do jogo numa certeza itercao
     * @param g1 matriz do estado do jogo
     */
    private void printBoards(int[][] g1) {
            for(int i=0;i<g1.length;i++){
                for(int j=0;j<g1[i].length;j++){
                        System.out.print(g1[i][j]); 
                }
                System.out.println();
            }
    }
}