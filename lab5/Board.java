

public class Board implements iMatrix {
	private LinkedListCircular row = new LinkedListCircular();
	private LinkedListCircular col = new LinkedListCircular();

	public void child() {

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
		int cols = m[0].length, rows = m.length, i = 0, j = 0;
		createsentinels(rows,cols);
		while (i < rows || j < cols) {
			while(i < cols) {
				
			}
		}
	}

	@Override
	public int[][] get() {
		return null;
	}
}
