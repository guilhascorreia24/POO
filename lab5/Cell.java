public class Cell{

private int STATE;

public Cell(int state){
    this.STATE = state;
}

public int getCell() {
    return STATE;
  }

  public void setCell(int newValue) {
    this.STATE = newValue;
  }

public int isAlive(){

    if(this.getCell() == 1)
        return 1;

    return 0;
}

public int isDead(){

    if(this.getCell() == 1)
        return 0;

    return 1;
}

public int isBorn(){

    if(this.getCell() == 0){
        this.setCell(1);
    }
    return 0;
}
}