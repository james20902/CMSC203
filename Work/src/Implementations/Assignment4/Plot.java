package Implementations.Assignment4;

public class Plot {
  //instance variables
  private int x, y, width, depth;

  //default no argument constructor
  public Plot(){
    x = 0;
    y = 0;
    width = 1;
    depth = 1;
  }

  //copy argument plot
  public Plot(Plot p){
    x = p.getX();
    y = p.getY();
    width = p.getWidth();
    depth = p.getDepth();
  }

  //standard constructors
  public Plot(int x, int y, int width, int depth){
    this.x = x;
    this.y = y;
    this.width = width;
    this.depth = depth;
  }

  public boolean overlaps(Plot p){

    return false;
  }

  public boolean encompasses(Plot p){
    //assumes two sides are within bounds
    boolean coordWithinBounds = (x >= p.getX()) && (y <= p.getY());
    return false;
  }


  public void setX(int x){
    this.x = x;
  }

  public int getX(){
    return x;
  }

  public void setY(int y){
    this.y = y;
  }

  public int getY(){
    return y;
  }

  public void setWidth(int width){
    this.width = width;
  }

  public int getWidth(){
    return width;
  }

  public void setDepth(int depth){
    this.depth = depth;
  }

  public int getDepth(){
    return depth;
  }

  @Override
  public String toString(){
    return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
  }

}
