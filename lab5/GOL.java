public class GOL{
    private int[][] m;
    private int times;
	public GOL(List<String> l,int times) throws Exception {
        if(l.size()==0){
            throw new IllegalArgumentException();
        }
        if(times==0){
            throw new IllegalAccessException();
        }
        this.times=times;
        String n1=(String)l.getfirstElementOf(0);
        int n=n1.split("").length;
        m=new int[l.size()][n];
        for(int i=0;i<l.size();i++){
            for(int j=0;j<n;j++){
                String s=(String)l.getfirstElementOf(i);
                s=s.split("")[j];
                m[i][j]=Integer.parseInt(s);
            }
        }
        l.clear();
    }
    public void run(){
        Board g=new Board();
        int i=0;
        while(i<times){
            g.set(m);
            g.child();
            m=g.get();
            printBoards(m);
            i++;
        }
        
    }

    private void printBoards(int[][] g1) {
            for(int i=0;i<g1.length;i++){
                for(int j=0;j<g1[i].length;j++){
                        System.out.print(g1[i][j]); 
                }
                System.out.println();
            }
            System.out.println();
    }
}