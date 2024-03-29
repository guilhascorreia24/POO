/**
 * @version 2.4
 * @author Guilherme Correia 61098
 * @author David Fernandes 58604
 * @author Bruno Susana 61024
 */
public class GOL{
    private int[][] m;
    private int times;
    private iMatrix g=new Board();
    /**
     * este construtor transforma a lista em uma matriz composta por 0 e 1 identico ao input
     * no fim limpa a lista usada
     * @pre o input nao pode ser vazio e o numero de itercoes nao pode ser menor ou igual a 0
     * @param l lista das linhas lidas no input (tipo String)
     * @param times numero lido no input (tipo int)
     * @throws Exception lancada quando nao é respeitado um todos inputs
     */
	public GOL(List<String> l,int times) throws Exception {
        if(l.size()==0){
            throw new IllegalArgumentException();
        }
        if(times<=0){
            throw new IllegalArgumentException();
        }
        this.times=times;
        String n1=(String)l.getfirstElementOf(0);
        int n=n1.split("").length;
        m=new int[l.size()][n];
        for(int i=0;i<l.size();i++){
            String[] s=((String) l.getfirstElementOf(i)).split("");
            if(s.length>n) throw new IllegalArgumentException();
            for(int j=0;j<n;j++){
                m[i][j]=Integer.parseInt(s[j]);
            }
        }
        l.clear();
    }

    /**
     * esta funcao, indica o decorrer do jogo em que cada iteracao imprimir o estado do jogo
     */
    public void run(){
        int i=0;
        while(i<times){
            g.set(m);
            m=g.get();
            printBoards(m);
            if(i<times-1)
                System.out.println();
            i++;
        }
        
    }

    /**
     * esta funcao imprimir o estado do jogo numa certeza iteracao
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