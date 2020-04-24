import java.util.List;

public class GOL{
    private int[][] m;
	public GOL(List<String> l,int times) {
        int n=l.get(0).split("").length;
        //System.out.println(n+":"+l.size());
        m=new int[l.size()][n];
        for(int i=0;i<l.size();i++){
            for(int j=0;j<n;j++){
                String s=l.get(i).split("")[j];
                m[i][j]=Integer.parseInt(s);
            }
        }
        Board board=new Board();
        board.set(m);
	}

}